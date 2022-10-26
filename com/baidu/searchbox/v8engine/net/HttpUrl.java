package com.baidu.searchbox.v8engine.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.material.badge.BadgeDrawable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public final class HttpUrl {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] d;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final String e;
    public final String f;
    public final List g;
    public final String h;
    public final String i;

    /* loaded from: classes2.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String INVALID_HOST = "Invalid URL host";
        public transient /* synthetic */ FieldHolder $fh;
        public String encodedFragment;
        public String encodedPassword;
        public final List encodedPathSegments;
        public List encodedQueryNamesAndValues;
        public String encodedUsername;
        public String host;
        public int port;
        public String scheme;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        private void pop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                List list = this.encodedPathSegments;
                if (((String) list.remove(list.size() - 1)).isEmpty() && !this.encodedPathSegments.isEmpty()) {
                    List list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, "");
                    return;
                }
                this.encodedPathSegments.add("");
            }
        }

        public static String canonicalizeHost(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i, i2)) == null) {
                return b.a(HttpUrl.a(str, i, i2, false));
            }
            return (String) invokeLII.objValue;
        }

        public static int parsePort(String str, int i, int i2) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2)) == null) {
                try {
                    parseInt = Integer.parseInt(HttpUrl.a(str, i, i2, "", false, false, false, true, null));
                } catch (NumberFormatException unused) {
                }
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            }
            return invokeLII.intValue;
        }

        public static int slashCount(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, str, i, i2)) == null) {
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
            return invokeLII.intValue;
        }

        private boolean isDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                if (!str.equals(".") && !str.equalsIgnoreCase("%2e")) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public Builder encodedQuery(String str) {
            InterceptResult invokeL;
            List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    list = HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, false, true, true));
                } else {
                    list = null;
                }
                this.encodedQueryNamesAndValues = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder fragment(String str) {
            InterceptResult invokeL;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                if (str != null) {
                    str2 = HttpUrl.a(str, "", false, false, false, false);
                } else {
                    str2 = null;
                }
                this.encodedFragment = str2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder query(String str) {
            InterceptResult invokeL;
            List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str != null) {
                    list = HttpUrl.b(HttpUrl.a(str, " \"'<>#", false, false, true, true));
                } else {
                    list = null;
                }
                this.encodedQueryNamesAndValues = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        private boolean isDotDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
                if (!str.equals(IStringUtil.TOP_PATH) && !str.equalsIgnoreCase("%2e.") && !str.equalsIgnoreCase(".%2e") && !str.equalsIgnoreCase("%2e%2e")) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
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

        public static int portColonOffset(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, str, i, i2)) == null) {
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
            return invokeLII.intValue;
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                String a = HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
                if (isDot(a)) {
                    return;
                }
                if (isDotDot(a)) {
                    pop();
                    return;
                }
                List list = this.encodedPathSegments;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, a);
                } else {
                    this.encodedPathSegments.add(a);
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
                java.util.List r0 = r10.encodedPathSegments
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L2d
            L22:
                java.util.List r0 = r10.encodedPathSegments
                r0.clear()
                java.util.List r0 = r10.encodedPathSegments
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

        public static int schemeDelimiterOffset(String str, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, str, i, i2)) == null) {
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
            return invokeLII.intValue;
        }

        public Builder addQueryParameter(String str, String str2) {
            InterceptResult invokeLL;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (str != null) {
                    if (this.encodedQueryNamesAndValues == null) {
                        this.encodedQueryNamesAndValues = new ArrayList();
                    }
                    this.encodedQueryNamesAndValues.add(HttpUrl.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                    List list = this.encodedQueryNamesAndValues;
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
                int i = this.port;
                if (i == -1) {
                    return HttpUrl.a(this.scheme);
                }
                return i;
            }
            return invokeV.intValue;
        }

        public Builder parse(HttpUrl httpUrl, String str) {
            InterceptResult invokeLL;
            int schemeDelimiterOffset;
            int a;
            char c;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, httpUrl, str)) == null) {
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
                char c2 = '?';
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
                        c2 = '?';
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
            return (Builder) invokeLL.objValue;
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
        d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e.isEmpty()) {
                return "";
            }
            int length = this.a.length() + 3;
            String str = this.i;
            return this.i.substring(length, b.a(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f.isEmpty()) {
                return "";
            }
            return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, this.i.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.g == null) {
                return null;
            }
            int indexOf = this.i.indexOf(63) + 1;
            String str = this.i;
            return this.i.substring(indexOf, b.a(str, indexOf, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    public HttpUrl(Builder builder) {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = builder.scheme;
        this.e = a(builder.encodedUsername, false);
        this.f = a(builder.encodedPassword, false);
        this.b = builder.host;
        this.c = builder.effectivePort();
        List list2 = builder.encodedQueryNamesAndValues;
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

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return 443;
            }
            return -1;
        }
        return invokeL.intValue;
    }

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

    public static HttpUrl d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return new Builder().parse(null, str).build();
        }
        return (HttpUrl) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if ((obj instanceof HttpUrl) && ((HttpUrl) obj).i.equals(this.i)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            return a(str, 0, str.length(), z);
        }
        return (String) invokeLZ.objValue;
    }

    private List a(List list, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, this, list, z)) == null) {
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                String str2 = (String) list.get(i);
                if (str2 != null) {
                    str = a(str2, z);
                } else {
                    str = null;
                }
                arrayList.add(str);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    public static void b(StringBuilder sb, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, sb, list) == null) {
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                String str = (String) list.get(i);
                String str2 = (String) list.get(i + 1);
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
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{aVar, str, Integer.valueOf(i), Integer.valueOf(i2), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), charset}) == null) {
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
    }

    public static void a(com.baidu.searchbox.v8engine.net.io.a aVar, String str, int i, int i2, boolean z) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{aVar, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
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
    }

    public static void a(StringBuilder sb, List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sb, list) == null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(WebvttCueParser.CHAR_SLASH);
                sb.append((String) list.get(i));
            }
        }
    }

    public static boolean a(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, str, i, i2)) == null) {
            int i3 = i + 2;
            if (i3 < i2 && str.charAt(i) == '%' && b.a(str.charAt(i + 1)) != -1 && b.a(str.charAt(i3)) != -1) {
                return true;
            }
            return false;
        }
        return invokeLII.booleanValue;
    }

    public static List b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
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
        return (List) invokeL.objValue;
    }

    public List c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    public Builder f() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
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
        return (Builder) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.h == null) {
                return null;
            }
            return this.i.substring(this.i.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }
}
