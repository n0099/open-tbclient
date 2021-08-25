package cn.com.chinatelecom.gateway.lib.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f35508a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f35509b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f35510c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1293574879, "Lcn/com/chinatelecom/gateway/lib/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1293574879, "Lcn/com/chinatelecom/gateway/lib/a/f;");
                return;
            }
        }
        f35509b = new byte[]{68, 64, 94, 49, 69, Base64.INTERNAL_PADDING, 50, 83};
        f35510c = Charset.forName("UTF-8");
    }

    public f() {
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
            try {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    bArr2[i2] = bArr[i2];
                    for (byte b2 : f35509b) {
                        bArr2[i2] = (byte) (b2 ^ bArr2[i2]);
                    }
                }
                return new String(bArr2);
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
