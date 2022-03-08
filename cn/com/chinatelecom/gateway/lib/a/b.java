package cn.com.chinatelecom.gateway.lib.a;

import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
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
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static char[] f29213b;

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f29214c;
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
        f29213b = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', WebvttCueParser.CHAR_SLASH};
        f29214c = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    }

    public b() {
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

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                int i4 = bArr[i2] & 255;
                if (i3 == length) {
                    stringBuffer.append(f29213b[i4 >>> 2]);
                    stringBuffer.append(f29213b[(i4 & 3) << 4]);
                    str = "==";
                } else {
                    int i5 = i3 + 1;
                    int i6 = bArr[i3] & 255;
                    if (i5 == length) {
                        stringBuffer.append(f29213b[i4 >>> 2]);
                        stringBuffer.append(f29213b[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                        stringBuffer.append(f29213b[(i6 & 15) << 2]);
                        str = "=";
                    } else {
                        int i7 = i5 + 1;
                        int i8 = bArr[i5] & 255;
                        stringBuffer.append(f29213b[i4 >>> 2]);
                        stringBuffer.append(f29213b[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                        stringBuffer.append(f29213b[((i6 & 15) << 2) | ((i8 & 192) >>> 6)]);
                        stringBuffer.append(f29213b[i8 & 63]);
                        i2 = i7;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return b(str);
            } catch (Throwable th) {
                CtAuth.warn(a, "When decode() ,throws exception", th);
                return new byte[0];
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bytes = str.getBytes("US-ASCII");
            int length = bytes.length;
            int i6 = 0;
            loop0: while (i6 < length) {
                while (true) {
                    i2 = i6 + 1;
                    b2 = f29214c[bytes[i6]];
                    if (i2 >= length || b2 != -1) {
                        break;
                    }
                    i6 = i2;
                }
                if (b2 == -1) {
                    break;
                }
                while (true) {
                    i3 = i2 + 1;
                    b3 = f29214c[bytes[i2]];
                    if (i3 >= length || b3 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                if (b3 == -1) {
                    break;
                }
                stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                while (true) {
                    i4 = i3 + 1;
                    byte b6 = bytes[i3];
                    if (b6 == 61) {
                        break loop0;
                    }
                    b4 = f29214c[b6];
                    if (i4 >= length || b4 != -1) {
                        break;
                    }
                    i3 = i4;
                }
                if (b4 == -1) {
                    break;
                }
                stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                while (true) {
                    i5 = i4 + 1;
                    byte b7 = bytes[i4];
                    if (b7 == 61) {
                        break loop0;
                    }
                    b5 = f29214c[b7];
                    if (i5 >= length || b5 != -1) {
                        break;
                    }
                    i4 = i5;
                }
                if (b5 == -1) {
                    break;
                }
                stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
                i6 = i5;
            }
            return stringBuffer.toString().getBytes("iso8859-1");
        }
        return (byte[]) invokeL.objValue;
    }
}
