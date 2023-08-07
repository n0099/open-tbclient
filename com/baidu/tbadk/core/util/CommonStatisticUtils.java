package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CommonStatisticUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOCATE_FRS_LIST = 5;
    public static final int LOCATE_HOMEPAGE_CON_TAB = 1;
    public static final int LOCATE_HOMEPAGE_REC_TAB = 2;
    public static final int LOCATE_PB_BOT_ACTIVE = 1;
    public static final int LOCATE_PB_BOT_BOTTOM = 4;
    public static final int LOCATE_PB_BOT_FIRST_FLOOR = 2;
    public static final int LOCATE_PB_BOT_PANEL = 3;
    public static final int LOCATE_PB_FIRST_FLOOR = 3;
    public static final int LOCATE_PB_REPLY = 4;
    public static final int LOCATE_PERSONAL_PAGE = 6;
    public static final int LOCATE_VIDEO_IMMERSE = 7;
    public static final int PB_BOT_COOLING_STATE = 2;
    public static final int PB_BOT_NORMAL_STATE = 1;
    public static final int TYPE_CLICK = 2;
    public static final int TYPE_LONG_CLICK = 3;
    public static final int TYPE_SHOW = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonStatisticUtils() {
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

    public static void setBotId(String str, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, statisticItem) == null) && !TextUtils.isEmpty(str)) {
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(str);
            if (!TextUtils.isEmpty(bdUidFromBdUK)) {
                statisticItem.param("obj_id", bdUidFromBdUK);
            }
        }
    }

    public static void staticUrlNullReport(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_URL_NULL_REPORT);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void staticNameplateOfUserLevel(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65538, null, i, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NAMEPLATE_OF_USER_LEVEL_STATIC);
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", i3);
            statisticItem.eventStat();
        }
    }

    public static void staticTbMemberNotify(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        if (!StringUtils.isNull(str2)) {
            statisticItem.param("obj_id", str2);
        }
        if (!StringUtils.isNull(str3)) {
            statisticItem.param("obj_name", str3);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.eventStat();
    }

    public static void statisticBotSkillMenu(int i, @NonNull String str, int i2, boolean z, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2, str3, str4}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRIEND_BOT_SKILL_MENU_SHOW);
            setBotId(str, statisticItem);
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("fid", str2);
            statisticItem.param("tid", str4);
            if (z) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            statisticItem.param("obj_param1", i3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str3);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void statisticFriendBotView(int i, @NonNull String str, int i2, boolean z, @NonNull String str2, @NonNull String str3) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2, str3}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRIEND_BOT_BUTTON_VIEW_SHOW);
            setBotId(str, statisticItem);
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("fid", str2);
            statisticItem.param("tid", str3);
            if (z) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            statisticItem.param("obj_param1", i3);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }
}
