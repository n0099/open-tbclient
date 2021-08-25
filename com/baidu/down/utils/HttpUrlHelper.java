package com.baidu.down.utils;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
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
import kotlin.text.Typography;
/* loaded from: classes5.dex */
public final class HttpUrlHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final char[] HEX_DIGITS;
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public transient /* synthetic */ FieldHolder $fh;
    public final String fragment;
    public final String host;
    public final String password;
    public final List<String> pathSegments;
    public final int port;
    public final List<String> queryNamesAndValues;
    public final String scheme;
    public final String url;
    public final String username;

    /* renamed from: com.baidu.down.utils.HttpUrlHelper$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-967194410, "Lcom/baidu/down/utils/HttpUrlHelper$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-967194410, "Lcom/baidu/down/utils/HttpUrlHelper$1;");
                    return;
                }
            }
            int[] iArr = new int[Builder.ParseResult.values().length];
            $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult = iArr;
            try {
                iArr[Builder.ParseResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult[Builder.ParseResult.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult[Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult[Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult[Builder.ParseResult.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-50168381, "Lcom/baidu/down/utils/HttpUrlHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-50168381, "Lcom/baidu/down/utils/HttpUrlHelper;");
                return;
            }
        }
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public /* synthetic */ HttpUrlHelper(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:5|(1:42)(2:9|(2:22|(1:38))(6:12|13|14|15|16|17))|31|14|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String canonicalize(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            StringBuilder sb = new StringBuilder();
            int i4 = i2;
            while (i4 < i3) {
                int codePointAt = str.codePointAt(i4);
                if (codePointAt >= 32 && codePointAt != 127) {
                    if (codePointAt < 128 || !z4) {
                        if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || percentEncoded(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                            i4 += Character.charCount(codePointAt);
                        }
                    } else {
                        sb.append(URLEncoder.encode(str.substring(i2, i4), "utf-8"));
                        sb.append(canonicalize2(str, i4, i3, str2, z, z2, z3, z4));
                        return sb.toString();
                    }
                }
                sb.append(URLEncoder.encode(str.substring(i2, i4), "utf-8"));
                sb.append(canonicalize2(str, i4, i3, str2, z, z2, z3, z4));
                return sb.toString();
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String canonicalize2(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            StringBuilder sb = new StringBuilder();
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z3) {
                        try {
                            sb.append(URLEncoder.encode(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B", "utf-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || percentEncoded(str, i2, i3)))))) {
                        sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
                    } else {
                        for (byte b2 : HttpUrlHelperUtil.writeUtf8CodePoint2(codePointAt)) {
                            int i4 = b2 & 255;
                            sb.append(HttpUrlHelperUtil.writeByte(37));
                            sb.append(HttpUrlHelperUtil.writeByte(HEX_DIGITS[(i4 >> 4) & 15]));
                            sb.append(HttpUrlHelperUtil.writeByte(HEX_DIGITS[i4 & 15]));
                        }
                    }
                }
                i2 += Character.charCount(codePointAt);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static int defaultPort(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return com.baidu.android.imsdk.internal.Constants.SOCKET_PORT_SSL;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static HttpUrlHelper get(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, url)) == null) ? parse(url.toString()) : (HttpUrlHelper) invokeL.objValue;
    }

    public static HttpUrlHelper getChecked(String str) throws MalformedURLException, UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            Builder builder = new Builder();
            Builder.ParseResult parse = builder.parse(null, str);
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$down$utils$HttpUrlHelper$Builder$ParseResult[parse.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new MalformedURLException("Invalid URL: " + parse + " for " + str);
                }
                throw new UnknownHostException("Invalid host: " + str);
            }
            return builder.build();
        }
        return (HttpUrlHelper) invokeL.objValue;
    }

    public static void namesAndValuesToQueryString(StringBuilder sb, List<String> list) {
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
                    sb.append(a.f35879h);
                    sb.append(str2);
                }
            }
        }
    }

    public static HttpUrlHelper parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            Builder builder = new Builder();
            if (builder.parse(null, str) == Builder.ParseResult.SUCCESS) {
                return builder.build();
            }
            return null;
        }
        return (HttpUrlHelper) invokeL.objValue;
    }

    public static void pathSegmentsToString(StringBuilder sb, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, sb, list) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append('/');
                sb.append(list.get(i2));
            }
        }
    }

    public static String percentDecode(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, null, str, z)) == null) ? percentDecode(str, 0, str.length(), z) : (String) invokeLZ.objValue;
    }

    public static String percentDecode2(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            while (i2 < i3) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                    int decodeHexDigit = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i2 + 1));
                    int decodeHexDigit2 = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i4));
                    if (decodeHexDigit != -1 && decodeHexDigit2 != -1) {
                        sb.append(HttpUrlHelperUtil.writeByte((decodeHexDigit << 4) + decodeHexDigit2));
                        i2 = i4;
                    }
                    sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
                } else {
                    if (codePointAt == 43 && z) {
                        sb.append(HttpUrlHelperUtil.writeByte(32));
                    }
                    sb.append(HttpUrlHelperUtil.writeUtf8CodePoint(codePointAt));
                }
                i2 += Character.charCount(codePointAt);
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean percentEncoded(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, str, i2, i3)) == null) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && HttpUrlHelperUtil.decodeHexDigit(str.charAt(i2 + 1)) != -1 && HttpUrlHelperUtil.decodeHexDigit(str.charAt(i4)) != -1;
        }
        return invokeLII.booleanValue;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
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

    public String encodedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.fragment == null) {
                return null;
            }
            return this.url.substring(this.url.indexOf(35) + 1);
        }
        return (String) invokeV.objValue;
    }

    public String encodedPassword() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.password.isEmpty()) {
                return "";
            }
            return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
        }
        return (String) invokeV.objValue;
    }

    public String encodedPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
            String str = this.url;
            return this.url.substring(indexOf, HttpUrlHelperUtil.delimiterOffset(str, indexOf, str.length(), "?#"));
        }
        return (String) invokeV.objValue;
    }

    public List<String> encodedPathSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
            String str = this.url;
            int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, indexOf, str.length(), "?#");
            ArrayList arrayList = new ArrayList();
            while (indexOf < delimiterOffset) {
                int i2 = indexOf + 1;
                int delimiterOffset2 = HttpUrlHelperUtil.delimiterOffset(this.url, i2, delimiterOffset, '/');
                arrayList.add(this.url.substring(i2, delimiterOffset2));
                indexOf = delimiterOffset2;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String encodedQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return null;
            }
            int indexOf = this.url.indexOf(63) + 1;
            String str = this.url;
            return this.url.substring(indexOf, HttpUrlHelperUtil.delimiterOffset(str, indexOf + 1, str.length(), '#'));
        }
        return (String) invokeV.objValue;
    }

    public String encodedUsername() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.username.isEmpty()) {
                return "";
            }
            int length = this.scheme.length() + 3;
            String str = this.url;
            return this.url.substring(length, HttpUrlHelperUtil.delimiterOffset(str, length, str.length(), ":@"));
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? (obj instanceof HttpUrlHelper) && ((HttpUrlHelper) obj).url.equals(this.url) : invokeL.booleanValue;
    }

    public String fragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.fragment : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.url.hashCode() : invokeV.intValue;
    }

    public String host() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.host : (String) invokeV.objValue;
    }

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.scheme.equals("https") : invokeV.booleanValue;
    }

    public Builder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        return (Builder) invokeV.objValue;
    }

    public String password() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.password : (String) invokeV.objValue;
    }

    public List<String> pathSegments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.pathSegments : (List) invokeV.objValue;
    }

    public int pathSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.pathSegments.size() : invokeV.intValue;
    }

    public int port() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.port : invokeV.intValue;
    }

    public String query() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            namesAndValuesToQueryString(sb, this.queryNamesAndValues);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String queryParameter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                if (str.equals(this.queryNamesAndValues.get(i2))) {
                    return this.queryNamesAndValues.get(i2 + 1);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public String queryParameterName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.queryNamesAndValues.get(i2 * 2) : (String) invokeI.objValue;
    }

    public Set<String> queryParameterNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.queryNamesAndValues == null) {
                return Collections.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = this.queryNamesAndValues.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                linkedHashSet.add(this.queryNamesAndValues.get(i2));
            }
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return (Set) invokeV.objValue;
    }

    public String queryParameterValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.queryNamesAndValues.get((i2 * 2) + 1) : (String) invokeI.objValue;
    }

    public List<String> queryParameterValues(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (this.queryNamesAndValues == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int size = this.queryNamesAndValues.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                if (str.equals(this.queryNamesAndValues.get(i2))) {
                    arrayList.add(this.queryNamesAndValues.get(i2 + 1));
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public int querySize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            List<String> list = this.queryNamesAndValues;
            if (list != null) {
                return list.size() / 2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public HttpUrlHelper resolve(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            Builder newBuilder = newBuilder(str);
            if (newBuilder != null) {
                return newBuilder.build();
            }
            return null;
        }
        return (HttpUrlHelper) invokeL.objValue;
    }

    public String scheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.scheme : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public URI uri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            String builder = newBuilder().reencodeForUri().toString();
            try {
                return new URI(builder);
            } catch (URISyntaxException e2) {
                try {
                    return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                } catch (Exception unused) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return (URI) invokeV.objValue;
    }

    public URL url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                return new URL(this.url);
            } catch (MalformedURLException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (URL) invokeV.objValue;
    }

    public String username() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.username : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String encodedFragment;
        public String encodedPassword;
        public final List<String> encodedPathSegments;
        public List<String> encodedQueryNamesAndValues;
        public String encodedUsername;
        public String host;
        public int port;
        public String scheme;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes5.dex */
        public static final class ParseResult {
            public static final /* synthetic */ ParseResult[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ParseResult INVALID_HOST;
            public static final ParseResult INVALID_PORT;
            public static final ParseResult MISSING_SCHEME;
            public static final ParseResult SUCCESS;
            public static final ParseResult UNSUPPORTED_SCHEME;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1922220000, "Lcom/baidu/down/utils/HttpUrlHelper$Builder$ParseResult;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1922220000, "Lcom/baidu/down/utils/HttpUrlHelper$Builder$ParseResult;");
                        return;
                    }
                }
                SUCCESS = new ParseResult(c.f36090g, 0);
                MISSING_SCHEME = new ParseResult("MISSING_SCHEME", 1);
                UNSUPPORTED_SCHEME = new ParseResult("UNSUPPORTED_SCHEME", 2);
                INVALID_PORT = new ParseResult("INVALID_PORT", 3);
                ParseResult parseResult = new ParseResult("INVALID_HOST", 4);
                INVALID_HOST = parseResult;
                $VALUES = new ParseResult[]{SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, parseResult};
            }

            public ParseResult(String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                    }
                }
            }

            public static ParseResult valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ParseResult) Enum.valueOf(ParseResult.class, str) : (ParseResult) invokeL.objValue;
            }

            public static ParseResult[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ParseResult[]) $VALUES.clone() : (ParseResult[]) invokeV.objValue;
            }
        }

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
            InetAddress decodeIpv6;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, str, i2, i3)) == null) {
                String percentDecode = HttpUrlHelper.percentDecode(str, i2, i3, false);
                if (percentDecode.contains(":")) {
                    if (percentDecode.startsWith(PreferencesUtil.LEFT_MOUNT) && percentDecode.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
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
            return (String) invokeLII.objValue;
        }

        public static boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)})) == null) {
                int i5 = i4;
                while (i2 < i3) {
                    if (i5 == bArr.length) {
                        return false;
                    }
                    if (i5 != i4) {
                        if (str.charAt(i2) != '.') {
                            return false;
                        }
                        i2++;
                    }
                    int i6 = i2;
                    int i7 = 0;
                    while (i6 < i3) {
                        char charAt = str.charAt(i6);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                            return false;
                        } else {
                            i6++;
                        }
                    }
                    if (i6 - i2 == 0) {
                        return false;
                    }
                    bArr[i5] = (byte) i7;
                    i5++;
                    i2 = i6;
                }
                return i5 == i4 + 4;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static InetAddress decodeIpv6(String str, int i2, int i3) {
            InterceptResult invokeLII;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
                byte[] bArr = new byte[16];
                int i5 = 0;
                int i6 = -1;
                int i7 = -1;
                while (true) {
                    if (i2 < i3) {
                        if (i5 != 16) {
                            int i8 = i2 + 2;
                            if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                                if (i6 == -1) {
                                    i5 += 2;
                                    i6 = i5;
                                    if (i8 != i3) {
                                        i7 = i8;
                                        i2 = i7;
                                        int i9 = 0;
                                        while (i2 < i3) {
                                        }
                                        i4 = i2 - i7;
                                        if (i4 == 0) {
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                return null;
                            }
                            if (i5 != 0) {
                                if (str.regionMatches(i2, ":", 0, 1)) {
                                    i2++;
                                } else if (!str.regionMatches(i2, ".", 0, 1) || !decodeIpv4Suffix(str, i7, i3, bArr, i5 - 2)) {
                                    return null;
                                } else {
                                    i5 += 2;
                                }
                            }
                            i7 = i2;
                            i2 = i7;
                            int i92 = 0;
                            while (i2 < i3) {
                                int decodeHexDigit = HttpUrlHelperUtil.decodeHexDigit(str.charAt(i2));
                                if (decodeHexDigit == -1) {
                                    break;
                                }
                                i92 = (i92 << 4) + decodeHexDigit;
                                i2++;
                            }
                            i4 = i2 - i7;
                            if (i4 == 0 || i4 > 4) {
                                break;
                            }
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((i92 >>> 8) & 255);
                            i5 = i10 + 1;
                            bArr[i10] = (byte) (i92 & 255);
                        } else {
                            return null;
                        }
                    } else {
                        break;
                    }
                }
                if (i5 != 16) {
                    if (i6 == -1) {
                        return null;
                    }
                    int i11 = i5 - i6;
                    System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
                    Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
                }
                try {
                    return InetAddress.getByAddress(bArr);
                } catch (UnknownHostException unused) {
                    throw new AssertionError();
                }
            }
            return (InetAddress) invokeLII.objValue;
        }

        public static String inet6AddressToAscii(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
                int i2 = 0;
                int i3 = -1;
                int i4 = 0;
                int i5 = 0;
                while (i4 < bArr.length) {
                    int i6 = i4;
                    while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                        i6 += 2;
                    }
                    int i7 = i6 - i4;
                    if (i7 > i5) {
                        i3 = i4;
                        i5 = i7;
                    }
                    i4 = i6 + 2;
                }
                StringBuilder sb = new StringBuilder();
                while (i2 < bArr.length) {
                    if (i2 == i3) {
                        sb.append(HttpUrlHelperUtil.writeByte(58));
                        i2 += i5;
                        if (i2 == 16) {
                            sb.append(HttpUrlHelperUtil.writeByte(58));
                        }
                    } else {
                        if (i2 > 0) {
                            sb.append(HttpUrlHelperUtil.writeByte(58));
                        }
                        sb.append(HttpUrlHelperUtil.writeHexadecimalUnsignedLong(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                        i2 += 2;
                    }
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }

        private boolean isDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? str.equals(".") || str.equalsIgnoreCase("%2e") : invokeL.booleanValue;
        }

        private boolean isDotDot(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) ? str.equals(IStringUtil.TOP_PATH) || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e") : invokeL.booleanValue;
        }

        public static int parsePort(String str, int i2, int i3) {
            InterceptResult invokeLII;
            int parseInt;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) {
                try {
                    parseInt = Integer.parseInt(HttpUrlHelper.canonicalize(str, i2, i3, "", false, false, false, true));
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
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
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
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, str, i2, i3)) == null) {
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
            if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                String canonicalize = HttpUrlHelper.canonicalize(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true);
                if (isDot(canonicalize)) {
                    return;
                }
                if (isDotDot(canonicalize)) {
                    pop();
                    return;
                }
                List<String> list = this.encodedPathSegments;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.encodedPathSegments;
                    list2.set(list2.size() - 1, canonicalize);
                } else {
                    this.encodedPathSegments.add(canonicalize);
                }
                if (z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
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
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.down.utils.HttpUrlHelper.Builder.$ic
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
                int r12 = com.baidu.down.utils.HttpUrlHelperUtil.delimiterOffset(r11, r6, r13, r12)
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
                r9 = 65549(0x1000d, float:9.1854E-41)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r8.invokeLII(r9, r10, r11, r12, r13)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.down.utils.HttpUrlHelper.Builder.resolvePath(java.lang.String, int, int):void");
        }

        public static int schemeDelimiterOffset(String str, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, str, i2, i3)) == null) {
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
            if (interceptable == null || (invokeLII = interceptable.invokeLII(65551, null, str, i2, i3)) == null) {
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

        public Builder addEncodedPathSegment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    push(str, 0, str.length(), false, true);
                    return this;
                }
                throw new NullPointerException("encodedPathSegment == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addEncodedPathSegments(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null) {
                    return addPathSegments(str, true);
                }
                throw new NullPointerException("encodedPathSegments == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addPathSegment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null) {
                    push(str, 0, str.length(), false, false);
                    return this;
                }
                throw new NullPointerException("pathSegment == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder addPathSegments(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    return addPathSegments(str, false);
                }
                throw new NullPointerException("pathSegments == null");
            }
            return (Builder) invokeL.objValue;
        }

        public HttpUrlHelper build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.scheme != null) {
                    if (this.host != null) {
                        return new HttpUrlHelper(this, null);
                    }
                    throw new IllegalStateException("host == null");
                }
                throw new IllegalStateException("scheme == null");
            }
            return (HttpUrlHelper) invokeV.objValue;
        }

        public int effectivePort() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                int i2 = this.port;
                return i2 != -1 ? i2 : HttpUrlHelper.defaultPort(this.scheme);
            }
            return invokeV.intValue;
        }

        public Builder encodedFragment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.encodedFragment = str != null ? HttpUrlHelper.canonicalize(str, "", true, false, false, false) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedPassword(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                if (str != null) {
                    this.encodedPassword = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                    return this;
                }
                throw new NullPointerException("encodedPassword == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                if (str != null) {
                    if (str.startsWith("/")) {
                        resolvePath(str, 0, str.length());
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected encodedPath: " + str);
                }
                throw new NullPointerException("encodedPath == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedQuery(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.encodedQueryNamesAndValues = str != null ? HttpUrlHelper.queryStringToNamesAndValues(HttpUrlHelper.canonicalize(str, " \"'<>#", true, false, true, true)) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder encodedUsername(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                if (str != null) {
                    this.encodedUsername = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                    return this;
                }
                throw new NullPointerException("encodedUsername == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder fragment(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.encodedFragment = str != null ? HttpUrlHelper.canonicalize(str, "", false, false, false, false) : null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder host(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
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

        public ParseResult parse(HttpUrlHelper httpUrlHelper, String str) {
            InterceptResult invokeLL;
            int delimiterOffset;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, httpUrlHelper, str)) == null) {
                int skipLeadingAsciiWhitespace = HttpUrlHelperUtil.skipLeadingAsciiWhitespace(str, 0, str.length());
                int skipTrailingAsciiWhitespace = HttpUrlHelperUtil.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
                if (schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                    if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTPS, 0, 6)) {
                        this.scheme = "https";
                        skipLeadingAsciiWhitespace += 6;
                    } else if (str.regionMatches(true, skipLeadingAsciiWhitespace, UrlSchemaHelper.SCHEMA_TYPE_HTTP, 0, 5)) {
                        this.scheme = "http";
                        skipLeadingAsciiWhitespace += 5;
                    } else {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                } else if (httpUrlHelper != null) {
                    this.scheme = httpUrlHelper.scheme;
                } else {
                    return ParseResult.MISSING_SCHEME;
                }
                int slashCount = slashCount(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
                char c2 = '?';
                char c3 = '#';
                if (slashCount < 2 && httpUrlHelper != null && httpUrlHelper.scheme.equals(this.scheme)) {
                    this.encodedUsername = httpUrlHelper.encodedUsername();
                    this.encodedPassword = httpUrlHelper.encodedPassword();
                    this.host = httpUrlHelper.host;
                    this.port = httpUrlHelper.port;
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.addAll(httpUrlHelper.encodedPathSegments());
                    if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                        encodedQuery(httpUrlHelper.encodedQuery());
                    }
                } else {
                    int i3 = skipLeadingAsciiWhitespace + slashCount;
                    boolean z = false;
                    boolean z2 = false;
                    while (true) {
                        delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, i3, skipTrailingAsciiWhitespace, "@/\\?#");
                        char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                        if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                            break;
                        }
                        if (charAt == '@') {
                            if (!z) {
                                int delimiterOffset2 = HttpUrlHelperUtil.delimiterOffset(str, i3, delimiterOffset, ':');
                                i2 = delimiterOffset;
                                String canonicalize = HttpUrlHelper.canonicalize(str, i3, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                if (z2) {
                                    canonicalize = this.encodedUsername + "%40" + canonicalize;
                                }
                                this.encodedUsername = canonicalize;
                                if (delimiterOffset2 != i2) {
                                    this.encodedPassword = HttpUrlHelper.canonicalize(str, delimiterOffset2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = delimiterOffset;
                                this.encodedPassword += "%40" + HttpUrlHelper.canonicalize(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                    int portColonOffset = portColonOffset(str, i3, delimiterOffset);
                    int i4 = portColonOffset + 1;
                    if (i4 < delimiterOffset) {
                        this.host = canonicalizeHost(str, i3, portColonOffset);
                        int parsePort = parsePort(str, i4, delimiterOffset);
                        this.port = parsePort;
                        if (parsePort == -1) {
                            return ParseResult.INVALID_PORT;
                        }
                    } else {
                        this.host = canonicalizeHost(str, i3, portColonOffset);
                        this.port = HttpUrlHelper.defaultPort(this.scheme);
                    }
                    if (this.host == null) {
                        return ParseResult.INVALID_HOST;
                    }
                    skipLeadingAsciiWhitespace = delimiterOffset;
                }
                int delimiterOffset3 = HttpUrlHelperUtil.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
                resolvePath(str, skipLeadingAsciiWhitespace, delimiterOffset3);
                if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                    int delimiterOffset4 = HttpUrlHelperUtil.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, '#');
                    this.encodedQueryNamesAndValues = HttpUrlHelper.queryStringToNamesAndValues(HttpUrlHelper.canonicalize(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, false, true));
                    delimiterOffset3 = delimiterOffset4;
                }
                if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                    this.encodedFragment = HttpUrlHelper.canonicalize(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false, false);
                }
                return ParseResult.SUCCESS;
            }
            return (ParseResult) invokeLL.objValue;
        }

        public Builder password(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                if (str != null) {
                    this.encodedPassword = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("password == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder port(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
                if (i2 > 0 && i2 <= 65535) {
                    this.port = i2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            return (Builder) invokeI.objValue;
        }

        public Builder reencodeForUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                int size = this.encodedPathSegments.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.encodedPathSegments.set(i2, HttpUrlHelper.canonicalize(this.encodedPathSegments.get(i2), "[]", true, true, false, true));
                }
                List<String> list = this.encodedQueryNamesAndValues;
                if (list != null) {
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        String str = this.encodedQueryNamesAndValues.get(i3);
                        if (str != null) {
                            this.encodedQueryNamesAndValues.set(i3, HttpUrlHelper.canonicalize(str, "\\^`{|}", true, true, true, true));
                        }
                    }
                }
                String str2 = this.encodedFragment;
                if (str2 != null) {
                    this.encodedFragment = HttpUrlHelper.canonicalize(str2, " \"#<>\\^`{|}", true, true, false, false);
                }
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder removePathSegment(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
                this.encodedPathSegments.remove(i2);
                if (this.encodedPathSegments.isEmpty()) {
                    this.encodedPathSegments.add("");
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder scheme(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
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

        public Builder setEncodedPathSegment(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, str)) == null) {
                if (str != null) {
                    String canonicalize = HttpUrlHelper.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true);
                    this.encodedPathSegments.set(i2, canonicalize);
                    if (isDot(canonicalize) || isDotDot(canonicalize)) {
                        throw new IllegalArgumentException("unexpected path segment: " + str);
                    }
                    return this;
                }
                throw new NullPointerException("encodedPathSegment == null");
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setPathSegment(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i2, str)) == null) {
                if (str != null) {
                    String canonicalize = HttpUrlHelper.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true);
                    if (!isDot(canonicalize) && !isDotDot(canonicalize)) {
                        this.encodedPathSegments.set(i2, canonicalize);
                        return this;
                    }
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                throw new NullPointerException("pathSegment == null");
            }
            return (Builder) invokeIL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
                    sb.append('#');
                    sb.append(this.encodedFragment);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public Builder username(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                if (str != null) {
                    this.encodedUsername = HttpUrlHelper.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                    return this;
                }
                throw new NullPointerException("username == null");
            }
            return (Builder) invokeL.objValue;
        }

        private Builder addPathSegments(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, str, z)) == null) {
                int i2 = 0;
                do {
                    int delimiterOffset = HttpUrlHelperUtil.delimiterOffset(str, i2, str.length(), "/\\");
                    push(str, i2, delimiterOffset, delimiterOffset < str.length(), z);
                    i2 = delimiterOffset + 1;
                } while (i2 <= str.length());
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }
    }

    public HttpUrlHelper(Builder builder) {
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
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    public static HttpUrlHelper get(URI uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, uri)) == null) ? parse(uri.toString()) : (HttpUrlHelper) invokeL.objValue;
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65554, this, list, z)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(next != null ? percentDecode(next, z) : null);
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeLZ.objValue;
    }

    public static String percentDecode(String str, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i4 = i2; i4 < i3; i4++) {
                char charAt = str.charAt(i4);
                if (charAt == '%' || (charAt == '+' && z)) {
                    try {
                        sb.append(URLEncoder.encode(str.substring(i2, i4), "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    sb.append(percentDecode2(str, i4, i3, z));
                    return sb.toString();
                }
            }
            return str.substring(i2, i3);
        }
        return (String) invokeCommon.objValue;
    }

    public static String canonicalize(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) ? canonicalize(str, 0, str.length(), str2, z, z2, z3, z4) : (String) invokeCommon.objValue;
    }

    public Builder newBuilder(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Builder builder = new Builder();
            if (builder.parse(this, str) == Builder.ParseResult.SUCCESS) {
                return builder;
            }
            return null;
        }
        return (Builder) invokeL.objValue;
    }
}
