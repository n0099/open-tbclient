package com.baidu.tbadk.core.util;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.v0;
/* loaded from: classes3.dex */
public class FeedTabCardStatisticHelper {
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

    public static StatisticItem clickThreadBigPictureStatisticLog(a2 a2Var, String str) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_BIG_PICTURE_CLICK, a2Var, str);
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        baseThreadStatisticLog.param("obj_type", a2Var.a3());
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
        }
        baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, a2Var.v2() ? 1 : 0);
        return baseThreadStatisticLog;
    }

    public static StatisticItem clickThreadEnterForumStatisticLog(a2 a2Var, String str) {
        StatisticItem baseThreadStatisticLog;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.getType() == a2.j3) {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_ENTER_FORUM_CLICK, a2Var, str);
            baseThreadStatisticLog.param("obj_type", 1);
            if (a2Var.V() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
            }
        } else {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_ENTER_FORUM_CLICK, a2Var, str);
            baseThreadStatisticLog.param("obj_type", a2Var.a3());
        }
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
        }
        return baseThreadStatisticLog;
    }

    public static StatisticItem clickThreadNEGFeedbackStatisticLog(v0 v0Var, String str) {
        StatisticItem statisticItem;
        if (v0Var == null) {
            return null;
        }
        int i2 = v0Var.n;
        if (i2 != 2 && i2 != 6 && i2 != 8) {
            statisticItem = new StatisticItem(KEY_TAB_FEED_PICTURE_TEXT_THREAD_NEG_FEEDBACK_CLICK);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        } else {
            statisticItem = new StatisticItem(KEY_TAB_FEED_VIDEO_THREAD_NEG_FEEDBACK_CLICK);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 2);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("tid", v0Var.e());
        statisticItem.param("fid", v0Var.c());
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str);
        return statisticItem;
    }

    public static StatisticItem clickThreadPotraitStatisticLog(a2 a2Var, String str) {
        StatisticItem baseThreadStatisticLog;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.getType() == a2.j3) {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_POTRAIT_CLICK, a2Var, str);
            if (a2Var.V() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
            }
        } else {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_POTRAIT_CLICK, a2Var, str);
            baseThreadStatisticLog.param("obj_type", a2Var.a3());
        }
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
        }
        return baseThreadStatisticLog;
    }

    public static StatisticItem clickThreadTitleStatisticLog(a2 a2Var, String str) {
        StatisticItem baseThreadStatisticLog;
        if (a2Var == null) {
            return null;
        }
        if (a2Var.getType() == a2.j3) {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_TITLE_CLICK, a2Var, str);
            if (a2Var.V() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
            }
            if (a2Var.r1 > 0) {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
        } else {
            baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_TITLE_CLICK, a2Var, str);
            baseThreadStatisticLog.param("obj_type", a2Var.a3());
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, a2Var.v2() ? 1 : 0);
        }
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
        }
        return baseThreadStatisticLog;
    }

    public static StatisticItem clickThreadVideoAreaStatisticLog(a2 a2Var, String str) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_VIDEO_AREA_CLICK, a2Var, str);
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
        }
        return baseThreadStatisticLog;
    }

    public static StatisticItem getBaseThreadStatisticLog(String str, a2 a2Var, String str2) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("tid", a2Var.z1());
        statisticItem.param("fid", a2Var.c0());
        statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str2);
        return statisticItem;
    }

    public static int getThreadType(a2 a2Var) {
        if (a2Var.getType() == a2.X2 || a2Var.T1()) {
            return 2;
        }
        return (a2Var.R1() || a2Var.U1()) ? 3 : 1;
    }

    public static StatisticItem showPictureTextThreadStatisticLog(a2 a2Var, String str) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_SHOW, a2Var, str);
        baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param("obj_source", a2Var.Z);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        baseThreadStatisticLog.param("obj_type", a2Var.a3());
        if (a2Var.C1() != null) {
            baseThreadStatisticLog.param("obj_name", a2Var.C1().c0 ? 1 : 0);
        }
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
        }
        if (a2Var.T() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, a2Var.T().getIsLike() ? 1 : 0);
        }
        baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, a2Var.v2() ? 1 : 0);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, a2Var.w0() ? 1 : 2);
        return baseThreadStatisticLog;
    }

    public static StatisticItem showVideoThreadStatisticLog(a2 a2Var, String str) {
        if (a2Var == null) {
            return null;
        }
        StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_SHOW, a2Var, str);
        baseThreadStatisticLog.param("obj_locate", a2Var.O1);
        baseThreadStatisticLog.param("obj_source", a2Var.Z);
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(a2Var));
        baseThreadStatisticLog.param("obj_name", a2Var.V0);
        if (a2Var.V() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, a2Var.V().oriUgcNid);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, a2Var.V().oriUgcVid);
        }
        if (a2Var.r1 > 0) {
            baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
        } else {
            baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
        }
        if (a2Var.T() != null) {
            baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, a2Var.T().getIsLike() ? 1 : 0);
        }
        baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, a2Var.w0() ? 1 : 2);
        return baseThreadStatisticLog;
    }
}
