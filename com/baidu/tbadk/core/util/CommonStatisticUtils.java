package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public static final int LOCATE_PB_FIRST_FLOOR = 3;
    public static final int LOCATE_PB_REPLY = 4;
    public static final int LOCATE_PERSONAL_PAGE = 6;
    public static final int LOCATE_VIDEO_IMMERSE = 7;
    public static final int TYPE_CLICK = 2;
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

    public static void staticNameplateOfUserLevel(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65537, null, i, i2, i3) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_NAMEPLATE_OF_USER_LEVEL_STATIC);
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", i3);
            statisticItem.eventStat();
        }
    }

    public static void staticTbMemberNotify(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, str, str2, str3) != null) || StringUtils.isNull(str)) {
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

    public static void staticUrlNullReport(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_URL_NULL_REPORT);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_locate", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void statisticFriendBotView(@NonNull int i, @NonNull String str, @NonNull int i2, boolean z, @NonNull String str2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRIEND_BOT_BUTTON_VIEW_SHOW);
            if (!TextUtils.isEmpty(str)) {
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(str);
                if (!TextUtils.isEmpty(bdUidFromBdUK)) {
                    statisticItem.param("obj_id", bdUidFromBdUK);
                }
            }
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("fid", str2);
            if (z) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            statisticItem.param("obj_param1", i3);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }
}
