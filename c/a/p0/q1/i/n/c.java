package c.a.p0.q1.i.n;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.c.x;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_CLICK).param("uid", currentAccount).param("obj_param1", c.a.o0.r.j0.b.k().l(sb.toString(), 0) != 0 ? 2 : 1).param("obj_locate", i));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_SHOW).param("uid", currentAccount).param("obj_param1", c.a.o0.r.j0.b.k().l(sb.toString(), 0) != 0 ? 2 : 1));
        }
    }

    public static boolean c(x xVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, xVar, str)) == null) {
            long m = c.a.o0.r.j0.b.k().m("key_card_interest_close_click_time_" + str, 0L);
            if (m != 0) {
                return xVar.a() != -1 && ((int) (((((System.currentTimeMillis() - m) / 1000) / 60) / 60) / 24)) >= xVar.a();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xVar)) == null) ? xVar.c() == 1 : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (UbsABTestHelper.isRecommendCardInterestABTestA() && h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                x homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                if (d(homepageInterestConfig)) {
                    return true;
                }
                if (c.a.o0.r.j0.b.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
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

    public static boolean f(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) {
            if (h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                x homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig != null && i2 > 0) {
                    if (d(homepageInterestConfig)) {
                        return true;
                    }
                    if (c.a.o0.r.j0.b.k().l("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
                        if (c(homepageInterestConfig, currentAccount) && i == 0) {
                            return true;
                        }
                    } else if (g(homepageInterestConfig) && i == 0) {
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

    public static boolean g(x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, xVar)) == null) ? xVar.d() == 1 : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                x homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("key_card_interest_close_click_num_");
                sb.append(currentAccount);
                return c.a.o0.r.j0.b.k().l(sb.toString(), 0) < homepageInterestConfig.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            c.a.o0.r.j0.b.k().x("key_card_interest_close_click_time_" + currentAccount, System.currentTimeMillis());
            String str = "key_card_interest_close_click_num_" + currentAccount;
            c.a.o0.r.j0.b.k().w(str, c.a.o0.r.j0.b.k().l(str, 0) + 1);
        }
    }
}
