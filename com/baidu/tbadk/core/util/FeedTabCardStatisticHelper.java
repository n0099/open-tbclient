package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
/* loaded from: classes3.dex */
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

    public static StatisticItem clickThreadBigPictureStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_BIG_PICTURE_CLICK, b2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            baseThreadStatisticLog.param("obj_type", b2Var.P2());
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, b2Var.j2() ? 1 : 0);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadEnterForumStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (b2Var.getType() == b2.r3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_ENTER_FORUM_CLICK, b2Var, str);
                baseThreadStatisticLog.param("obj_type", 1);
                if (b2Var.J() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_ENTER_FORUM_CLICK, b2Var, str);
                baseThreadStatisticLog.param("obj_type", b2Var.P2());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadNEGFeedbackStatisticLog(w0 w0Var, String str) {
        InterceptResult invokeLL;
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, w0Var, str)) == null) {
            if (w0Var == null) {
                return null;
            }
            int i2 = w0Var.n;
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                statisticItem = new StatisticItem(KEY_TAB_FEED_PICTURE_TEXT_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            } else {
                statisticItem = new StatisticItem(KEY_TAB_FEED_VIDEO_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 2);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", w0Var.e());
            statisticItem.param("fid", w0Var.c());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str);
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadPotraitStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (b2Var.getType() == b2.r3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_POTRAIT_CLICK, b2Var, str);
                if (b2Var.J() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_POTRAIT_CLICK, b2Var, str);
                baseThreadStatisticLog.param("obj_type", b2Var.P2());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadTitleStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (b2Var.getType() == b2.r3) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_TITLE_CLICK, b2Var, str);
                if (b2Var.J() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
                }
                if (b2Var.s1 > 0) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_TITLE_CLICK, b2Var, str);
                baseThreadStatisticLog.param("obj_type", b2Var.P2());
                baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, b2Var.j2() ? 1 : 0);
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadVideoAreaStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_VIDEO_AREA_CLICK, b2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem getBaseThreadStatisticLog(String str, b2 b2Var, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, b2Var, str2)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", b2Var.o1());
            statisticItem.param("fid", b2Var.R());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str2);
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static int getThreadType(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, b2Var)) == null) {
            if (b2Var.getType() == b2.f3 || b2Var.H1()) {
                return 2;
            }
            return (b2Var.F1() || b2Var.I1()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    public static StatisticItem showPictureTextThreadStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_SHOW, b2Var, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param("obj_source", b2Var.Z);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            baseThreadStatisticLog.param("obj_type", b2Var.P2());
            if (b2Var.q1() != null) {
                baseThreadStatisticLog.param("obj_name", b2Var.q1().c0 ? 1 : 0);
            }
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
            }
            if (b2Var.H() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, b2Var.H().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, b2Var.j2() ? 1 : 0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, b2Var.l0() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem showVideoThreadStatisticLog(b2 b2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, b2Var, str)) == null) {
            if (b2Var == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_SHOW, b2Var, str);
            baseThreadStatisticLog.param("obj_locate", b2Var.P1);
            baseThreadStatisticLog.param("obj_source", b2Var.Z);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(b2Var));
            baseThreadStatisticLog.param("obj_name", b2Var.V0);
            if (b2Var.J() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, b2Var.J().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, b2Var.J().oriUgcVid);
            }
            if (b2Var.s1 > 0) {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            if (b2Var.H() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, b2Var.H().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, b2Var.l0() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }
}
