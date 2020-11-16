package com.baidu.down.utils;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.ugc.model.UgcConstant;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes15.dex */
public final class HttpUrlHelper {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    private HttpUrlHelper(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        this.queryNamesAndValues = builder.encodedQueryNamesAndValues != null ? percentDecode(builder.encodedQueryNamesAndValues, true) : null;
        this.fragment = builder.encodedFragment != null ? percentDecode(builder.encodedFragment, false) : null;
        this.url = builder.toString();
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public URI uri() {
        String builder = newBuilder().reencodeForUri().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        return this.url.substring(length, HttpUrlHelperUtil.delimiterOffset(this.url, length, this.url.length(), ":@"));
    }

    public String username() {
        return this.username;
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        int indexOf = this.url.indexOf(64);
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, indexOf);
    }

    public String password() {
        return this.password;
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (str.equals("https")) {
            return com.baidu.android.imsdk.internal.Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        return this.url.substring(indexOf, HttpUrlHelperUtil.delimiterOffset(this.url, indexOf, this.url.length(), "?#"));
    }

    static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(this.url, indexOf, this.url.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            indexOf = HttpUrlHelperUtil.delimiterOffset(this.url, i, delimiterOffset, '/');
            arrayList.add(this.url.substring(i, indexOf));
        }
        return arrayList;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        return this.url.substring(indexOf, HttpUrlHelperUtil.delimiterOffset(this.url, indexOf + 1, this.url.length(), (char) UgcConstant.TOPIC_PATTERN_TAG));
    }

    static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
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

