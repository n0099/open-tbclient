package com.baidu.searchbox.v8engine.net;

import androidx.annotation.Nullable;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes3.dex */
public final class HttpUrl {
    public static final char[] d = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final int c;
    public final String e;
    public final String f;
    @Nullable
    public final List<String> g;
    @Nullable
    public final String h;
    public final String i;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public static final String INVALID_HOST = "Invalid URL host";
        @Nullable
        public String encodedFragment;
        public final List<String> encodedPathSegments;
        @Nullable
        public List<String> encodedQueryNamesAndValues;
        @Nullable
        public String host;
        @Nullable
        public String scheme;
        public String encodedUsername = "";
        public String encodedPassword = "";
        public int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        public HttpUrl build() {
            if (this.scheme != null) {
                if (this.host != null) {
                    return new HttpUrl(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public int effectivePort() {
            int i = this.port;
            if (i == -1) {
                return HttpUrl.a(this.scheme);
            }
            return i;
        }

        public static String canonicalizeHost(String str, int i, int i2) {
            return b.a(HttpUrl.a(str, i, i2, false));
        }

        public static int parsePort(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public static int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != ':') {
                    if (charAt == '[') {
                        do {
                            i++;
                            if (i < i2) {
                            }
                        } while (str.charAt(i) != ']');
                    }
                    i++;
                } else {
                    return i;
                }
            }
            return i2;
        }

        public static int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private boolean isDot(String str) {
            if (!str.equals(".") && !str.equalsIgnoreCase("%2e")) {
                return false;
            }
            return true;
        }

        private boolean isDotDot(String str) {
            if (!str.equals(IStringUtil.TOP_PATH) && !str.equalsIgnoreCase("%2e.") && !str.equalsIgnoreCase(".%2e") && !str.equalsIgnoreCase("%2e%2e")) {
                return false;
            }
            return true;
        }

        public Builder encodedQuery(@Nullable String str) {
            List<String> list;
            if (str != null) {
                list = HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        public Builder fragment(@Nullable String str) {
            String str2;
            if (str != null) {
                str2 = HttpUrl.a(str, "", false, false, false, false);
            } else {
                str2 = null;
            }
            this.encodedFragment = str2;
            return this;
        }

        public Builder host(String str) {
            if (str != null) {
                String canonicalizeHost = canonicalizeHost(str, 0, str.length());
                if (canonicalizeHost != null) {
                    this.host = canonicalizeHost;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        public Builder query(@Nullable String str) {
            List<String> list;
            if (str != null) {
                list = HttpUrl.b(HttpUrl.a(str, " \"'<>#", false, false, true, true));
            } else {
                list = null;
            }
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            String a = HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (isDot(a)) {
                return;
            }
            if (isDotDot(a)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, a);
            } else {
                this.encodedPathSegments.add(a);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = com.baidu.searchbox.v8engine.net.b.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.v8engine.net.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            String str3;
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                List<String> list = this.encodedQueryNamesAndValues;
                if (str2 != null) {
                    str3 = HttpUrl.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            int schemeDelimiterOffset;
            int a;
            char c;
            int i;
            int a2 = b.a(str, 0, str.length());
            int b = b.b(str, a2, str.length());
            if (schemeDelimiterOffset(str, a2, b) != -1) {
                if (str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.scheme = "https";
                    a2 += 6;
                } else if (str.regionMatches(true, a2, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.scheme = "http";
                    a2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = slashCount(str, a2, b);
            char c2 = RFC1522Codec.SEP;
            char c3 = '#';
            if (slashCount < 2 && httpUrl != null && httpUrl.a.equals(this.scheme)) {
                this.encodedUsername = httpUrl.a();
                this.encodedPassword = httpUrl.b();
                this.host = httpUrl.b;
                this.port = httpUrl.c;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.c());
                if (a2 == b || str.charAt(a2) == '#') {
                    encodedQuery(httpUrl.d());
                }
            } else {
                int i2 = a2 + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = b.a(str, i2, b, "@/\\?#");
                    if (a != b) {
                        c = str.charAt(a);
                    } else {
                        c = 65535;
                    }
                    if (c == 65535 || c == c3 || c == '/' || c == '\\' || c == c2) {
                        break;
                    }
                    if (c == '@') {
                        if (!z) {
                            int a3 = b.a(str, i2, a, ':');
                            i = a;
                            String a4 = HttpUrl.a(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.encodedUsername + "%40" + a4;
                            }
                            this.encodedUsername = a4;
                            if (a3 != i) {
                                this.encodedPassword = HttpUrl.a(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = a;
                            this.encodedPassword += "%40" + HttpUrl.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c2 = RFC1522Codec.SEP;
                    c3 = '#';
                }
                int portColonOffset = portColonOffset(str, i2, a);
                int i3 = portColonOffset + 1;
                if (i3 < a) {
                    this.host = canonicalizeHost(str, i2, portColonOffset);
                    int parsePort = parsePort(str, i3, a);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, a) + Typography.quote);
                    }
                } else {
                    this.host = canonicalizeHost(str, i2, portColonOffset);
                    this.port = HttpUrl.a(this.scheme);
                }
                if (this.host != null) {
                    a2 = a;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, portColonOffset) + Typography.quote);
                }
            }
            int a5 = b.a(str, a2, b, "?#");
            resolvePath(str, a2, a5);
            if (a5 < b && str.charAt(a5) == '?') {
                int a6 = b.a(str, a5, b, '#');
                this.encodedQueryNamesAndValues = HttpUrl.b(HttpUrl.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < b && str.charAt(a5) == '#') {
                this.encodedFragment = HttpUrl.a(str, 1 + a5, b, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str != null) {
                if (str.equalsIgnoreCase("http")) {
                    this.scheme = "http";
                } else if (str.equalsIgnoreCase("https")) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme);
            sb.append("://");
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb.append(':');
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrl.a(this.scheme)) {
                sb.append(':');
                sb.append(effectivePort);
            }
            HttpUrl.a(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append(RFC1522Codec.SEP);
                HttpUrl.b(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    public String a() {
        if (this.e.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return this.i.substring(length, b.a(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.f.isEmpty()) {
            return "";
        }
        int indexOf = this.i.indexOf(64);
        return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, indexOf);
    }

    @Nullable
    public String d() {
        if (this.g == null) {
            return null;
        }
        int indexOf = this.i.indexOf(63) + 1;
        String str = this.i;
        return this.i.substring(indexOf, b.a(str, indexOf, str.length(), '#'));
    }

    @Nullable
    public String e() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public String toString() {
        return this.i;
    }

    public HttpUrl(Builder builder) {
        List<String> list;
        this.a = builder.scheme;
        this.e = a(builder.encodedUsername, false);
        this.f = a(builder.encodedPassword, false);
        this.b = builder.host;
        this.c = builder.effectivePort();
        List<String> list2 = builder.encodedQueryNamesAndValues;
        if (list2 != null) {
            list = a(list2, true);
        } else {
            list = null;
        }
        this.g = list;
        String str = builder.encodedFragment;
        this.h = str != null ? a(str, false) : null;
        this.i = builder.toString();
    }

    public static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    @Nullable
    public static HttpUrl c(String str) {
        try {
            return d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static HttpUrl d(String str) {
        return new Builder().parse(null, str).build();
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof HttpUrl) && ((HttpUrl) obj).i.equals(this.i)) {
            return true;
        }
        return false;
    }

    public static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            com.baidu.searchbox.v8engine.net.io.a aVar = new com.baidu.searchbox.v8engine.net.io.a();
            aVar.a(str, i, i3);
            a(aVar, str, i3, i2, str2, z, z2, z3, z4, charset);
            return aVar.c();
        }
        return str.substring(i, i2);
    }

    public static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.baidu.searchbox.v8engine.net.io.a aVar = new com.baidu.searchbox.v8engine.net.io.a();
                aVar.a(str, i, i3);
                a(aVar, str, i3, i2, z);
                return aVar.c();
            }
        }
        return str.substring(i, i2);
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    private List<String> a(List<String> list, boolean z) {
        String str;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str2 = list.get(i);
            if (str2 != null) {
                str = a(str2, z);
            } else {
                str = null;
            }
            arrayList.add(str);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3;
        com.baidu.searchbox.v8engine.net.io.a aVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    if (z) {
                        str3 = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
                    } else {
                        str3 = "%2B";
                    }
                    aVar.a(str3);
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    aVar.a(codePointAt);
                } else {
                    if (aVar2 == null) {
                        aVar2 = new com.baidu.searchbox.v8engine.net.io.a();
                    }
                    if (charset != null && !charset.equals(b.a)) {
                        aVar2.a(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        aVar2.a(codePointAt);
                    }
                    while (!aVar2.a()) {
                        int b = aVar2.b() & 255;
                        aVar.b(37);
                        aVar.b((int) d[(b >> 4) & 15]);
                        aVar.b((int) d[b & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int a = b.a(str.charAt(i + 1));
                int a2 = b.a(str.charAt(i3));
                if (a != -1 && a2 != -1) {
                    aVar.b((a << 4) + a2);
                    i = i3;
                }
                aVar.a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    aVar.b(32);
                }
                aVar.a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(list.get(i));
        }
    }

    public static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 < i2 && str.charAt(i) == '%' && b.a(str.charAt(i + 1)) != -1 && b.a(str.charAt(i3)) != -1) {
            return true;
        }
        return false;
    }

    public List<String> c() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        int a = b.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a) {
            int i = indexOf + 1;
            int a2 = b.a(this.i, i, a, (char) WebvttCueParser.CHAR_SLASH);
            arrayList.add(this.i.substring(i, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    public Builder f() {
        int i;
        Builder builder = new Builder();
        builder.scheme = this.a;
        builder.encodedUsername = a();
        builder.encodedPassword = b();
        builder.host = this.b;
        if (this.c != a(this.a)) {
            i = this.c;
        } else {
            i = -1;
        }
        builder.port = i;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(c());
        builder.encodedQuery(d());
        builder.encodedFragment = e();
        return builder;
    }
}
