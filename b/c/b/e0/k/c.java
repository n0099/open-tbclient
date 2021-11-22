package b.c.b.e0.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f31194a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f31195b;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f31196c;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f31197d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999949614, "Lb/c/b/e0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999949614, "Lb/c/b/e0/k/c;");
                return;
            }
        }
        f31194a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f31195b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f31196c = new String[64];
        f31197d = new String[256];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f31197d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = b.c.b.e0.e.q("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f31196c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            f31196c[i5 | 8] = f31196c[i5] + "|PADDED";
        }
        String[] strArr3 = f31196c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr4 = f31196c;
                int i10 = i9 | i7;
                strArr4[i10] = f31196c[i9] + '|' + f31196c[i7];
                f31196c[i10 | 8] = f31196c[i9] + '|' + f31196c[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr5 = f31196c;
            if (i2 >= strArr5.length) {
                return;
            }
            if (strArr5[i2] == null) {
                strArr5[i2] = f31197d[i2];
            }
            i2++;
        }
    }

    public c() {
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

    public static String a(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (b3 == 0) {
                return "";
            }
            if (b2 != 2 && b2 != 3) {
                if (b2 == 4 || b2 == 6) {
                    return b3 == 1 ? "ACK" : f31197d[b3];
                } else if (b2 != 7 && b2 != 8) {
                    String[] strArr = f31196c;
                    String str = b3 < strArr.length ? strArr[b3] : f31197d[b3];
                    if (b2 != 5 || (b3 & 4) == 0) {
                        return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                    }
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f31197d[b3];
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(boolean z, int i2, int i3, byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            String[] strArr = f31195b;
            String q = b2 < strArr.length ? strArr[b2] : b.c.b.e0.e.q("0x%02x", Byte.valueOf(b2));
            String a2 = a(b2, b3);
            Object[] objArr = new Object[5];
            objArr[0] = z ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = q;
            objArr[4] = a2;
            return b.c.b.e0.e.q("%s 0x%08x %5d %-13s %s", objArr);
        }
        return (String) invokeCommon.objValue;
    }

    public static IllegalArgumentException c(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr)) == null) {
            throw new IllegalArgumentException(b.c.b.e0.e.q(str, objArr));
        }
        return (IllegalArgumentException) invokeLL.objValue;
    }

    public static IOException d(String str, Object... objArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, objArr)) == null) {
            throw new IOException(b.c.b.e0.e.q(str, objArr));
        }
        return (IOException) invokeLL.objValue;
    }
}
