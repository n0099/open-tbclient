package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSONException;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;
import kotlin.text.Typography;
import org.apache.commons.codec.digest4util.Sha2Crypt;
import org.aspectj.runtime.reflect.SignatureImpl;
/* loaded from: classes.dex */
public class IOUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    public static final Properties DEFAULT_PROPERTIES;
    public static final char[] DIGITS;
    public static final char[] DigitOnes;
    public static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    public static final Charset UTF8;
    public static final char[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    public static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-510072321, "Lcom/alibaba/fastjson/util/IOUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-510072321, "Lcom/alibaba/fastjson/util/IOUtils;");
                return;
            }
        }
        DEFAULT_PROPERTIES = new Properties();
        UTF8 = Charset.forName("UTF-8");
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        firstIdentifierFlags = new boolean[256];
        identifierFlags = new boolean[256];
        char c2 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                firstIdentifierFlags[c2] = true;
            } else if (c2 == '_' || c2 == '$') {
                firstIdentifierFlags[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        char c3 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c3 < zArr2.length) {
                if (c3 >= 'A' && c3 <= 'Z') {
                    zArr2[c3] = true;
                } else if (c3 >= 'a' && c3 <= 'z') {
                    identifierFlags[c3] = true;
                } else if (c3 == '_') {
                    identifierFlags[c3] = true;
                } else if (c3 >= '0' && c3 <= '9') {
                    identifierFlags[c3] = true;
                }
                c3 = (char) (c3 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i2 = 14; i2 <= 31; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        for (int i3 = 127; i3 < 160; i3++) {
            specicalFlags_doubleQuotes[i3] = 4;
            specicalFlags_singleQuotes[i3] = 4;
        }
        for (int i4 = 0; i4 < 161; i4++) {
            specicalFlags_doubleQuotesFlags[i4] = specicalFlags_doubleQuotes[i4] != 0;
            specicalFlags_singleQuotesFlags[i4] = specicalFlags_singleQuotes[i4] != 0;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = Typography.quote;
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, 9999, VideoItemModel.TYPE_LOADING, 999999, 9999999, 99999999, Sha2Crypt.ROUNDS_MAX, Integer.MAX_VALUE};
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = CA.length;
        for (int i5 = 0; i5 < length; i5++) {
            IA[CA[i5]] = i5;
        }
        IA[61] = 0;
    }

    public IOUtils() {
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

    public static void close(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, charsetDecoder, byteBuffer, charBuffer) == null) {
            try {
                CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
                if (!decode.isUnderflow()) {
                    decode.throwException();
                }
                CoderResult flush = charsetDecoder.flush(charBuffer);
                if (flush.isUnderflow()) {
                    return;
                }
                flush.throwException();
            } catch (CharacterCodingException e2) {
                throw new JSONException("utf8 decode error, " + e2.getMessage(), e2);
            }
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, cArr, i2, i3)) == null) {
            int i5 = 0;
            if (i3 == 0) {
                return new byte[0];
            }
            int i6 = (i2 + i3) - 1;
            while (i2 < i6 && IA[cArr[i2]] < 0) {
                i2++;
            }
            while (i6 > 0 && IA[cArr[i6]] < 0) {
                i6--;
            }
            int i7 = cArr[i6] == '=' ? cArr[i6 + (-1)] == '=' ? 2 : 1 : 0;
            int i8 = (i6 - i2) + 1;
            if (i3 > 76) {
                i4 = (cArr[76] == '\r' ? i8 / 78 : 0) << 1;
            } else {
                i4 = 0;
            }
            int i9 = (((i8 - i4) * 6) >> 3) - i7;
            byte[] bArr = new byte[i9];
            int i10 = (i9 / 3) * 3;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int[] iArr = IA;
                int i13 = i2 + 1;
                int i14 = i13 + 1;
                int i15 = (iArr[cArr[i2]] << 18) | (iArr[cArr[i13]] << 12);
                int i16 = i14 + 1;
                int i17 = i15 | (iArr[cArr[i14]] << 6);
                int i18 = i16 + 1;
                int i19 = i17 | iArr[cArr[i16]];
                int i20 = i11 + 1;
                bArr[i11] = (byte) (i19 >> 16);
                int i21 = i20 + 1;
                bArr[i20] = (byte) (i19 >> 8);
                int i22 = i21 + 1;
                bArr[i21] = (byte) i19;
                if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                    i2 = i18;
                } else {
                    i2 = i18 + 2;
                    i12 = 0;
                }
                i11 = i22;
            }
            if (i11 < i9) {
                int i23 = 0;
                while (i2 <= i6 - i7) {
                    i5 |= IA[cArr[i2]] << (18 - (i23 * 6));
                    i23++;
                    i2++;
                }
                int i24 = 16;
                while (i11 < i9) {
                    bArr[i11] = (byte) (i5 >> i24);
                    i24 -= 8;
                    i11++;
                }
            }
            return bArr;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static int decodeUTF8(byte[] bArr, int i2, int i3, char[] cArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), cArr})) == null) {
            int i4 = i2 + i3;
            int min = Math.min(i3, cArr.length);
            int i5 = 0;
            while (i5 < min && bArr[i2] >= 0) {
                cArr[i5] = (char) bArr[i2];
                i5++;
                i2++;
            }
            while (i2 < i4) {
                int i6 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    cArr[i5] = (char) b2;
                    i2 = i6;
                    i5++;
                } else if ((b2 >> 5) != -2 || (b2 & 30) == 0) {
                    if ((b2 >> 4) == -2) {
                        int i7 = i6 + 1;
                        if (i7 < i4) {
                            byte b3 = bArr[i6];
                            int i8 = i7 + 1;
                            byte b4 = bArr[i7];
                            if ((b2 != -32 || (b3 & 224) != 128) && (b3 & 192) == 128 && (b4 & 192) == 128) {
                                char c2 = (char) (((b2 << StandardMessageCodec.LIST) ^ (b3 << 6)) ^ ((-123008) ^ b4));
                                if (c2 >= 55296 && c2 < 57344) {
                                    return -1;
                                }
                                cArr[i5] = c2;
                                i5++;
                                i2 = i8;
                            }
                        }
                        return -1;
                    }
                    if ((b2 >> 3) == -2 && i6 + 2 < i4) {
                        int i9 = i6 + 1;
                        byte b5 = bArr[i6];
                        int i10 = i9 + 1;
                        byte b6 = bArr[i9];
                        int i11 = i10 + 1;
                        byte b7 = bArr[i10];
                        int i12 = (((b2 << 18) ^ (b5 << StandardMessageCodec.LIST)) ^ (b6 << 6)) ^ (3678080 ^ b7);
                        if ((b5 & 192) == 128 && (b6 & 192) == 128 && (b7 & 192) == 128 && i12 >= 65536 && i12 < 1114112) {
                            int i13 = i5 + 1;
                            cArr[i5] = (char) ((i12 >>> 10) + 55232);
                            i5 = i13 + 1;
                            cArr[i13] = (char) ((i12 & 1023) + 56320);
                            i2 = i11;
                        }
                    }
                    return -1;
                } else if (i6 >= i4) {
                    return -1;
                } else {
                    int i14 = i6 + 1;
                    byte b8 = bArr[i6];
                    if ((b8 & 192) != 128) {
                        return -1;
                    }
                    cArr[i5] = (char) (((b2 << 6) ^ b8) ^ 3968);
                    i2 = i14;
                    i5++;
                }
            }
            return i5;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0078 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARN: Type inference failed for: r10v16, types: [int] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v3, types: [int, char] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int encodeUTF8(char[] cArr, int i2, int i3, byte[] bArr) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{cArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr})) == null) {
            int i6 = i2 + i3;
            int i7 = 0;
            int min = Math.min(i3, bArr.length) + 0;
            while (i7 < min && cArr[i2] < 128) {
                bArr[i7] = (byte) cArr[i2];
                i7++;
                i2++;
            }
            while (i2 < i6) {
                int i8 = i2 + 1;
                char c2 = cArr[i2];
                if (c2 < 128) {
                    i4 = i7 + 1;
                    bArr[i7] = (byte) c2;
                } else {
                    if (c2 < 2048) {
                        int i9 = i7 + 1;
                        bArr[i7] = (byte) ((c2 >> 6) | 192);
                        i7 = i9 + 1;
                        bArr[i9] = (byte) ((c2 & 63) | 128);
                    } else if (c2 < 55296 || c2 >= 57344) {
                        int i10 = i7 + 1;
                        bArr[i7] = (byte) ((c2 >> 12) | 224);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) ((63 & (c2 >> 6)) | 128);
                        i4 = i11 + 1;
                        bArr[i11] = (byte) ((c2 & 63) | 128);
                    } else {
                        int i12 = i8 - 1;
                        if (c2 < 55296 || c2 >= 56320) {
                            if (c2 >= 56320 && c2 < 57344) {
                                i5 = i7 + 1;
                                bArr[i7] = 63;
                                i7 = i5;
                            }
                            if (c2 >= 0) {
                                i5 = i7 + 1;
                                bArr[i7] = 63;
                            } else {
                                int i13 = i7 + 1;
                                bArr[i7] = (byte) ((c2 >> 18) | 240);
                                int i14 = i13 + 1;
                                bArr[i13] = (byte) (((c2 >> 12) & 63) | 128);
                                int i15 = i14 + 1;
                                bArr[i14] = (byte) ((63 & (c2 >> 6)) | 128);
                                bArr[i15] = (byte) ((c2 & 63) | 128);
                                i8++;
                                i5 = i15 + 1;
                            }
                            i7 = i5;
                        } else {
                            if (i6 - i12 < 2) {
                                c2 = -1;
                            } else {
                                char c3 = cArr[i12 + 1];
                                if (c3 < 56320 || c3 >= 57344) {
                                    i5 = i7 + 1;
                                    bArr[i7] = 63;
                                    i7 = i5;
                                } else {
                                    c2 = ((c2 << 10) + c3) - 56613888;
                                }
                            }
                            if (c2 >= 0) {
                            }
                            i7 = i5;
                        }
                    }
                    i2 = i8;
                }
                i2 = i8;
                i7 = i4;
            }
            return i7;
        }
        return invokeCommon.intValue;
    }

    public static boolean firstIdentifier(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Character.valueOf(c2)})) == null) {
            boolean[] zArr = firstIdentifierFlags;
            return c2 < zArr.length && zArr[c2];
        }
        return invokeCommon.booleanValue;
    }

    public static void getChars(long j, int i2, char[] cArr) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2), cArr}) == null) {
            if (j < 0) {
                c2 = SignatureImpl.SEP;
                j = -j;
            } else {
                c2 = 0;
            }
            while (j > 2147483647L) {
                long j2 = j / 100;
                int i3 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
                int i4 = i2 - 1;
                cArr[i4] = DigitOnes[i3];
                i2 = i4 - 1;
                cArr[i2] = DigitTens[i3];
                j = j2;
            }
            int i5 = (int) j;
            while (i5 >= 65536) {
                int i6 = i5 / 100;
                int i7 = i5 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
                int i8 = i2 - 1;
                cArr[i8] = DigitOnes[i7];
                i2 = i8 - 1;
                cArr[i2] = DigitTens[i7];
                i5 = i6;
            }
            while (true) {
                int i9 = (52429 * i5) >>> 19;
                i2--;
                cArr[i2] = digits[i5 - ((i9 << 3) + (i9 << 1))];
                if (i9 == 0) {
                    break;
                }
                i5 = i9;
            }
            if (c2 != 0) {
                cArr[i2 - 1] = c2;
            }
        }
    }

    public static String getStringProperty(String str) {
        String str2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                str2 = System.getProperty(str);
            } catch (SecurityException unused) {
                str2 = null;
            }
            return str2 == null ? DEFAULT_PROPERTIES.getProperty(str) : str2;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isIdent(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Character.valueOf(c2)})) == null) {
            boolean[] zArr = identifierFlags;
            return c2 < zArr.length && zArr[c2];
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isValidJsonpQueryParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return false;
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '.' && !isIdent(charAt)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void loadPropertiesFromFile() {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, null) == null) || (inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader != null) {
                        return contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
                    }
                    return ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
                }
                return (InputStream) invokeV.objValue;
            }
        })) == null) {
            return;
        }
        try {
            DEFAULT_PROPERTIES.load(inputStream);
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static String readAll(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65553, null, reader)) != null) {
            return (String) invokeL.objValue;
        }
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception e2) {
            throw new JSONException("read string from reader error", e2);
        }
    }

    public static int stringSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            int i3 = 0;
            while (i2 > sizeTable[i3]) {
                i3++;
            }
            return i3 + 1;
        }
        return invokeI.intValue;
    }

    public static int stringSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65555, null, j)) == null) {
            long j2 = 10;
            for (int i2 = 1; i2 < 19; i2++) {
                if (j < j2) {
                    return i2;
                }
                j2 *= 10;
            }
            return 19;
        }
        return invokeJ.intValue;
    }

    public static void getChars(int i2, int i3, char[] cArr) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65547, null, i2, i3, cArr) == null) {
            if (i2 < 0) {
                c2 = SignatureImpl.SEP;
                i2 = -i2;
            } else {
                c2 = 0;
            }
            while (i2 >= 65536) {
                int i4 = i2 / 100;
                int i5 = i2 - (((i4 << 6) + (i4 << 5)) + (i4 << 2));
                int i6 = i3 - 1;
                cArr[i6] = DigitOnes[i5];
                i3 = i6 - 1;
                cArr[i3] = DigitTens[i5];
                i2 = i4;
            }
            while (true) {
                int i7 = (52429 * i2) >>> 19;
                i3--;
                cArr[i3] = digits[i2 - ((i7 << 3) + (i7 << 1))];
                if (i7 == 0) {
                    break;
                }
                i2 = i7;
            }
            if (c2 != 0) {
                cArr[i3 - 1] = c2;
            }
        }
    }

    public static byte[] decodeBase64(String str, int i2, int i3) {
        InterceptResult invokeLII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, str, i2, i3)) == null) {
            int i5 = 0;
            if (i3 == 0) {
                return new byte[0];
            }
            int i6 = (i2 + i3) - 1;
            while (i2 < i6 && IA[str.charAt(i2)] < 0) {
                i2++;
            }
            while (i6 > 0 && IA[str.charAt(i6)] < 0) {
                i6--;
            }
            int i7 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
            int i8 = (i6 - i2) + 1;
            if (i3 > 76) {
                i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
            } else {
                i4 = 0;
            }
            int i9 = (((i8 - i4) * 6) >> 3) - i7;
            byte[] bArr = new byte[i9];
            int i10 = (i9 / 3) * 3;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i2 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i15 + 1;
                int i17 = (IA[str.charAt(i2)] << 18) | (IA[str.charAt(i13)] << 12) | (IA[str.charAt(i14)] << 6) | IA[str.charAt(i15)];
                int i18 = i11 + 1;
                bArr[i11] = (byte) (i17 >> 16);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (i17 >> 8);
                int i20 = i19 + 1;
                bArr[i19] = (byte) i17;
                if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                    i2 = i16;
                } else {
                    i2 = i16 + 2;
                    i12 = 0;
                }
                i11 = i20;
            }
            if (i11 < i9) {
                int i21 = 0;
                while (i2 <= i6 - i7) {
                    i5 |= IA[str.charAt(i2)] << (18 - (i21 * 6));
                    i21++;
                    i2++;
                }
                int i22 = 16;
                while (i11 < i9) {
                    bArr[i11] = (byte) (i5 >> i22);
                    i22 -= 8;
                    i11++;
                }
            }
            return bArr;
        }
        return (byte[]) invokeLII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x000b */
    public static void getChars(byte b2, int i2, char[] cArr) {
        char c2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2), cArr}) == null) {
            if (b2 < 0) {
                c2 = SignatureImpl.SEP;
                i3 = -b2;
            } else {
                c2 = 0;
                i3 = b2;
            }
            while (true) {
                int i4 = (52429 * i3) >>> 19;
                i2--;
                cArr[i2] = digits[i3 - ((i4 << 3) + (i4 << 1))];
                if (i4 == 0) {
                    break;
                }
                i3 = i4;
            }
            if (c2 != 0) {
                cArr[i2 - 1] = c2;
            }
        }
    }

    public static byte[] decodeBase64(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            int length = str.length();
            int i3 = 0;
            if (length == 0) {
                return new byte[0];
            }
            int i4 = length - 1;
            int i5 = 0;
            while (i5 < i4 && IA[str.charAt(i5) & 255] < 0) {
                i5++;
            }
            while (i4 > 0 && IA[str.charAt(i4) & 255] < 0) {
                i4--;
            }
            int i6 = str.charAt(i4) == '=' ? str.charAt(i4 + (-1)) == '=' ? 2 : 1 : 0;
            int i7 = (i4 - i5) + 1;
            if (length > 76) {
                i2 = (str.charAt(76) == '\r' ? i7 / 78 : 0) << 1;
            } else {
                i2 = 0;
            }
            int i8 = (((i7 - i2) * 6) >> 3) - i6;
            byte[] bArr = new byte[i8];
            int i9 = (i8 / 3) * 3;
            int i10 = 0;
            int i11 = 0;
            while (i10 < i9) {
                int i12 = i5 + 1;
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = (IA[str.charAt(i5)] << 18) | (IA[str.charAt(i12)] << 12) | (IA[str.charAt(i13)] << 6) | IA[str.charAt(i14)];
                int i17 = i10 + 1;
                bArr[i10] = (byte) (i16 >> 16);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (i16 >> 8);
                int i19 = i18 + 1;
                bArr[i18] = (byte) i16;
                if (i2 <= 0 || (i11 = i11 + 1) != 19) {
                    i5 = i15;
                } else {
                    i5 = i15 + 2;
                    i11 = 0;
                }
                i10 = i19;
            }
            if (i10 < i8) {
                int i20 = 0;
                while (i5 <= i4 - i6) {
                    i3 |= IA[str.charAt(i5)] << (18 - (i20 * 6));
                    i20++;
                    i5++;
                }
                int i21 = 16;
                while (i10 < i8) {
                    bArr[i10] = (byte) (i3 >> i21);
                    i21 -= 8;
                    i10++;
                }
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
