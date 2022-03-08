package com.baidu.searchbox.network.outback.core.internal;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.network.outback.core.HttpUrl;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.material.slider.BasicLabelFormatter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class Util {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] DIGITS;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final RequestBody EMPTY_REQUEST;
    public static final Charset ISO_8859_1;
    public static final TimeZone UTC;
    public static final Charset UTF_16_BE;
    public static final byte[] UTF_16_BE_BOM_BYTES;
    public static final Charset UTF_16_LE;
    public static final byte[] UTF_16_LE_BOM_BYTES;
    public static final Charset UTF_32_BE;
    public static final byte[] UTF_32_BE_BOM_BYTES;
    public static final Charset UTF_32_LE;
    public static final byte[] UTF_32_LE_BOM_BYTES;
    public static final Charset UTF_8;
    public static final byte[] UTF_8_BOM_BYTES;
    public static final Pattern VERIFY_AS_IP_ADDRESS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1175400834, "Lcom/baidu/searchbox/network/outback/core/internal/Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1175400834, "Lcom/baidu/searchbox/network/outback/core/internal/Util;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_REQUEST = RequestBody.create((MediaType) null, bArr);
        UTF_8_BOM_BYTES = new byte[]{-17, -69, -65};
        UTF_16_BE_BOM_BYTES = new byte[]{-2, -1};
        UTF_16_LE_BOM_BYTES = new byte[]{-1, -2};
        UTF_32_BE_BOM_BYTES = new byte[]{0, 0, -1, -1};
        UTF_32_LE_BOM_BYTES = new byte[]{-1, -1, 0, 0};
        DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102};
        UTF_8 = Charset.forName("UTF-8");
        ISO_8859_1 = Charset.forName("ISO-8859-1");
        UTF_16_BE = Charset.forName("UTF-16BE");
        UTF_16_LE = Charset.forName("UTF-16LE");
        UTF_32_BE = Charset.forName("UTF-32BE");
        UTF_32_LE = Charset.forName("UTF-32LE");
        UTC = TimeZone.getTimeZone("GMT");
        VERIFY_AS_IP_ADDRESS = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public Util() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Charset bomAwareCharset(ByteBuffer byteBuffer, Charset charset) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, byteBuffer, charset)) == null) {
            if (rangeEquals(byteBuffer, 0, UTF_8_BOM_BYTES)) {
                byteBuffer.position(byteBuffer.position() + UTF_8_BOM_BYTES.length);
                return UTF_8;
            } else if (rangeEquals(byteBuffer, 0, UTF_16_BE_BOM_BYTES)) {
                byteBuffer.position(byteBuffer.position() + UTF_16_BE_BOM_BYTES.length);
                return UTF_16_BE;
            } else if (rangeEquals(byteBuffer, 0, UTF_16_LE_BOM_BYTES)) {
                byteBuffer.position(byteBuffer.position() + UTF_16_LE_BOM_BYTES.length);
                return UTF_16_LE;
            } else if (rangeEquals(byteBuffer, 0, UTF_32_BE_BOM_BYTES)) {
                byteBuffer.position(byteBuffer.position() + UTF_32_BE_BOM_BYTES.length);
                return UTF_32_BE;
            } else if (rangeEquals(byteBuffer, 0, UTF_32_LE_BOM_BYTES)) {
                byteBuffer.position(byteBuffer.position() + UTF_32_LE_BOM_BYTES.length);
                return UTF_32_LE;
            } else {
                return charset;
            }
        }
        return (Charset) invokeLL.objValue;
    }

    public static String canonicalizeHost(String str) {
        InterceptResult invokeL;
        InetAddress decodeIpv6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str.contains(":")) {
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
                } else {
                    decodeIpv6 = decodeIpv6(str, 0, str.length());
                }
                if (decodeIpv6 == null) {
                    return null;
                }
                byte[] address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    return inet6AddressToAscii(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int checkDuration(String str, long j2, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j2), timeUnit})) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j2);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i2 <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }
        return invokeCommon.intValue;
    }

    public static void checkOffsetAndCount(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
                throw new ArrayIndexOutOfBoundsException("offset out of bounds");
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int decodeHexDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'a';
                if (c2 < 'a' || c2 > 'f') {
                    c3 = 'A';
                    if (c2 < 'A' || c2 > 'F') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    public static boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)})) == null) {
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
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress decodeIpv6(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, str, i2, i3)) == null) {
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
                            int decodeHexDigit = decodeHexDigit(str.charAt(i2));
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

    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            while (i2 < i3) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, objArr)) == null) ? String.format(Locale.US, str, objArr) : (String) invokeLL.objValue;
    }

    public static String hostHeader(HttpUrl httpUrl, boolean z) {
        InterceptResult invokeLZ;
        String host;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65551, null, httpUrl, z)) == null) {
            if (httpUrl.host().contains(":")) {
                host = PreferencesUtil.LEFT_MOUNT + httpUrl.host() + PreferencesUtil.RIGHT_MOUNT;
            } else {
                host = httpUrl.host();
            }
            if (z || httpUrl.port() != HttpUrl.defaultPort(httpUrl.scheme())) {
                return host + ":" + httpUrl.port();
            }
            return host;
        }
        return (String) invokeLZ.objValue;
    }

    public static <T> List<T> immutableList(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) ? Collections.unmodifiableList(new ArrayList(list)) : (List) invokeL.objValue;
    }

    public static <K, V> Map<K, V> immutableMap(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, map)) == null) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        return (Map) invokeL.objValue;
    }

    public static int indexOfControlOrNonAscii(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String inet6AddressToAscii(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) {
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
                if (i7 > i5 && i7 >= 4) {
                    i3 = i4;
                    i5 = i7;
                }
                i4 = i6 + 2;
            }
            StringBuilder sb = new StringBuilder();
            while (i2 < bArr.length) {
                if (i2 == i3) {
                    sb.append(':');
                    i2 += i5;
                    if (i2 == 16) {
                        sb.append(':');
                    }
                } else {
                    if (i2 > 0) {
                        sb.append(':');
                    }
                    sb.append(Integer.toHexString(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                    i2 += 2;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean isTextEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static boolean rangeEquals(ByteBuffer byteBuffer, int i2, byte[] bArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, byteBuffer, i2, bArr)) == null) {
            if (i2 < 0 || byteBuffer.remaining() - i2 < bArr.length) {
                return false;
            }
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (byteBuffer.get(byteBuffer.position() + i2 + i3) != bArr[i3]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65559, null, str, i2, i3)) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65560, null, str, i2, i3)) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, str, z)) == null) ? new ThreadFactory(str, z) { // from class: com.baidu.searchbox.network.outback.core.internal.Util.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean val$daemon;
            public final /* synthetic */ String val$name;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$name = str;
                this.val$daemon = z;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    Thread thread = new Thread(runnable, this.val$name);
                    thread.setDaemon(this.val$daemon);
                    return thread;
                }
                return (Thread) invokeL.objValue;
            }
        } : (ThreadFactory) invokeLZ.objValue;
    }

    public static String trimSubstring(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, null, str, i2, i3)) == null) {
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i2, i3);
            return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i3));
        }
        return (String) invokeLII.objValue;
    }

    public static boolean verifyAsIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) ? VERIFY_AS_IP_ADDRESS.matcher(str).matches() : invokeL.booleanValue;
    }

    public static void writeDecimalLong(OutputStream outputStream, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65564, null, outputStream, j2) == null) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 == 0) {
                outputStream.write(48);
                return;
            }
            boolean z = false;
            int i3 = 1;
            if (i2 < 0) {
                j2 = -j2;
                if (j2 < 0) {
                    writeUtf8(outputStream, "-9223372036854775808");
                    return;
                }
                z = true;
            }
            if (j2 >= 100000000) {
                i3 = j2 < BasicLabelFormatter.TRILLION ? j2 < 10000000000L ? j2 < C.NANOS_PER_SECOND ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
            } else if (j2 >= 10000) {
                i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
            } else if (j2 >= 100) {
                i3 = j2 < 1000 ? 3 : 4;
            } else if (j2 >= 10) {
                i3 = 2;
            }
            if (z) {
                i3++;
            }
            byte[] bArr = new byte[i3];
            while (j2 != 0) {
                i3--;
                bArr[i3] = DIGITS[(int) (j2 % 10)];
                j2 /= 10;
            }
            if (z) {
                bArr[i3 - 1] = 45;
            }
            outputStream.write(bArr);
        }
    }

    public static void writeUtf8(OutputStream outputStream, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, outputStream, str) == null) {
            writeUtf8(outputStream, str, 0, str.length());
        }
    }

    public static void writeUtf8CodePoint(OutputStream outputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, null, outputStream, i2) == null) {
            if (i2 < 128) {
                outputStream.write(i2);
            } else if (i2 < 2048) {
                outputStream.write((i2 >> 6) | 192);
                outputStream.write((i2 & 63) | 128);
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    outputStream.write(63);
                    return;
                }
                outputStream.write((i2 >> 12) | 224);
                outputStream.write(((i2 >> 6) & 63) | 128);
                outputStream.write((i2 & 63) | 128);
            } else if (i2 <= 1114111) {
                outputStream.write((i2 >> 18) | 240);
                outputStream.write(((i2 >> 12) & 63) | 128);
                outputStream.write(((i2 >> 6) & 63) | 128);
                outputStream.write((i2 & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
        }
    }

    public static int delimiterOffset(String str, int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            while (i2 < i3) {
                if (str.charAt(i2) == c2) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static <T> List<T> immutableList(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tArr)) == null) ? Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone())) : (List) invokeL.objValue;
    }

    public static void writeUtf8(OutputStream outputStream, String str, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65566, null, outputStream, str, i2, i3) == null) {
            if (str == null) {
                throw new IllegalArgumentException("string == null");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i2);
            } else if (i3 >= i2) {
                if (i3 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
                }
                while (i2 < i3) {
                    char charAt = str.charAt(i2);
                    if (charAt < 128) {
                        outputStream.write(charAt);
                    } else if (charAt < 2048) {
                        outputStream.write((charAt >> 6) | 192);
                        outputStream.write((charAt & '?') | 128);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i4 = i2 + 1;
                        char charAt2 = i4 < i3 ? str.charAt(i4) : (char) 0;
                        if (charAt <= 56319 && charAt2 >= 56320 && charAt2 <= 57343) {
                            int i5 = (((charAt & 10239) << 10) | (9215 & charAt2)) + 65536;
                            outputStream.write((i5 >> 18) | 240);
                            outputStream.write(((i5 >> 12) & 63) | 128);
                            outputStream.write(((i5 >> 6) & 63) | 128);
                            outputStream.write((i5 & 63) | 128);
                            i2 += 2;
                        } else {
                            outputStream.write(63);
                            i2 = i4;
                        }
                    } else {
                        outputStream.write((charAt >> '\f') | 224);
                        outputStream.write(((charAt >> 6) & 63) | 128);
                        outputStream.write((charAt & '?') | 128);
                    }
                    i2++;
                }
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
            }
        }
    }
}
