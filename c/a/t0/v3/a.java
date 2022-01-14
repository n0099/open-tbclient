package c.a.t0.v3;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.e2;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(989325471, "Lc/a/t0/v3/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(989325471, "Lc/a/t0/v3/a;");
                return;
            }
        }
        a = Arrays.asList("a006", "a005", "a008", "a002");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "enterfourm_att_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return "enterfourm_rec_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, baijiahaoData)) == null) {
            String str4 = "_tid_" + str;
            if (!TextUtils.isEmpty(str2)) {
                str4 = str4 + "_adid_" + str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                str4 = str4 + "_appid_" + str3;
            }
            if (baijiahaoData != null) {
                return str4 + "_nid_" + baijiahaoData.oriUgcNid;
            }
            return str4;
        }
        return (String) invokeLLLL.objValue;
    }

    public static StatisticItem d(e2 e2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str3, str4})) == null) ? q(true, e2Var, str, str2, i2, i3, z, str3, str4, false, "", 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem e(e2 e2Var, String str, String str2, int i2, int i3, boolean z, String str3, String str4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str3, str4, Integer.valueOf(i4)})) == null) {
            if (e2Var == null) {
                return null;
            }
            return q(true, e2Var, str, str2, i2, i3, z, str3, str4, false, "", i4);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem f(e2 e2Var, String str, String str2, int i2, boolean z, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), Boolean.valueOf(z), str3, str4})) == null) ? q(false, e2Var, str, str2, -1, i2, z, str3, str4, false, "", 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem g(e2 e2Var, String str, String str2, int i2, boolean z, String str3, String str4, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), Boolean.valueOf(z), str3, str4, Integer.valueOf(i3)})) == null) {
            if (e2Var == null) {
                return null;
            }
            return q(false, e2Var, str, str2, -1, i2, z, str3, str4, false, "", i3);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem h(String str, String str2, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? i(str, str2, z, i2, 0) : (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem i(String str, String str2, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("page_type", str).param("ad_exp", z ? 1 : 0).param("ad_exp_cnt", i2).param(TiebaStatic.Params.OBJ_FLOOR, 0).param(TiebaStatic.Params.OBJ_AD_LOCATE, i3);
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem j(e2 e2Var, String str, String str2, int i2, int i3, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3})) == null) {
            if (e2Var == null) {
                return null;
            }
            return q(true, e2Var, str, str2, i2, i3, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem k(e2 e2Var, String str, String str2, int i2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{e2Var, str, str2, Integer.valueOf(i2), str3})) == null) {
            if (e2Var == null) {
                return null;
            }
            return q(false, e2Var, str, str2, -1, i2, false, "", null, true, str3, 0);
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem l(boolean z, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), str3, str4, Integer.valueOf(i4)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            StatisticItem param = statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0);
            if (!z2) {
                str3 = str4;
            }
            param.param("obj_id", str3).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4);
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
            }
            if (z) {
                statisticItem.param("obj_locate", i2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static StatisticItem m(String str, e2 e2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, e2Var)) == null) ? o(str, e2Var, 0, 0) : (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem n(String str, e2 e2Var, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, str, e2Var, i2)) == null) ? o(str, e2Var, i2, 0) : (StatisticItem) invokeLLI.objValue;
    }

    public static StatisticItem o(String str, e2 e2Var, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65551, null, str, e2Var, i2, i3)) == null) {
            if (e2Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", e2Var.v1()).param("fid", e2Var.U()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", e2Var.M2() ? 1 : 0);
            if (i2 != 0) {
                statisticItem.param("obj_locate", i2);
            }
            if (i3 != 0) {
                statisticItem.param("obj_type", i3);
            }
            if (str == "c13696" && e2Var.J() != null) {
                statisticItem.param(TiebaStatic.Params.IS_FOLLOW, e2Var.J().getIsLike() ? 1 : 0);
            }
            if (BdLog.isDebugMode()) {
                statisticItem.toString();
            }
            return statisticItem;
        }
        return (StatisticItem) invokeLLII.objValue;
    }

    public static String p(boolean z, String str, boolean z2, String str2, String str3, BaijiahaoData baijiahaoData) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2), str2, str3, baijiahaoData})) == null) ? z ? str : z2 ? str2 : (baijiahaoData == null || TextUtils.isEmpty(baijiahaoData.oriUgcNid)) ? str3 : baijiahaoData.oriUgcNid : (String) invokeCommon.objValue;
    }

    public static StatisticItem q(boolean z, e2 e2Var, String str, String str2, int i2, int i3, boolean z2, String str3, String str4, boolean z3, String str5, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), e2Var, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), str3, str4, Boolean.valueOf(z3), str5, Integer.valueOf(i4)})) == null) {
            StatisticItem statisticItem = new StatisticItem(str2);
            statisticItem.param("page_type", str).param(TiebaStatic.Params.OBJ_FLOOR, i3).param(TiebaStatic.Params.OBJ_ISAD, z2 ? 1 : 0).param("obj_id", p(z2, str3, z3, str5, e2Var.g0(), e2Var.L())).param("tid", e2Var.v1()).param("thread_type", z2 ? -1 : e2Var.r1()).param(TiebaStatic.Params.OBJ_AD_LOCATE, i4).param("nid", e2Var.G0());
            if (!m.isEmpty(e2Var.S0())) {
                statisticItem.param("list_strategy", e2Var.S0());
            }
            if (str != null && a.contains(str) && TbadkCoreApplication.getInst().getAdAdSense() != null && !StringUtils.isNull(TbadkCoreApplication.getInst().getAdAdSense().q)) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().q);
            } else if (!m.isEmpty(e2Var.b1)) {
                statisticItem.param("ab_tag", e2Var.b1);
            }
            if (z) {
                statisticItem.param("obj_locate", i2);
            }
            if (e2Var.U() > 0) {
                statisticItem.param("fid", e2Var.U());
            }
            if (!StringUtils.isNull(e2Var.V())) {
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, e2Var.V());
            }
            if (!StringUtils.isNull(e2Var.a1())) {
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, e2Var.a1());
            }
            if (e2Var.L() != null) {
                statisticItem.param(TiebaStatic.Params.UGC_VID, e2Var.L().oriUgcVid);
                statisticItem.param(TiebaStatic.Params.UGC_NID, e2Var.L().oriUgcNid);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("pid", str4);
            }
            statisticItem.param(TiebaStatic.Params.IS_ZP, e2Var.M2() ? 1 : 0);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }
}
