package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.language.bm.ResourceConstants;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes4.dex */
public abstract class Uri implements Comparable<Uri> {
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final int NOT_CALCULATED = -2;
    public static final int NOT_FOUND = -1;
    public static final String NOT_CACHED = new String("NOT CACHED");
    public static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    @Nullable
    public abstract String getEncodedAuthority();

    @Nullable
    public abstract String getScheme();

    public abstract boolean isHierarchical();

    public abstract boolean isRelative();

    public abstract String toString();

    /* loaded from: classes4.dex */
    public static class Part extends AbstractPart {
        public static final Part NULL = new EmptyPart(null);
        public static final Part EMPTY = new EmptyPart("");

        public boolean isEmpty() {
            return false;
        }

        /* loaded from: classes4.dex */
        public static class EmptyPart extends Part {
            @Override // com.baidu.searchbox.v8engine.net.Uri.Part
            public boolean isEmpty() {
                return true;
            }

            public EmptyPart(String str) {
                super(str, str);
            }
        }

        public String getEncoded() {
            boolean z;
            if (this.encoded != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded);
            this.encoded = encode;
            return encode;
        }

        public Part(String str, String str2) {
            super(str, str2);
        }

        public static Part from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            if (str2 == null) {
                return NULL;
            }
            if (str2.length() == 0) {
                return EMPTY;
            }
            return new Part(str, str2);
        }

