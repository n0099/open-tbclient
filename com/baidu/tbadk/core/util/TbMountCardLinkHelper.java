package com.baidu.tbadk.core.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TbMountCardLinkHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLICK_LOCATE_ARROW_BTN = "5";
    public static final String CLICK_LOCATE_DEL_BTN = "4";
    public static final String CLICK_LOCATE_LEFT_ICON = "2";
    public static final String CLICK_LOCATE_MAIN = "1";
    public static final String CLICK_LOCATE_TEXT_BTN = "3";
    public transient /* synthetic */ FieldHolder $fh;

    public TbMountCardLinkHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void tbCardLinkClickStatistic(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TB_MOUNT_CARD_LINK_CLICK);
            statisticItem.param("obj_type", str).addParam("obj_locate", str3).addParam("obj_source", str2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void tbCardLinkShowStatistic(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TB_MOUNT_CARD_LINK_SHOW);
            statisticItem.param("obj_type", str).addParam("obj_source", str2);
            TiebaStatic.log(statisticItem);
        }
    }
}
