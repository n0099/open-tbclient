package b.a.r0.d2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public static void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, obj) == null) && (obj instanceof MarkData)) {
            MarkData markData = (MarkData) obj;
            if (StringUtils.isNull(str)) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", markData.getId());
            statisticItem.param("fname", markData.getForumName());
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1413831834:
                    if (str.equals("c14062")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1413831833:
                    if (str.equals("c14063")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1413831832:
                    if (str.equals("c14064")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1413831831:
                    if (str.equals("c14065")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1413831828:
                    if (str.equals("c14068")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1413831827:
                    if (str.equals("c14069")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                d(markData, statisticItem);
            } else if (c2 == 1) {
                d(markData, statisticItem);
                statisticItem.param("obj_id", markData.getUesrId());
            } else if (c2 == 2 || c2 == 3) {
                statisticItem.param("obj_id", markData.getUesrId());
            } else if (c2 == 4) {
                d(markData, statisticItem);
                statisticItem.param("obj_source", "1");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(String str, boolean z, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Boolean.valueOf(z), markData}) == null) || markData == null || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", markData.getId());
        statisticItem.param("fname", markData.getForumName());
        if (z) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, "1");
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, "2");
        }
        TiebaStatic.log(statisticItem);
    }

    public static void d(MarkData markData, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, markData, statisticItem) == null) {
            if (markData.is_deleted()) {
                statisticItem.param("obj_param1", "3");
            } else if (markData.isRedTipShow() && !StringUtils.isNull(markData.getmState()) && markData.getNewCounts() > 0) {
                statisticItem.param("obj_param1", "1");
            } else {
                statisticItem.param("obj_param1", "2");
            }
        }
    }
}
