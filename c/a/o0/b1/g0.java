package c.a.o0.b1;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Date;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f12595a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f12596b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(477231674, "Lc/a/o0/b1/g0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(477231674, "Lc/a/o0/b1/g0;");
                return;
            }
        }
        f12595a = Pattern.compile("http[s]?://tieba\\.baidu\\.com/f(.*)&jump_tieba_native=1(.*)");
        f12596b = Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1");
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c.a.o0.b.d.Z()) {
                Date date = new Date(c.a.o0.s.d0.b.j().l("show_login_dialog_strategy_key", 0L));
                long currentTimeMillis = System.currentTimeMillis();
                Date date2 = new Date(currentTimeMillis);
                c.a.o0.s.d0.b.j().w("show_login_dialog_strategy_key", currentTimeMillis);
                return !TimeHelper.isSameDay(date, date2);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (c.a.e.e.p.k.isEmpty(str)) {
                return false;
            }
            return f12595a.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (c.a.e.e.p.k.isEmpty(str)) {
                return false;
            }
            return f12596b.matcher(str.toLowerCase()).find();
        }
        return invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (c.a.e.e.p.k.isEmpty(str)) {
                return false;
            }
            return "person".equalsIgnoreCase(Uri.parse(str).getAuthority());
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? b(str) || c(str) || d(str) : invokeL.booleanValue;
    }
}
