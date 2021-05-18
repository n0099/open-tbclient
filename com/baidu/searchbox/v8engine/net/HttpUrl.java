package com.baidu.searchbox.v8engine.net;

import androidx.annotation.Nullable;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanTaskDeadEvent;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.google.android.material.badge.BadgeDrawable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public final class HttpUrl {

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f10119d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    public final String f10120a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10121b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10122c;

    /* renamed from: e  reason: collision with root package name */
    public final String f10123e;

    /* renamed from: f  reason: collision with root package name */
    public final String f10124f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f10125g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final String f10126h;

    /* renamed from: i  reason: collision with root package name */
    public final String f10127i;

    /* loaded from: classes2.dex */
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

        public static String canonicalizeHost(String str, int i2, int i3) {
            return b.a(HttpUrl.a(str, i2, i3, false));
        }

        private boolean isDot(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public static int parsePort(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.a(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
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

        public static int portColonOffset(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        private void push(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = HttpUrl.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (isDot(a2)) {
                return;
            }
            if (isDotDot(a2)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, a2);
            } else {
                this.encodedPathSegments.add(a2);
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

        public static int schemeDelimiterOffset(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public static int slashCount(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            if (str != null) {
                if (this.encodedQueryNamesAndValues == null) {
                    this.encodedQueryNamesAndValues = new ArrayList();
                }
                this.encodedQueryNamesAndValues.add(HttpUrl.a(str, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
                this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.a(str2, okhttp3.HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
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
            int i2 = this.port;
            return i2 != -1 ? i2 : HttpUrl.a(this.scheme);
        }

        public Builder encodedQuery(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder fragment(@Nullable String str) {
            this.encodedFragment = str != null ? HttpUrl.a(str, "", false, false, false, false) : null;
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

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            int schemeDelimiterOffset;
            int a2;
            int i2;
            int a3 = b.a(str, 0, str.length());
            int b2 = b.b(str, a3, str.length());
            if (schemeDelimiterOffset(str, a3, b2) != -1) {
                if (str.regionMatches(true, a3, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                    this.scheme = "https";
                    a3 += 6;
                } else if (str.regionMatches(true, a3, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                    this.scheme = "http";
                    a3 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.f10120a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int slashCount = slashCount(str, a3, b2);
            char c2 = '?';
            char c3 = SwanTaskDeadEvent.SEPARATOR;
            if (slashCount < 2 && httpUrl != null && httpUrl.f10120a.equals(this.scheme)) {
                this.encodedUsername = httpUrl.a();
                this.encodedPassword = httpUrl.b();
                this.host = httpUrl.f10121b;
                this.port = httpUrl.f10122c;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.c());
                if (a3 == b2 || str.charAt(a3) == '#') {
                    encodedQuery(httpUrl.d());
                }
            } else {
                int i3 = a3 + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = b.a(str, i3, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a4 = b.a(str, i3, a2, ':');
                            i2 = a2;
                            String a5 = HttpUrl.a(str, i3, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a5 = this.encodedUsername + "%40" + a5;
                            }
                            this.encodedUsername = a5;
                            if (a4 != i2) {
                                this.encodedPassword = HttpUrl.a(str, a4 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = a2;
                            this.encodedPassword += "%40" + HttpUrl.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c2 = '?';
                    c3 = SwanTaskDeadEvent.SEPARATOR;
                }
                int portColonOffset = portColonOffset(str, i3, a2);
                int i4 = portColonOffset + 1;
                if (i4 < a2) {
                    this.host = canonicalizeHost(str, i3, portColonOffset);
                    int parsePort = parsePort(str, i4, a2);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, a2) + Typography.quote);
                    }
                } else {
                    this.host = canonicalizeHost(str, i3, portColonOffset);
                    this.port = HttpUrl.a(this.scheme);
                }
                if (this.host == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, portColonOffset) + Typography.quote);
                }
                a3 = a2;
            }
            int a6 = b.a(str, a3, b2, "?#");
            resolvePath(str, a3, a6);
            if (a6 < b2 && str.charAt(a6) == '?') {
                int a7 = b.a(str, a6, b2, (char) SwanTaskDeadEvent.SEPARATOR);
                this.encodedQueryNamesAndValues = HttpUrl.b(HttpUrl.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                a6 = a7;
            }
            if (a6 < b2 && str.charAt(a6) == '#') {
                this.encodedFragment = HttpUrl.a(str, 1 + a6, b2, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder query(@Nullable String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", false, false, true, true)) : null;
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
                sb.append('?');
                HttpUrl.b(sb, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb.append(SwanTaskDeadEvent.SEPARATOR);
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }
    }

    public HttpUrl(Builder builder) {
        this.f10120a = builder.scheme;
        this.f10123e = a(builder.encodedUsername, false);
        this.f10124f = a(builder.encodedPassword, false);
        this.f10121b = builder.host;
        this.f10122c = builder.effectivePort();
        List<String> list = builder.encodedQueryNamesAndValues;
        this.f10125g = list != null ? a(list, true) : null;
        String str = builder.encodedFragment;
        this.f10126h = str != null ? a(str, false) : null;
        this.f10127i = builder.toString();
    }

    public String a() {
        if (this.f10123e.isEmpty()) {
            return "";
        }
        int length = this.f10120a.length() + 3;
        String str = this.f10127i;
        return this.f10127i.substring(length, b.a(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.f10124f.isEmpty()) {
            return "";
        }
        int indexOf = this.f10127i.indexOf(64);
        return this.f10127i.substring(this.f10127i.indexOf(58, this.f10120a.length() + 3) + 1, indexOf);
    }

    public List<String> c() {
        int indexOf = this.f10127i.indexOf(47, this.f10120a.length() + 3);
        String str = this.f10127i;
        int a2 = b.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = b.a(this.f10127i, i2, a2, '/');
            arrayList.add(this.f10127i.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public String d() {
        if (this.f10125g == null) {
            return null;
        }
        int indexOf = this.f10127i.indexOf(63) + 1;
        String str = this.f10127i;
        return this.f10127i.substring(indexOf, b.a(str, indexOf, str.length(), (char) SwanTaskDeadEvent.SEPARATOR));
    }

    @Nullable
    public String e() {
        if (this.f10126h == null) {
            return null;
        }
        return this.f10127i.substring(this.f10127i.indexOf(35) + 1);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f10127i.equals(this.f10127i);
    }

    public Builder f() {
        Builder builder = new Builder();
        builder.scheme = this.f10120a;
        builder.encodedUsername = a();
        builder.encodedPassword = b();
        builder.host = this.f10121b;
        builder.port = this.f10122c != a(this.f10120a) ? this.f10122c : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(c());
        builder.encodedQuery(d());
        builder.encodedFragment = e();
        return builder;
    }

    public int hashCode() {
        return this.f10127i.hashCode();
    }

    public String toString() {
        return this.f10127i;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return Constants.SOCKET_PORT_SSL;
        }
        return -1;
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.encrypt.a.f1873h);
                sb.append(str2);
            }
        }
    }

    public static HttpUrl d(String str) {
        return new Builder().parse(null, str).build();
    }

    @Nullable
    public static HttpUrl c(String str) {
        try {
            return d(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                com.baidu.searchbox.v8engine.net.io.a aVar = new com.baidu.searchbox.v8engine.net.io.a();
                aVar.a(str, i2, i4);
                a(aVar, str, i4, i3, z);
                return aVar.c();
            }
        }
        return str.substring(i2, i3);
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = b.a(str.charAt(i2 + 1));
                int a3 = b.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    aVar.b((a2 << 4) + a3);
                    i2 = i4;
                }
                aVar.a(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    aVar.b(32);
                }
                aVar.a(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && b.a(str.charAt(i2 + 1)) != -1 && b.a(str.charAt(i4)) != -1;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            com.baidu.searchbox.v8engine.net.io.a aVar = new com.baidu.searchbox.v8engine.net.io.a();
            aVar.a(str, i2, i4);
            a(aVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return aVar.c();
        }
        return str.substring(i2, i3);
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.baidu.searchbox.v8engine.net.io.a aVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    aVar.a(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                    aVar.a(codePointAt);
                } else {
                    if (aVar2 == null) {
                        aVar2 = new com.baidu.searchbox.v8engine.net.io.a();
                    }
                    if (charset != null && !charset.equals(b.f10128a)) {
                        aVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    } else {
                        aVar2.a(codePointAt);
                    }
                    while (!aVar2.a()) {
                        int b2 = aVar2.b() & 255;
                        aVar.b(37);
                        aVar.b((int) f10119d[(b2 >> 4) & 15]);
                        aVar.b((int) f10119d[b2 & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
