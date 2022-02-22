package c.a.u0.p1.i.n;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.b.d;
import c.a.t0.t.c.z;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_CLICK).param("uid", currentAccount).param("obj_param1", c.a.t0.s.j0.b.k().l(sb.toString(), 0) != 0 ? 2 : 1).param("obj_locate", i2));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_SHOW).param("uid", currentAccount).param("obj_param1", c.a.t0.s.j0.b.k().l(sb.toString(), 0) != 0 ? 2 : 1));
        }
    }

    public static boolean c(z zVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, zVar, str)) == null) {
            long m = c.a.t0.s.j0.b.k().m("key_card_interest_close_click_time_" + str, 0L);
            if (m != 0) {
                return zVar.a() != -1 && ((int) (((((System.currentTimeMillis() - m) / 1000) / 60) / 60) / 24)) >= zVar.a();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, zVar)) == null) ? zVar.c() == 1 : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d.g0() && h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                if (d(homepageInterestConfig)) {
                    return true;
                }
                if (c.a.t0.s.j0.b.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                    if (c(homepageInterestConfig, currentAccount)) {
                        return true;
                    }
                } else if (g(homepageInterestConfig)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i2, i3)) == null) {
            if (h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig != null && i3 > 0) {
                    if (d(homepageInterestConfig)) {
                        return true;
                    }
                    if (c.a.t0.s.j0.b.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                        if (c(homepageInterestConfig, currentAccount) && i2 == 0) {
                            return true;
                        }
                    } else if (g(homepageInterestConfig) && i2 == 0) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static boolean g(z zVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, zVar)) == null) ? zVar.d() == 1 : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("key_card_interest_close_click_num_");
                sb.append(currentAccount);
                return c.a.t0.s.j0.b.k().l(sb.toString(), 0) < homepageInterestConfig.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.t0.s.j0.b.k().x("key_card_interest_close_click_time_" + currentAccount, System.currentTimeMillis());
            String str = "key_card_interest_close_click_num_" + currentAccount;
            c.a.t0.s.j0.b.k().w(str, c.a.t0.s.j0.b.k().l(str, 0) + 1);
        }
    }
}