    static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        namesAndValuesToQueryString(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public int querySize() {
        if (this.queryNamesAndValues != null) {
            return this.queryNamesAndValues.size() / 2;
        }
        return 0;
    }

    public String queryParameter(String str) {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String queryParameterName(int i) {
        return this.queryNamesAndValues.get(i * 2);
    }

    public String queryParameterValue(int i) {
        return this.queryNamesAndValues.get((i * 2) + 1);
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String fragment() {
        return this.fragment;
    }

    public HttpUrlHelper resolve(String str) {
        Builder newBuilder = newBuilder(str);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        Builder builder = new Builder();
        if (builder.parse(this, str) == Builder.ParseResult.SUCCESS) {
            return builder;
        }
        return null;
    }

    public static HttpUrlHelper parse(String str) {
        Builder builder = new Builder();
        if (builder.parse(null, str) == Builder.ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    public static HttpUrlHelper get(URL url) {
        return parse(url.toString());
    }

    static HttpUrlHelper getChecked(String str) throws MalformedURLException, UnknownHostException {
        Builder builder = new Builder();
        Builder.ParseResult parse = builder.parse(null, str);
        switch (parse) {
            case SUCCESS:
                return builder.build();
            case INVALID_HOST:
                throw new UnknownHostException("Invalid host: " + str);
            default:
                throw new MalformedURLException("Invalid URL: " + parse + " for " + str);
        }
    }

    public static HttpUrlHelper get(URI uri) {
        return parse(uri.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrlHelper) && ((HttpUrlHelper) obj).url.equals(this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    /* loaded from: classes15.dex */
    public static final class Builder {
        String encodedFragment;
        List<String> encodedQueryNamesAndValues;
        String host;
        String scheme;
        String encodedUsername = "";
        String encodedPassword = "";
        int port = -1;
        final List<String> encodedPathSegments = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes15.dex */
        public enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.encodedPathSegments.add("");
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            } else if (str.equalsIgnoreCase("https")) {
                this.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public Builder username(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.encodedUsername = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.encodedUsername = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder password(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.encodedPassword = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.encodedPassword = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder host(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String canonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (canonicalizeHost == null) {
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            this.host = canonicalizeHost;
            return this;
        }

        public Builder port(int i) {
            if (i <= 0 || i > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i);
            }
            this.port = i;
            return this;
        }

        int effectivePort() {
            return this.port != -1 ? this.port : HttpUrlHelper.defaultPort(this.scheme);
        }

        public Builder addPathSegment(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addPathSegments(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegments == null");
            }
            return addPathSegments(str, false);
        }

        public Builder addEncodedPathSegment(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        public Builder addEncodedPathSegments(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegments == null");
            }
            return addPathSegments(str, true);
        }

        private Builder addPathSegments(String str, boolean z) {
            int i = 0;
            do {
                int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, i, str.length(), "/\\");
                push(str, i, delimiterOffset, delimiterOffset < str.length(), z);
                i = delimiterOffset + 1;
            } while (i <= str.length());
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String canonicalize = HttpUrlHelper.canonicalize(str, 0, str.length(), HttpUrlHelper.PATH_SEGMENT_ENCODE_SET, false, false, false, true);
            if (isDot(canonicalize) || isDotDot(canonicalize)) {
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            this.encodedPathSegments.set(i, canonicalize);
            return this;
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String canonicalize = HttpUrlHelper.canonicalize(str, 0, str.length(), HttpUrlHelper.PATH_SEGMENT_ENCODE_SET, true, false, false, true);
            this.encodedPathSegments.set(i, canonicalize);
            if (isDot(canonicalize) || isDotDot(canonicalize)) {
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            return this;
        }

        public Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            }
            if (!str.startsWith("/")) {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
            resolvePath(str, 0, str.length());
            return this;
        }

        public Builder encodedQuery(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrlHelper.queryStringToNamesAndValues(HttpUrlHelper.canonicalize(str, HttpUrlHelper.QUERY_ENCODE_SET, true, false, true, true)) : null;
            return this;
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        public Builder fragment(String str) {
            this.encodedFragment = str != null ? HttpUrlHelper.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? HttpUrlHelper.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                this.encodedPathSegments.set(i, HttpUrlHelper.canonicalize(this.encodedPathSegments.get(i), HttpUrlHelper.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            }
            if (this.encodedQueryNamesAndValues != null) {
                int size2 = this.encodedQueryNamesAndValues.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.encodedQueryNamesAndValues.get(i2);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i2, HttpUrlHelper.canonicalize(str, HttpUrlHelper.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
                    }
                }
            }
            if (this.encodedFragment != null) {
                this.encodedFragment = HttpUrlHelper.canonicalize(this.encodedFragment, HttpUrlHelper.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
            }
            return this;
        }

        public HttpUrlHelper build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host == null) {
                throw new IllegalStateException("host == null");
            }
            return new HttpUrlHelper(this);
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
                sb.append(UgcConstant.AT_PATTERN_TAG);
            }
            if (this.host.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.host);
                sb.append(']');
            } else {
                sb.append(this.host);
            }
            int effectivePort = effectivePort();
            if (effectivePort != HttpUrlHelper.defaultPort(this.scheme)) {
                sb.append(':');
                sb.append(effectivePort);
            }
            HttpUrlHelper.pathSegmentsToString(sb, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                HttpUrlHelper.namesAndValuesToQueryString(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append(UgcConstant.TOPIC_PATTERN_TAG);
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        ParseResult parse(HttpUrlHelper httpUrlHelper, String str) {
            int i;
            int skipLeadingAsciiWhitespace = HttpUrlHelperUtil.skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = HttpUrlHelperUtil.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            if (schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.scheme = "https";
                    skipLeadingAsciiWhitespace += UrlSchemaHelper.SCHEMA_TYPE_HTTPS.length();
                } else if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
                    skipLeadingAsciiWhitespace += UrlSchemaHelper.SCHEMA_TYPE_HTTP.length();
                } else {
                    return ParseResult.UNSUPPORTED_SCHEME;
                }
            } else if (httpUrlHelper != null) {
                this.scheme = httpUrlHelper.scheme;
            } else {
                return ParseResult.MISSING_SCHEME;
            }
            boolean z = false;
            boolean z2 = false;
            int slashCount = slashCount(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (slashCount >= 2 || httpUrlHelper == null || !httpUrlHelper.scheme.equals(this.scheme)) {
                int i2 = skipLeadingAsciiWhitespace + slashCount;
                while (true) {
                    boolean z3 = z2;
                    boolean z4 = z;
                    int i3 = i2;
                    int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, i3, skipTrailingAsciiWhitespace, "@/\\?#");
                    switch (delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535) {
                        case 65535:
                        case '#':
                        case '/':
                        case '?':
                        case '\\':
                            int portColonOffset = portColonOffset(str, i3, delimiterOffset);
                            if (portColonOffset + 1 < delimiterOffset) {
                                this.host = canonicalizeHost(str, i3, portColonOffset);
                                this.port = parsePort(str, portColonOffset + 1, delimiterOffset);
                                if (this.port == -1) {
                                    return ParseResult.INVALID_PORT;
                                }
                            } else {
                                this.host = canonicalizeHost(str, i3, portColonOffset);
                                this.port = HttpUrlHelper.defaultPort(this.scheme);
                            }
                            if (this.host != null) {
                                skipLeadingAsciiWhitespace = delimiterOffset;
                                break;
                            } else {
                                return ParseResult.INVALID_HOST;
                            }
                        case '@':
                            if (!z3) {
                                int delimiterOffset2 = HttpUrlHelperUtil.delimiterOffset(str, i3, delimiterOffset, ':');
                                String canonicalize = HttpUrlHelper.canonicalize(str, i3, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z4) {
                                    canonicalize = this.encodedUsername + "%40" + canonicalize;
                                }
                                this.encodedUsername = canonicalize;
                                if (delimiterOffset2 != delimiterOffset) {
                                    z3 = true;
                                    this.encodedPassword = HttpUrlHelper.canonicalize(str, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                }
                                z4 = true;
                            } else {
                                this.encodedPassword += "%40" + HttpUrlHelper.canonicalize(str, i3, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i2 = delimiterOffset + 1;
                            z2 = z3;
                            break;
                        default:
                            z2 = z3;
                            i2 = i3;
                            break;
                    }
                    z = z4;
                }
            } else {
                this.encodedUsername = httpUrlHelper.encodedUsername();
                this.encodedPassword = httpUrlHelper.encodedPassword();
                this.host = httpUrlHelper.host;
                this.port = httpUrlHelper.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrlHelper.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrlHelper.encodedQuery());
                }
            }
            int delimiterOffset3 = HttpUrlHelperUtil.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            resolvePath(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 >= skipTrailingAsciiWhitespace || str.charAt(delimiterOffset3) != '?') {
                i = delimiterOffset3;
            } else {
                i = HttpUrlHelperUtil.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, (char) UgcConstant.TOPIC_PATTERN_TAG);
                this.encodedQueryNamesAndValues = HttpUrlHelper.queryStringToNamesAndValues(HttpUrlHelper.canonicalize(str, delimiterOffset3 + 1, i, HttpUrlHelper.QUERY_ENCODE_SET, true, false, false, true));
            }
            if (i < skipTrailingAsciiWhitespace && str.charAt(i) == '#') {
                this.encodedFragment = HttpUrlHelper.canonicalize(str, i + 1, skipTrailingAsciiWhitespace, "", true, false, false, false);
            }
            return ParseResult.SUCCESS;
        }

        private void resolvePath(String str, int i, int i2) {
            if (i != i2) {
                char charAt = str.charAt(i);
                if (charAt == '/' || charAt == '\\') {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add("");
                    i++;
                } else {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                }
                int i3 = i;
                while (i3 < i2) {
                    int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, i3, i2, "/\\");
                    boolean z = delimiterOffset < i2;
                    push(str, i3, delimiterOffset, z, true);
                    if (z) {
                        delimiterOffset++;
                    }
                    i3 = delimiterOffset;
                }
            }
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize = HttpUrlHelper.canonicalize(str, i, i2, HttpUrlHelper.PATH_SEGMENT_ENCODE_SET, z2, false, false, true);
            if (!isDot(canonicalize)) {
                if (isDotDot(canonicalize)) {
                    pop();
                    return;
                }
                if (this.encodedPathSegments.get(this.encodedPathSegments.size() - 1).isEmpty()) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, canonicalize);
                } else {
                    this.encodedPathSegments.add(canonicalize);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private boolean isDot(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private void pop() {
            if (this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
            } else {
                this.encodedPathSegments.add("");
            }
        }

        private static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '+' && charAt2 != '-' && charAt2 != '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    } else {
                        return -1;
                    }
                }
            }
            return -1;
        }

        private static int slashCount(String str, int i, int i2) {
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static int portColonOffset(String str, int i, int i2) {
            int i3 = i;
            while (i3 < i2) {
                switch (str.charAt(i3)) {
                    case ':':
                        return i3;
                    case '[':
                        break;
                    default:
                        i3++;
                }
                do {
                    i3++;
                    if (i3 < i2) {
                    }
                    i3++;
                } while (str.charAt(i3) != ']');
                i3++;
            }
            return i2;
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            InetAddress decodeIpv6;
            String percentDecode = HttpUrlHelper.percentDecode(str, i, i2, false);
            if (percentDecode.contains(":")) {
                if (percentDecode.startsWith("[") && percentDecode.endsWith("]")) {
                    decodeIpv6 = decodeIpv6(percentDecode, 1, percentDecode.length() - 1);
                } else {
                    decodeIpv6 = decodeIpv6(percentDecode, 0, percentDecode.length());
                }
                if (decodeIpv6 == null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError();
            }
            return HttpUrlHelperUtil.domainToAscii(percentDecode);
        }

        /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static InetAddress decodeIpv6(String str, int i, int i2) {
            int i3;
            int i4;
            byte[] bArr = new byte[16];
            int i5 = i;
            int i6 = -1;
            int i7 = -1;
            int i8 = 0;
            while (true) {
                if (i5 < i2) {
                    if (i8 != bArr.length) {
                        if (i5 + 2 <= i2 && str.regionMatches(i5, "::", 0, 2)) {
                            if (i7 == -1) {
                                i5 += 2;
                                i7 = i8 + 2;
                                if (i5 != i2) {
                                    i8 = i7;
                                    int i9 = 0;
                                    i3 = i5;
                                    while (i3 < i2) {
                                    }
                                    i4 = i3 - i5;
                                    if (i4 == 0) {
                                        break;
                                    }
                                    break;
                                }
                                i8 = i7;
                                break;
                            }
                            return null;
                        }
                        if (i8 != 0) {
                            if (str.regionMatches(i5, ":", 0, 1)) {
                                i5++;
                            } else {
                                if (str.regionMatches(i5, ".", 0, 1) && decodeIpv4Suffix(str, i6, i2, bArr, i8 - 2)) {
                                    i8 += 2;
                                }
                                return null;
                            }
                        }
                        int i92 = 0;
                        i3 = i5;
                        while (i3 < i2) {
                            int decodeHexDigit = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i3));
                            if (decodeHexDigit == -1) {
                                break;
                            }
                            i92 = (i92 << 4) + decodeHexDigit;
                            i3++;
                        }
                        i4 = i3 - i5;
                        if (i4 == 0 || i4 > 4) {
                            break;
                        }
                        int i10 = i8 + 1;
                        bArr[i8] = (byte) ((i92 >>> 8) & 255);
                        i8 = i10 + 1;
                        bArr[i10] = (byte) (i92 & 255);
                        i6 = i5;
                        i5 = i3;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            if (i8 != bArr.length) {
                if (i7 == -1) {
                    return null;
                }
                System.arraycopy(bArr, i7, bArr, bArr.length - (i8 - i7), i8 - i7);
                Arrays.fill(bArr, i7, (bArr.length - i8) + i7, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException e) {
                throw new AssertionError();
            }
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i;
            int i5 = i3;
            while (i4 < i2) {
                if (i5 == bArr.length) {
                    return false;
                }
                if (i5 != i3) {
                    if (str.charAt(i4) != '.') {
                        return false;
                    }
                    i4++;
                }
                int i6 = 0;
                int i7 = i4;
                while (i7 < i2) {
                    char charAt = str.charAt(i7);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i6 != 0 || i4 == i7) && ((i6 * 10) + charAt) - 48 <= 255) {
                        i7++;
                    }
                    return false;
                }
                if (i7 - i4 == 0) {
                    return false;
                }
                bArr[i5] = (byte) i6;
                i5++;
                i4 = i7;
            }
            return i5 == i3 + 4;
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i4 < bArr.length) {
                int i5 = i4;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i4;
                if (i6 > i2) {
                    i2 = i6;
                    i3 = i4;
                }
                i4 = i5 + 2;
            }
            StringBuilder sb = new StringBuilder();
            while (i < bArr.length) {
                if (i == i3) {
                    sb.append(HttpUrlHelperUtil.writeByte(58));
                    i += i2;
                    if (i == 16) {
                        sb.append(HttpUrlHelperUtil.writeByte(58));
                    }
                } else {
                    if (i > 0) {
                        sb.append(HttpUrlHelperUtil.writeByte(58));
                    }
                    sb.append(HttpUrlHelperUtil.writeHexadecimalUnsignedLong(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return sb.toString();
        }

        private static int parsePort(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(HttpUrlHelper.canonicalize(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    static String percentDecode(String str, boolean z) {
        return percentDecode(str, 0, str.length(), z);
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? percentDecode(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String percentDecode(String str, int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                try {
                    sb.append(URLEncoder.encode(str.substring(i, i3), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(percentDecode2(str, i3, i2, z));
                return sb.toString();
            }
        }
        return str.substring(i, i2);
    }

    static String percentDecode2(String str, int i, int i2, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 37 && i3 + 2 < i2) {
                int decodeHexDigit = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i3 + 1));
                int decodeHexDigit2 = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i3 + 2));
                if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                    sb.append(HttpUrlHelperUtil.writeByte((decodeHexDigit << 4) + decodeHexDigit2));
                    i3 += 2;
                }
                sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
            } else {
                if (codePointAt == 43 && z) {
                    sb.append(HttpUrlHelperUtil.writeByte(32));
                }
                sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
            }
            i3 += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    static boolean percentEncoded(String str, int i, int i2) {
        return i + 2 < i2 && str.charAt(i) == '%' && HttpUrlHelperUtil.decodeHexDigit(str.charAt(i + 1)) != -1 && HttpUrlHelperUtil.decodeHexDigit(str.charAt(i + 2)) != -1;
    }

    static String canonicalize(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || percentEncoded(str, i3, i2)))) && (codePointAt != 43 || !z3)))) {
                i3 += Character.charCount(codePointAt);
            } else {
                try {
                    sb.append(URLEncoder.encode(str.substring(i, i3), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append(canonicalize2(str, i3, i2, str2, z, z2, z3, z4));
                return sb.toString();
            }
        }
        return str.substring(i, i2);
    }

    static String canonicalize2(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    try {
                        sb.append(URLEncoder.encode(z ? "+" : "%2B", "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !percentEncoded(str, i, i2)))))) {
                    for (byte b : HttpUrlHelperUtil.writeUtf8CodePoint2(codePointAt)) {
                        int i3 = b & 255;
                        sb.append(HttpUrlHelperUtil.writeByte(37));
                        sb.append(HttpUrlHelperUtil.writeByte(HEX_DIGITS[(i3 >> 4) & 15]));
                        sb.append(HttpUrlHelperUtil.writeByte(HEX_DIGITS[i3 & 15]));
                    }
                } else {
                    sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
                }
            }
            i += Character.charCount(codePointAt);
        }
        return sb.toString();
    }

    static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return canonicalize(str, 0, str.length(), str2, z, z2, z3, z4);
    }
}
