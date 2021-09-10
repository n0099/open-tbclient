package c.a.q0.g1.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13462a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1658655550, "Lc/a/q0/g1/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1658655550, "Lc/a/q0/g1/b/e;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c.a.q0.s.d0.b.j().C("key_youngster_verify");
        }
    }

    public static String b(c.a.q0.g1.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar == null || StringUtils.isNull(aVar.c()) || StringUtils.isNull(aVar.b()) || StringUtils.isNull(aVar.a())) {
                return "";
            }
            return aVar.c() + "," + aVar.b() + "," + aVar.a();
        }
        return (String) invokeL.objValue;
    }

    public static c.a.q0.g1.a.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String[] split = str.split(",");
            if (split.length > 2) {
                return new c.a.q0.g1.a.a(split[0], split[1], split[2]);
            }
            return null;
        }
        return (c.a.q0.g1.a.a) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String p = c.a.q0.s.d0.b.j().p("key_youngster_verify", "");
            if (StringUtils.isNull(p)) {
                a();
                return false;
            }
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo == null) {
                a();
                return false;
            }
            c.a.q0.g1.a.a c2 = c(p);
            if (c2 == null || StringUtils.isNull(c2.c()) || !c2.c().equals(currentAccountInfo.getID()) || StringUtils.isNull(c2.b()) || !c2.b().equals(currentAccountInfo.getPortrait())) {
                a();
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String p = c.a.q0.s.d0.b.j().p("key_youngster_verify", "");
            if (StringUtils.isNull(p)) {
                a();
                return false;
            }
            c.a.q0.g1.a.a c2 = c(p);
            if (c2 == null) {
                return false;
            }
            return str.equals(c2.a());
        }
        return invokeL.booleanValue;
    }

    public static void f(String str) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str) || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        c.a.q0.s.d0.b.j().x("key_youngster_verify", b(new c.a.q0.g1.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
    }

    public static void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                activity = TbadkApplication.getInst().getCurrentActivity();
            }
            if (activity == null || activity.isDestroyed()) {
                return;
            }
            new BdTopToast(activity).setIcon(false).setContent(activity.getString(R.string.youngster_reject_toast)).show((ViewGroup) activity.findViewById(16908290));
        }
    }
}