        public static Part fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        public static Part fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }

        public static Part nonNull(Part part) {
            if (part == null) {
                return NULL;
            }
            return part;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class AbstractHierarchicalUri extends Uri {
        public AbstractHierarchicalUri() {
            super();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.searchbox.v8engine.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        public String parseAuthority() {
            String substring;
            String str;
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null) {
                return null;
            }
            int lastIndexOf = encodedAuthority.lastIndexOf(64);
            int indexOf = encodedAuthority.indexOf(58, lastIndexOf);
            if (indexOf == -1) {
                substring = encodedAuthority.substring(lastIndexOf + 1);
            } else {
                substring = encodedAuthority.substring(lastIndexOf + 1, indexOf);
            }
            if (lastIndexOf != -1) {
                str = encodedAuthority.substring(0, lastIndexOf) + "@";
            } else {
                str = "";
            }
            String str2 = str + a.b(substring);
            if (indexOf != -1) {
                return str2 + encodedAuthority.substring(indexOf + 1);
            }
            return str2;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class AbstractPart {
        public volatile String decoded;
        public volatile String encoded;

        public AbstractPart(String str, String str2) {
            this.encoded = str;
            this.decoded = str2;
        }
    }

    /* loaded from: classes4.dex */
    public static class AuthorityPart extends AbstractPart {
        public static final AuthorityPart NULL = new AuthorityPart(null, null);
        public static final AuthorityPart EMPTY = new AuthorityPart("", "");

        public String getEncoded() {
            boolean z;
            if (this.encoded != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded);
            this.encoded = encode;
            return encode;
        }

        public AuthorityPart(String str, String str2) {
            super(str, str2);
        }

        public static AuthorityPart from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            return new AuthorityPart(str, str2);
        }

        public static AuthorityPart fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public Part fragment;
        public Part opaquePart;
        public PathPart path;
        public Part query;
        public String scheme;

        private boolean hasSchemeOrAuthority() {
            if (this.scheme != null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return build().toString();
        }

        public Builder appendQueryParameter(String str, String str2) {
            this.opaquePart = null;
            String str3 = Uri.encode(str, null) + "=" + Uri.encode(str2, null);
            Part part = this.query;
            if (part == null) {
                this.query = Part.fromEncoded(str3);
                return this;
            }
            String encoded = part.getEncoded();
            if (encoded != null && encoded.length() != 0) {
                this.query = Part.fromEncoded(encoded + "&" + str3);
            } else {
                this.query = Part.fromEncoded(str3);
            }
            return this;
        }

        public Uri build() {
            if (this.opaquePart != null) {
                if (this.scheme != null) {
                    return new OpaqueUri(this.scheme, this.opaquePart, this.fragment);
                }
                throw new UnsupportedOperationException("An opaque URI must have a scheme.");
            }
            PathPart pathPart = this.path;
            if (pathPart != null && pathPart != PathPart.NULL) {
                if (hasSchemeOrAuthority()) {
                    pathPart = PathPart.makeAbsolute(pathPart);
                }
            } else {
                pathPart = PathPart.EMPTY;
            }
            return new HierarchicalUri(this.scheme, pathPart, this.query, this.fragment);
        }

        public Builder fragment(Part part) {
            this.fragment = part;
            return this;
        }

        public Builder path(PathPart pathPart) {
            this.opaquePart = null;
            this.path = pathPart;
            return this;
        }

        public Builder query(Part part) {
            this.opaquePart = null;
            this.query = part;
            return this;
        }

        public Builder scheme(String str) {
            this.scheme = str;
            return this;
        }

        public Builder fragment(String str) {
            return fragment(Part.fromDecoded(str));
        }

        public Builder path(String str) {
            return path(PathPart.fromDecoded(str));
        }

        public Builder query(String str) {
            return query(Part.fromDecoded(str));
        }
    }

    /* loaded from: classes4.dex */
    public static class HierarchicalUri extends AbstractHierarchicalUri {
        public final AuthorityPart authority;
        public final Part fragment;
        public final PathPart path;
        public final Part query;
        public final String scheme;
        public volatile String uriString;

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            return true;
        }

        public HierarchicalUri(String str, PathPart pathPart, Part part, Part part2) {
            super();
            this.uriString = Uri.NOT_CACHED;
            this.scheme = str;
            this.authority = AuthorityPart.NULL;
            this.path = pathPart == null ? PathPart.NULL : pathPart;
            this.query = Part.nonNull(part);
            this.fragment = Part.nonNull(part2);
        }

        private void appendSspTo(StringBuilder sb) {
            String parseAuthority = parseAuthority();
            if (parseAuthority != null) {
                sb.append(ResourceConstants.CMT);
                sb.append(parseAuthority);
            }
            String encoded = this.path.getEncoded();
            if (encoded != null) {
                sb.append(encoded);
            }
            if (!this.query.isEmpty()) {
                sb.append(RFC1522Codec.SEP);
                sb.append(this.query.getEncoded());
            }
        }

        private String makeUriString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append(':');
            }
            appendSspTo(sb);
            if (!this.fragment.isEmpty()) {
                sb.append('#');
                sb.append(this.fragment.getEncoded());
            }
            return sb.toString();
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            return this.authority.getEncoded();
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            return this.scheme;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            if (this.scheme == null) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            boolean z;
            if (this.uriString != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.uriString;
            }
            String makeUriString = makeUriString();
            this.uriString = makeUriString;
            return makeUriString;
        }
    }

    /* loaded from: classes4.dex */
    public static class OpaqueUri extends Uri {
        public volatile String cachedString;
        public final Part fragment;
        public final String scheme;
        public final Part ssp;

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            return null;
        }

        public String getHost() {
            return null;
        }

        public String getPath() {
            return null;
        }

        public String getQuery() {
            return null;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            return false;
        }

        public OpaqueUri(String str, Part part, Part part2) {
            super();
            this.cachedString = Uri.NOT_CACHED;
            this.scheme = str;
            this.ssp = part;
            this.fragment = part2 == null ? Part.NULL : part2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.searchbox.v8engine.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        public String getEncodedSchemeSpecificPart() {
            return this.ssp.getEncoded();
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            return this.scheme;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            if (this.scheme == null) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            boolean z;
            if (this.cachedString != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.cachedString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append(':');
            sb.append(getEncodedSchemeSpecificPart());
            if (!this.fragment.isEmpty()) {
                sb.append('#');
                sb.append(this.fragment.getEncoded());
            }
            String sb2 = sb.toString();
            this.cachedString = sb2;
            return sb2;
        }
    }

    /* loaded from: classes4.dex */
    public static class PathPart extends AbstractPart {
        public static final PathPart NULL = new PathPart(null, null);
        public static final PathPart EMPTY = new PathPart("", "");

        public String getEncoded() {
            boolean z;
            if (this.encoded != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded, "/");
            this.encoded = encode;
            return encode;
        }

        public PathPart(String str, String str2) {
            super(str, str2);
        }

        public static PathPart from(String str, String str2) {
            if (str == null) {
                return NULL;
            }
            if (str.length() == 0) {
                return EMPTY;
            }
            return new PathPart(str, str2);
        }

        public static PathPart fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        public static PathPart makeAbsolute(PathPart pathPart) {
            boolean z;
            String str;
            String str2;
            String str3;
            boolean z2 = true;
            if (pathPart.encoded != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = pathPart.encoded;
            } else {
                str = pathPart.decoded;
            }
            if (str != null && str.length() != 0 && !str.startsWith("/")) {
                if (!z) {
                    str2 = Uri.NOT_CACHED;
                } else {
                    str2 = "/" + pathPart.encoded;
                }
                if (pathPart.decoded == Uri.NOT_CACHED) {
                    z2 = false;
                }
                if (!z2) {
                    str3 = Uri.NOT_CACHED;
                } else {
                    str3 = "/" + pathPart.decoded;
                }
                return new PathPart(str2, str3);
            }
            return pathPart;
        }
    }

    /* loaded from: classes4.dex */
    public static class StringUri extends AbstractHierarchicalUri {
        public AuthorityPart authority;
        public volatile int cachedSsi;
        public volatile String scheme;
        public final String uriString;

        public StringUri(String str) {
            super();
            this.cachedSsi = -2;
            this.scheme = Uri.NOT_CACHED;
            if (str != null) {
                this.uriString = str;
                return;
            }
            throw new NullPointerException("uriString");
        }

        private String encodeAuthority(String str) {
            String substring;
            String str2;
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int lastIndexOf = str.lastIndexOf(64);
            int indexOf = str.indexOf(58, lastIndexOf);
            if (indexOf == -1) {
                substring = str.substring(lastIndexOf + 1);
            } else {
                substring = str.substring(lastIndexOf + 1, indexOf);
            }
            if (lastIndexOf != -1) {
                str2 = Uri.encode(str.substring(0, lastIndexOf)) + "@";
            } else {
                str2 = "";
            }
            String str3 = str2 + a.b(substring);
            if (indexOf != -1) {
                return str3 + str.substring(indexOf + 1);
            }
            return str3;
        }

        private int findSchemeSeparator() {
            if (this.cachedSsi == -2) {
                int indexOf = this.uriString.indexOf(58);
                this.cachedSsi = indexOf;
                return indexOf;
            }
            return this.cachedSsi;
        }

        private AuthorityPart getAuthorityPart() {
            AuthorityPart authorityPart = this.authority;
            if (authorityPart == null) {
                AuthorityPart fromEncoded = AuthorityPart.fromEncoded(encodeAuthority(parseAuthority(this.uriString, findSchemeSeparator())));
                this.authority = fromEncoded;
                return fromEncoded;
            }
            return authorityPart;
        }

        private String parseScheme() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return null;
            }
            return this.uriString.substring(0, findSchemeSeparator);
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getEncodedAuthority() {
            return getAuthorityPart().getEncoded();
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String getScheme() {
            boolean z;
            if (this.scheme != Uri.NOT_CACHED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return this.scheme;
            }
            String parseScheme = parseScheme();
            this.scheme = parseScheme;
            return parseScheme;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isHierarchical() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return true;
            }
            int i = findSchemeSeparator + 1;
            if (this.uriString.length() != i && this.uriString.charAt(i) == '/') {
                return true;
            }
            return false;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public boolean isRelative() {
            if (findSchemeSeparator() == -1) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.searchbox.v8engine.net.Uri
        public String toString() {
            return this.uriString;
        }

        public static String parseAuthority(String str, int i) {
            int length = str.length();
            int i2 = i + 2;
            if (length > i2 && str.charAt(i + 1) == '/' && str.charAt(i2) == '/') {
                int i3 = i + 3;
                int i4 = i3;
                while (i4 < length) {
                    char charAt = str.charAt(i4);
                    if (charAt == '#' || charAt == '/' || charAt == '?' || charAt == '\\') {
                        break;
                    }
                    i4++;
                }
                return str.substring(i3, i4);
            }
            return null;
        }
    }

    public Uri() {
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isAbsolute() {
        return !isRelative();
    }

    public boolean isOpaque() {
        return !isHierarchical();
    }

    public static String encode(String str) {
        return encode(str, null);
    }

    public static Uri parse(String str) {
        return new StringUri(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Uri uri) {
        return toString().compareTo(uri.toString());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Uri)) {
            return false;
        }
        return toString().equals(((Uri) obj).toString());
    }

    public static String encode(String str, String str2) {
        StringBuilder sb = null;
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i;
            while (i2 < length && isAllowed(str.charAt(i2), str2)) {
                i2++;
            }
            if (i2 == length) {
                if (i == 0) {
                    return str;
                }
                if (sb != null) {
                    sb.append((CharSequence) str, i, length);
                    return sb.toString();
                }
                return "";
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            if (i2 > i) {
                sb.append((CharSequence) str, i, i2);
            }
            i = i2 + 1;
            while (i < length && !isAllowed(str.charAt(i), str2)) {
                i++;
            }
            try {
                byte[] bytes = str.substring(i2, i).getBytes("UTF-8");
                int length2 = bytes.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    sb.append('%');
                    sb.append(HEX_DIGITS[(bytes[i3] & 240) >> 4]);
                    sb.append(HEX_DIGITS[bytes[i3] & 15]);
                }
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return str;
    }

    public static boolean isAllowed(char c, String str) {
        if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && "_-.*".indexOf(c) == -1 && (str == null || str.indexOf(c) == -1)))) {
            return false;
        }
        return true;
    }
}
