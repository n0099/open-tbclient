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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35506a = "e";

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f35507b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293574910, "Lcn/com/chinatelecom/gateway/lib/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293574910, "Lcn/com/chinatelecom/gateway/lib/a/e;");
                return;
            }
        }
        f35507b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public e() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(f35507b[(bArr[i2] >> 4) & 15]);
                sb.append(f35507b[bArr[i2] & 15]);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            char[] charArray = str.toCharArray();
            int length = charArray.length / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int digit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
                if (digit > 127) {
                    digit -= 256;
                }
                bArr[i2] = (byte) digit;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            byte[] bArr = new byte[0];
            try {
                return str.getBytes("UTF-8");
            } catch (Throwable th) {
                CtAuth.warn(f35506a, "getBytes error", th);
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
