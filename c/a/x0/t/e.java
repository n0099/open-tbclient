package c.a.x0.t;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat f31228a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(395278018, "Lc/a/x0/t/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(395278018, "Lc/a/x0/t/e;");
                return;
            }
        }
        f31228a = new DecimalFormat("0.00");
    }

    public static String a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            return f31228a.format(((float) j2) / 1048576.0f) + "M/" + f31228a.format(((float) j3) / 1048576.0f) + "M";
        }
        return (String) invokeCommon.objValue;
    }

    public static int b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                String hexString = Integer.toHexString((int) (Float.parseFloat(str2) * 255.0f));
                return Color.parseColor("#" + hexString + str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }
}
