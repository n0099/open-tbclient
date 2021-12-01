package c.a.d.f.q;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f2673b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f2674c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502459221, "Lc/a/d/f/q/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502459221, "Lc/a/d/f/q/h;");
                return;
            }
        }
        f2674c = new String[]{"meizu"};
    }

    public static String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            return app == null ? "" : app.getString(i2);
        }
        return (String) invokeI.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return invokeV.booleanValue;
        }
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int i2 = 0;
        while (true) {
            String[] strArr = f2674c;
            if (i2 >= strArr.length) {
                return false;
            }
            if (strArr[i2].equals(lowerCase)) {
                return true;
            }
            i2++;
        }
    }
}
