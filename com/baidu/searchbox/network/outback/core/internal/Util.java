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
import org.apache.commons.base.CharEncoding;
/* loaded from: classes2.dex */
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

    public static int decodeHexDigit(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c < '0' || c > '9') {
                char c2 = 'a';
                if (c < 'a' || c > 'f') {
                    c2 = 'A';
                    if (c < 'A' || c > 'F') {
                        return -1;
                    }
                }
                return (c - c2) + 10;
            }
            return c - '0';
        }
        return invokeCommon.intValue;
    }

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
        UTF_16_BE = Charset.forName(CharEncoding.UTF_16BE);
        UTF_16_LE = Charset.forName(CharEncoding.UTF_16LE);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static void writeUtf8CodePoint(OutputStream outputStream, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65567, null, outputStream, i) == null) {
            if (i < 128) {
                outputStream.write(i);
            } else if (i < 2048) {
                outputStream.write((i >> 6) | 192);
                outputStream.write((i & 63) | 128);
            } else if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    outputStream.write(63);
                    return;
                }
                outputStream.write((i >> 12) | 224);
                outputStream.write(((i >> 6) & 63) | 128);
                outputStream.write((i & 63) | 128);
            } else if (i <= 1114111) {
                outputStream.write((i >> 18) | 240);
                outputStream.write(((i >> 12) & 63) | 128);
                outputStream.write(((i >> 6) & 63) | 128);
                outputStream.write((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        }
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

    public static String inet6AddressToAscii(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4 && i6 >= 4) {
                    i2 = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            StringBuilder sb = new StringBuilder();
            while (i < bArr.length) {
                if (i == i2) {
                    sb.append(':');
                    i += i4;
                    if (i == 16) {
                        sb.append(':');
                    }
                } else {
                    if (i > 0) {
                        sb.append(':');
                    }
                    sb.append(Integer.toHexString(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static int checkDuration(String str, long j, TimeUnit timeUnit) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j), timeUnit})) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (timeUnit != null) {
                    long millis = timeUnit.toMillis(j);
                    if (millis <= 2147483647L) {
                        if (millis == 0 && i > 0) {
                            throw new IllegalArgumentException(str + " too small.");
                        }
                        return (int) millis;
                    }
                    throw new IllegalArgumentException(str + " too large.");
                }
                throw new NullPointerException("unit == null");
            }
            throw new IllegalArgumentException(str + " < 0");
        }
        return invokeCommon.intValue;
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if ((j2 | j3) >= 0 && j2 <= j && j - j2 >= j3) {
                return;
            }
            throw new ArrayIndexOutOfBoundsException("offset out of bounds");
        }
    }

    public static boolean rangeEquals(ByteBuffer byteBuffer, int i, byte[] bArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, byteBuffer, i, bArr)) == null) {
            if (i < 0 || byteBuffer.remaining() - i < bArr.length) {
                return false;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (byteBuffer.get(byteBuffer.position() + i + i2) != bArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65560, null, str, i, i2)) == null) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }
        return invokeLII.intValue;
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static <T> List<T> immutableList(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, list)) == null) {
            return Collections.unmodifiableList(new ArrayList(list));
        }
        return (List) invokeL.objValue;
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
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean isTextEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            if (str != null && str.length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean verifyAsIpAddress(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            return VERIFY_AS_IP_ADDRESS.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), bArr, Integer.valueOf(i3)})) == null) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            if (i4 != i3 + 4) {
                return false;
            }
            return true;
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
    public static InetAddress decodeIpv6(String str, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65546, null, str, i, i2)) == null) {
            byte[] bArr = new byte[16];
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i < i2) {
                    if (i4 == 16) {
                        return null;
                    }
                    int i7 = i + 2;
                    if (i7 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                        if (i5 != -1) {
                            return null;
                        }
                        i4 += 2;
                        i5 = i4;
                        if (i7 != i2) {
                            i6 = i7;
                            i = i6;
                            int i8 = 0;
                            while (i < i2) {
                            }
                            i3 = i - i6;
                            if (i3 == 0) {
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    if (i4 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!str.regionMatches(i, ".", 0, 1) || !decodeIpv4Suffix(str, i6, i2, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i;
                    i = i6;
                    int i82 = 0;
                    while (i < i2) {
                        int decodeHexDigit = decodeHexDigit(str.charAt(i));
                        if (decodeHexDigit == -1) {
                            break;
                        }
                        i82 = (i82 << 4) + decodeHexDigit;
                        i++;
                    }
                    i3 = i - i6;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i9 = i4 + 1;
                    bArr[i4] = (byte) ((i82 >>> 8) & 255);
                    i4 = i9 + 1;
                    bArr[i9] = (byte) (i82 & 255);
                } else {
                    break;
                }
            }
            if (i4 != 16) {
                if (i5 == -1) {
                    return null;
                }
                int i10 = i4 - i5;
                System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
                Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeLII.objValue;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)})) == null) {
            while (i < i2) {
                if (str.charAt(i) == c) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            while (i < i2) {
                if (str2.indexOf(str.charAt(i)) != -1) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, obj, obj2)) == null) {
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, objArr)) == null) {
            return String.format(Locale.US, str, objArr);
        }
        return (String) invokeLL.objValue;
    }

    public static ThreadFactory threadFactory(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65561, null, str, z)) == null) {
            return new ThreadFactory(str, z) { // from class: com.baidu.searchbox.network.outback.core.internal.Util.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
            };
        }
        return (ThreadFactory) invokeLZ.objValue;
    }

    public static void writeUtf8(OutputStream outputStream, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, outputStream, str) == null) {
            writeUtf8(outputStream, str, 0, str.length());
        }
    }

    public static <T> List<T> immutableList(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, tArr)) == null) {
            return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
        }
        return (List) invokeL.objValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65559, null, str, i, i2)) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static String trimSubstring(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, null, str, i, i2)) == null) {
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
            return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
        }
        return (String) invokeLII.objValue;
    }

    public static void writeDecimalLong(OutputStream outputStream, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65564, null, outputStream, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i == 0) {
                outputStream.write(48);
                return;
            }
            boolean z = false;
            int i2 = 1;
            if (i < 0) {
                j = -j;
                if (j < 0) {
                    writeUtf8(outputStream, "-9223372036854775808");
                    return;
                }
                z = true;
            }
            if (j < 100000000) {
                if (j < 10000) {
                    if (j < 100) {
                        if (j >= 10) {
                            i2 = 2;
                        }
                    } else if (j < 1000) {
                        i2 = 3;
                    } else {
                        i2 = 4;
                    }
                } else if (j < 1000000) {
                    if (j < 100000) {
                        i2 = 5;
                    } else {
                        i2 = 6;
                    }
                } else if (j < 10000000) {
                    i2 = 7;
                } else {
                    i2 = 8;
                }
            } else if (j < BasicLabelFormatter.TRILLION) {
                if (j < 10000000000L) {
                    if (j < C.NANOS_PER_SECOND) {
                        i2 = 9;
                    } else {
                        i2 = 10;
                    }
                } else if (j < 100000000000L) {
                    i2 = 11;
                } else {
                    i2 = 12;
                }
            } else if (j < 1000000000000000L) {
                if (j < 10000000000000L) {
                    i2 = 13;
                } else if (j < 100000000000000L) {
                    i2 = 14;
                } else {
                    i2 = 15;
                }
            } else if (j < 100000000000000000L) {
                if (j < 10000000000000000L) {
                    i2 = 16;
                } else {
                    i2 = 17;
                }
            } else if (j < 1000000000000000000L) {
                i2 = 18;
            } else {
                i2 = 19;
            }
            if (z) {
                i2++;
            }
            byte[] bArr = new byte[i2];
            while (j != 0) {
                i2--;
                bArr[i2] = DIGITS[(int) (j % 10)];
                j /= 10;
            }
            if (z) {
                bArr[i2 - 1] = 45;
            }
            outputStream.write(bArr);
        }
    }

    public static void writeUtf8(OutputStream outputStream, String str, int i, int i2) throws IOException {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65566, null, outputStream, str, i, i2) == null) {
            if (str != null) {
                if (i >= 0) {
                    if (i2 >= i) {
                        if (i2 <= str.length()) {
                            while (i < i2) {
                                char charAt = str.charAt(i);
                                if (charAt < 128) {
                                    outputStream.write(charAt);
                                } else if (charAt < 2048) {
                                    outputStream.write((charAt >> 6) | 192);
                                    outputStream.write((charAt & '?') | 128);
                                } else if (charAt >= 55296 && charAt <= 57343) {
                                    int i3 = i + 1;
                                    if (i3 < i2) {
                                        c = str.charAt(i3);
                                    } else {
                                        c = 0;
                                    }
                                    if (charAt <= 56319 && c >= 56320 && c <= 57343) {
                                        int i4 = (((charAt & 10239) << 10) | (9215 & c)) + 65536;
                                        outputStream.write((i4 >> 18) | 240);
                                        outputStream.write(((i4 >> 12) & 63) | 128);
                                        outputStream.write(((i4 >> 6) & 63) | 128);
                                        outputStream.write((i4 & 63) | 128);
                                        i += 2;
                                    } else {
                                        outputStream.write(63);
                                        i = i3;
                                    }
                                } else {
                                    outputStream.write((charAt >> '\f') | 224);
                                    outputStream.write(((charAt >> 6) & 63) | 128);
                                    outputStream.write((charAt & '?') | 128);
                                }
                                i++;
                            }
                            return;
                        }
                        throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                }
                throw new IllegalArgumentException("beginIndex < 0: " + i);
            }
            throw new IllegalArgumentException("string == null");
        }
    }
}
