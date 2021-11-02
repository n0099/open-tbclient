package b.a.r0.h1.h.n;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.b.d;
import b.a.q0.s.e0.b;
import b.a.q0.t.c.y;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i2) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_CLICK).param("uid", currentAccount).param("obj_param1", b.j().k(sb.toString(), 0) != 0 ? 2 : 1).param("obj_locate", i2));
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            StringBuilder sb = new StringBuilder();
            sb.append("key_card_interest_close_click_num_");
            sb.append(currentAccount);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_HOME_RECOMMEND_CARD_INTEREST_SHOW).param("uid", currentAccount).param("obj_param1", b.j().k(sb.toString(), 0) != 0 ? 2 : 1));
        }
    }

    public static boolean c(y yVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, yVar, str)) == null) {
            long l = b.j().l("key_card_interest_close_click_time_" + str, 0L);
            if (l != 0) {
                return yVar.a() != -1 && ((int) (((((System.currentTimeMillis() - l) / 1000) / 60) / 60) / 24)) >= yVar.a();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean d(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yVar)) == null) ? yVar.c() == 1 : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d.O() && h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                y homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                if (d(homepageInterestConfig)) {
                    return true;
                }
                if (b.j().k("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
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
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            if (h()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                y homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig != null && i3 > 0) {
                    if (d(homepageInterestConfig)) {
                        return true;
                    }
                    if (b.j().k("key_card_interest_close_click_num_" + currentAccount, 0) != 0) {
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

    public static boolean g(y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, yVar)) == null) ? yVar.d() == 1 : invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (TbadkCoreApplication.isLogin()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                y homepageInterestConfig = TbSingleton.getInstance().getHomepageInterestConfig();
                if (homepageInterestConfig == null) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("key_card_interest_close_click_num_");
                sb.append(currentAccount);
                return b.j().k(sb.toString(), 0) < homepageInterestConfig.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            b.j().w("key_card_interest_close_click_time_" + currentAccount, System.currentTimeMillis());
            String str = "key_card_interest_close_click_num_" + currentAccount;
            b.j().v(str, b.j().k(str, 0) + 1);
        }
    }
}
