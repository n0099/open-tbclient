package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FeedTabCardStatisticHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_BIG_PICTURE_CLICK = "c13632";
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_ENTER_FORUM_CLICK = "c13634";
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_NEG_FEEDBACK_CLICK = "c13635";
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_POTRAIT_CLICK = "c13633";
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_SHOW = "c13629";
    public static final String KEY_TAB_FEED_PICTURE_TEXT_THREAD_TITLE_CLICK = "c13631";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_ENTER_FORUM_CLICK = "c13639";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_NEG_FEEDBACK_CLICK = "c13640";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_POTRAIT_CLICK = "c13636";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_SHOW = "c13628";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_TITLE_CLICK = "c13637";
    public static final String KEY_TAB_FEED_VIDEO_THREAD_VIDEO_AREA_CLICK = "c13638";
    public static final int THREAD_BJH = 3;
    public static final int THREAD_DYNAMIC = 2;
    public static final int THREAD_NORMAL = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public FeedTabCardStatisticHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static StatisticItem clickThreadBigPictureStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_BIG_PICTURE_CLICK, d2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            baseThreadStatisticLog.param("obj_type", d2Var.d3());
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, d2Var.v2() ? 1 : 0);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadEnterForumStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (d2Var.getType() == d2.x3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_ENTER_FORUM_CLICK, d2Var, str);
                baseThreadStatisticLog.param("obj_type", 1);
                if (d2Var.L() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_ENTER_FORUM_CLICK, d2Var, str);
                baseThreadStatisticLog.param("obj_type", d2Var.d3());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadNEGFeedbackStatisticLog(x0 x0Var, String str) {
        InterceptResult invokeLL;
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, x0Var, str)) == null) {
            if (x0Var == null) {
                return null;
            }
            int i2 = x0Var.o;
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                statisticItem = new StatisticItem(KEY_TAB_FEED_PICTURE_TEXT_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            } else {
                statisticItem = new StatisticItem(KEY_TAB_FEED_VIDEO_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 2);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", x0Var.f());
            statisticItem.param("fid", x0Var.c());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str);
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadPotraitStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (d2Var.getType() == d2.x3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_POTRAIT_CLICK, d2Var, str);
                if (d2Var.L() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_POTRAIT_CLICK, d2Var, str);
                baseThreadStatisticLog.param("obj_type", d2Var.d3());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadTitleStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            if (d2Var.getType() == d2.x3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_TITLE_CLICK, d2Var, str);
                if (d2Var.L() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
                }
                if (d2Var.w1 > 0) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_TITLE_CLICK, d2Var, str);
                baseThreadStatisticLog.param("obj_type", d2Var.d3());
                baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, d2Var.v2() ? 1 : 0);
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadVideoAreaStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_VIDEO_AREA_CLICK, d2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem getBaseThreadStatisticLog(String str, d2 d2Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, d2Var, str2)) == null) {
            if (d2Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", d2Var.s1());
            statisticItem.param("fid", d2Var.T());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str2);
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static int getThreadType(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, d2Var)) == null) {
            if (d2Var.getType() == d2.l3 || d2Var.O1()) {
                return 2;
            }
            return (d2Var.M1() || d2Var.P1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    public static StatisticItem showPictureTextThreadStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_SHOW, d2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param("obj_source", d2Var.i0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            baseThreadStatisticLog.param("obj_type", d2Var.d3());
            if (d2Var.v1() != null) {
                baseThreadStatisticLog.param("obj_name", d2Var.v1().c0 ? 1 : 0);
            }
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
            }
            if (d2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, d2Var.J().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, d2Var.v2() ? 1 : 0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, d2Var.o0() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem showVideoThreadStatisticLog(d2 d2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, d2Var, str)) == null) {
            if (d2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_SHOW, d2Var, str);
            baseThreadStatisticLog.param("obj_locate", d2Var.T1);
            baseThreadStatisticLog.param("obj_source", d2Var.i0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(d2Var));
            baseThreadStatisticLog.param("obj_name", d2Var.Z0);
            if (d2Var.L() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, d2Var.L().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, d2Var.L().oriUgcVid);
            }
            if (d2Var.w1 > 0) {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            if (d2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, d2Var.J().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, d2Var.o0() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }
}
