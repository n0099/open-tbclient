package com.baidu.searchbox.v8engine.net;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class HttpUrl {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f45102d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f45103a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45104b;

    /* renamed from: c  reason: collision with root package name */
    public final int f45105c;

    /* renamed from: e  reason: collision with root package name */
    public final String f45106e;

    /* renamed from: f  reason: collision with root package name */
    public final String f45107f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f45108g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final String f45109h;

    /* renamed from: i  reason: collision with root package name */
    public final String f45110i;

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String INVALID_HOST = "Invalid URL host";
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public String encodedFragment;
        public String encodedPassword;
        public final List<String> encodedPathSegments;
        @Nullable
        public List<String> encodedQueryNamesAndValues;
        public String encodedUsername;
        @Nullable
        public String host;
        public int port;
        @Nullable
        public String scheme;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        public static String canonicalizeHost(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i2, i3)) == null) ? b.a(HttpUrl.a(str, i2, i3, false)) : (String) invokeLII.objValue;
        }

        private boolean isDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str.equals(".") || str.equalsIgnoreCase("%2e") : invokeL.booleanValue;
        }

        private boolean isDotDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e") : invokeL.booleanValue;
        }

        public static int parsePort(String str, int i2, int i3) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
                try {
                    parseInt = Integer.parseInt(HttpUrl.a(str, i2, i3, "", false, false, false, true, null));
                } catch (NumberFormatException unused) {
                }
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            }
            return invokeLII.intValue;
        }

        private void pop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                List<String> list = this.encodedPathSegments;
                if (list.remove(list.size() - 1).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, "");
                    return;
                }
                this.encodedPathSegments.add("");
            }
        }

        public static int portColonOffset(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, i3)) == null) {
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
            return invokeLII.intValue;
        }

        private void push(String str, int i2, int i3, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0048 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0045 -> B:13:0x002d). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void resolvePath(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.searchbox.v8engine.net.HttpUrl.Builder.$ic
                if (r0 != 0) goto L49
            L4:
                if (r12 != r13) goto L7
                return
            L7:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L22
                r1 = 92
                if (r0 != r1) goto L17
                goto L22
            L17:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2d
            L22:
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.encodedPathSegments
                r0.add(r2)
                goto L45
            L2d:
                r6 = r12
                if (r6 >= r13) goto L48
                java.lang.String r12 = "/\\"
                int r12 = com.baidu.searchbox.v8engine.net.b.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L3a
                r0 = 1
                goto L3b
            L3a:
                r0 = 0
            L3b:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.push(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L2d
            L45:
                int r12 = r12 + 1
                goto L2d
            L48:
                return
            L49:
                r8 = r0
                r9 = 65544(0x10008, float:9.1847E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeLII(r9, r10, r11, r12, r13)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.v8engine.net.HttpUrl.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public static int schemeDelimiterOffset(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i2, i3)) == null) {
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
            return invokeLII.intValue;
        }

        public static int slashCount(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, str, i2, i3)) == null) {
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
            return invokeLII.intValue;
        }

        public Builder addQueryParameter(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
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
            return (Builder) invokeLL.objValue;
        }

        public HttpUrl build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.scheme != null) {
                    if (this.host != null) {
                        return new HttpUrl(this);
                    }
                    throw new IllegalStateException("host == null");
                }
                throw new IllegalStateException("scheme == null");
            }
            return (HttpUrl) invokeV.objValue;
        }

        public int effectivePort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.port;
                return i2 != -1 ? i2 : HttpUrl.a(this.scheme);
            }
            return invokeV.intValue;
        }

        public Builder encodedQuery(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.encodedQueryNamesAndValues = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, false, true, true)) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder fragment(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.encodedFragment = str != null ? HttpUrl.a(str, "", false, false, false, false) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder host(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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
            return (Builder) invokeL.objValue;
        }

        public Builder parse(@Nullable HttpUrl httpUrl, String str) {
            InterceptResult invokeLL;
            int schemeDelimiterOffset;
            int a2;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, httpUrl, str)) == null) {
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
                    this.scheme = httpUrl.f45103a;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                int slashCount = slashCount(str, a3, b2);
                char c2 = '?';
                char c3 = '#';
                if (slashCount < 2 && httpUrl != null && httpUrl.f45103a.equals(this.scheme)) {
                    this.encodedUsername = httpUrl.a();
                    this.encodedPassword = httpUrl.b();
                    this.host = httpUrl.f45104b;
                    this.port = httpUrl.f45105c;
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
                        c3 = '#';
                    }
                    int portColonOffset = portColonOffset(str, i3, a2);
                    int i4 = portColonOffset + 1;
                    if (i4 < a2) {
                        this.host = canonicalizeHost(str, i3, portColonOffset);
                        int parsePort = parsePort(str, i4, a2);
                        this.port = parsePort;
                        if (parsePort == -1) {
                            throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, a2) + '\"');
                        }
                    } else {
                        this.host = canonicalizeHost(str, i3, portColonOffset);
                        this.port = HttpUrl.a(this.scheme);
                    }
                    if (this.host == null) {
                        throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, portColonOffset) + '\"');
                    }
                    a3 = a2;
                }
                int a6 = b.a(str, a3, b2, "?#");
                resolvePath(str, a3, a6);
                if (a6 < b2 && str.charAt(a6) == '?') {
                    int a7 = b.a(str, a6, b2, '#');
                    this.encodedQueryNamesAndValues = HttpUrl.b(HttpUrl.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                    a6 = a7;
                }
                if (a6 < b2 && str.charAt(a6) == '#') {
                    this.encodedFragment = HttpUrl.a(str, 1 + a6, b2, "", true, false, false, false, null);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder query(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.encodedQueryNamesAndValues = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", false, false, true, true)) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder scheme(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
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
            return (Builder) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
                    sb.append('#');
                    sb.append(this.encodedFragment);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1196451799, "Lcom/baidu/searchbox/v8engine/net/HttpUrl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1196451799, "Lcom/baidu/searchbox/v8engine/net/HttpUrl;");
                return;
            }
        }
        f45102d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45103a = builder.scheme;
        this.f45106e = a(builder.encodedUsername, false);
        this.f45107f = a(builder.encodedPassword, false);
        this.f45104b = builder.host;
        this.f45105c = builder.effectivePort();
        List<String> list = builder.encodedQueryNamesAndValues;
        this.f45108g = list != null ? a(list, true) : null;
        String str = builder.encodedFragment;
        this.f45109h = str != null ? a(str, false) : null;
        this.f45110i = builder.toString();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f45106e.isEmpty()) {
                return "";
            }
            int length = this.f45103a.length() + 3;
            String str = this.f45110i;
            return this.f45110i.substring(length, b.a(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f45107f.isEmpty()) {
                return "";
            }
            return this.f45110i.substring(this.f45110i.indexOf(58, this.f45103a.length() + 3) + 1, this.f45110i.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public List<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int indexOf = this.f45110i.indexOf(47, this.f45103a.length() + 3);
            String str = this.f45110i;
            int a2 = b.a(str, indexOf, str.length(), "?#");
            ArrayList arrayList = new ArrayList();
            while (indexOf < a2) {
                int i2 = indexOf + 1;
                int a3 = b.a(this.f45110i, i2, a2, '/');
                arrayList.add(this.f45110i.substring(i2, a3));
                indexOf = a3;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f45108g == null) {
                return null;
            }
            int indexOf = this.f45110i.indexOf(63) + 1;
            String str = this.f45110i;
            return this.f45110i.substring(indexOf, b.a(str, indexOf, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f45109h == null) {
                return null;
            }
            return this.f45110i.substring(this.f45110i.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? (obj instanceof HttpUrl) && ((HttpUrl) obj).f45110i.equals(this.f45110i) : invokeL.booleanValue;
    }

    public Builder f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Builder builder = new Builder();
            builder.scheme = this.f45103a;
            builder.encodedUsername = a();
            builder.encodedPassword = b();
            builder.host = this.f45104b;
            builder.port = this.f45105c != a(this.f45103a) ? this.f45105c : -1;
            builder.encodedPathSegments.clear();
            builder.encodedPathSegments.addAll(c());
            builder.encodedQuery(d());
            builder.encodedFragment = e();
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45110i.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f45110i : (String) invokeV.objValue;
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return Constants.SOCKET_PORT_SSL;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void b(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                String str = list.get(i2);
                String str2 = list.get(i2 + 1);
                if (i2 > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append(com.alipay.sdk.encrypt.a.f36026h);
                    sb.append(str2);
                }
            }
        }
    }

    public static HttpUrl d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? new Builder().parse(null, str).build() : (HttpUrl) invokeL.objValue;
    }

    @Nullable
    public static HttpUrl c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            try {
                return d(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public static void a(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z)) == null) ? a(str, 0, str.length(), z) : (String) invokeLZ.objValue;
    }

    private List<String> a(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, list, z)) == null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
                arrayList.add(str != null ? a(str, z) : null);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    public static List<String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public static String a(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i2, int i3, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{aVar, str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
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
    }

    public static boolean a(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, str, i2, i3)) == null) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && b.a(str.charAt(i2 + 1)) != -1 && b.a(str.charAt(i4)) != -1;
        }
        return invokeLII.booleanValue;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{aVar, str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset}) == null) {
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
                        if (charset != null && !charset.equals(b.f45111a)) {
                            aVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                        } else {
                            aVar2.a(codePointAt);
                        }
                        while (!aVar2.a()) {
                            int b2 = aVar2.b() & 255;
                            aVar.b(37);
                            aVar.b((int) f45102d[(b2 >> 4) & 15]);
                            aVar.b((int) f45102d[b2 & 15]);
                        }
                    }
                }
                i2 += Character.charCount(codePointAt);
            }
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? a(str, 0, str.length(), str2, z, z2, z3, z4, null) : (String) invokeCommon.objValue;
    }
}
