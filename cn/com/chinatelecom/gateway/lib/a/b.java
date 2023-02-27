package cn.com.chinatelecom.gateway.lib.a;

import androidx.exifinterface.media.ExifInterface;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.common.internal.TransactionIdCreater;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "b";
    public static char[] b;
    public static byte[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293575003, "Lcn/com/chinatelecom/gateway/lib/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293575003, "Lcn/com/chinatelecom/gateway/lib/a/b;");
                return;
            }
        }
        b = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        c = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public b() {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                int i3 = bArr[i] & 255;
                if (i2 == length) {
                    stringBuffer.append(b[i3 >>> 2]);
                    stringBuffer.append(b[(i3 & 3) << 4]);
                    str = "==";
                } else {
                    int i4 = i2 + 1;
                    int i5 = bArr[i2] & 255;
                    if (i4 == length) {
                        stringBuffer.append(b[i3 >>> 2]);
                        stringBuffer.append(b[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                        stringBuffer.append(b[(i5 & 15) << 2]);
                        str = "=";
                    } else {
                        int i6 = i4 + 1;
                        int i7 = bArr[i4] & 255;
                        stringBuffer.append(b[i3 >>> 2]);
                        stringBuffer.append(b[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                        stringBuffer.append(b[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
                        stringBuffer.append(b[i7 & 63]);
                        i = i6;
                    }
                }
                stringBuffer.append(str);
                break;
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                byte[] bytes = str.getBytes("US-ASCII");
                int length = bytes.length;
                int i5 = 0;
                while (i5 < length) {
                    while (true) {
                        i = i5 + 1;
                        b2 = c[bytes[i5]];
                        if (i >= length || b2 != -1) {
                            break;
                        }
                        i5 = i;
                    }
                    if (b2 == -1) {
                        break;
                    }
                    while (true) {
                        i2 = i + 1;
                        b3 = c[bytes[i]];
                        if (i2 >= length || b3 != -1) {
                            break;
                        }
                        i = i2;
                    }
                    if (b3 == -1) {
                        break;
                    }
                    stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                    while (true) {
                        i3 = i2 + 1;
                        byte b6 = bytes[i2];
                        if (b6 != 61) {
                            b4 = c[b6];
                            if (i3 >= length || b4 != -1) {
                                break;
                            }
                            i2 = i3;
                        } else {
                            return stringBuffer.toString().getBytes("iso8859-1");
                        }
                    }
                    if (b4 == -1) {
                        break;
                    }
                    stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                    while (true) {
                        i4 = i3 + 1;
                        byte b7 = bytes[i3];
                        if (b7 != 61) {
                            b5 = c[b7];
                            if (i4 >= length || b5 != -1) {
                                break;
                            }
                            i3 = i4;
                        } else {
                            return stringBuffer.toString().getBytes("iso8859-1");
                        }
                    }
                    if (b5 == -1) {
                        break;
                    }
                    stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
                    i5 = i4;
                }
                return stringBuffer.toString().getBytes("iso8859-1");
            } catch (Throwable th) {
                CtAuth.warn(a, "When decode() ,throws exception", th);
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
