package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dq4;
import com.baidu.tieba.pf5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static StatisticItem clickThreadBigPictureStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_BIG_PICTURE_CLICK, threadData, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            baseThreadStatisticLog.param("obj_type", threadData.picCount());
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, threadData.isShowFullThread() ? 1 : 0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_TO, pf5.c() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadEnterForumStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_ENTER_FORUM_CLICK, threadData, str);
                baseThreadStatisticLog.param("obj_type", 1);
                if (threadData.getBaijiahaoData() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_ENTER_FORUM_CLICK, threadData, str);
                baseThreadStatisticLog.param("obj_type", threadData.picCount());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadNEGFeedbackStatisticLog(dq4 dq4Var, String str) {
        InterceptResult invokeLL;
        StatisticItem statisticItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dq4Var, str)) == null) {
            if (dq4Var == null) {
                return null;
            }
            int i = dq4Var.o;
            if (i != 2 && i != 6 && i != 8) {
                statisticItem = new StatisticItem(KEY_TAB_FEED_PICTURE_TEXT_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            } else {
                statisticItem = new StatisticItem(KEY_TAB_FEED_VIDEO_THREAD_NEG_FEEDBACK_CLICK);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 2);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("tid", dq4Var.f());
            statisticItem.param("fid", dq4Var.c());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str);
            return statisticItem;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadPotraitStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_POTRAIT_CLICK, threadData, str);
                if (threadData.getBaijiahaoData() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_POTRAIT_CLICK, threadData, str);
                baseThreadStatisticLog.param("obj_type", threadData.picCount());
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadTitleStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        StatisticItem baseThreadStatisticLog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_TITLE_CLICK, threadData, str);
                if (threadData.getBaijiahaoData() != null) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
                }
                if (threadData.middle_page_num > 0) {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
            } else {
                baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_TITLE_CLICK, threadData, str);
                baseThreadStatisticLog.param("obj_type", threadData.picCount());
                baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, threadData.isShowFullThread() ? 1 : 0);
            }
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem clickThreadVideoAreaStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_VIDEO_AREA_CLICK, threadData, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
            }
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem getBaseThreadStatisticLog(String str, ThreadData threadData, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, threadData, str2)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("tid", threadData.getTid());
            statisticItem.param("fid", threadData.getFid());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, str2);
            return statisticItem;
        }
        return (StatisticItem) invokeLLL.objValue;
    }

    public static int getThreadType(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, threadData)) == null) {
            if (threadData.getType() == ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL || threadData.isBJHVideoDynamicThreadType()) {
                return 2;
            }
            return (threadData.isBJHArticleThreadType() || threadData.isBJHVideoThreadType()) ? 3 : 1;
        }
        return invokeL.intValue;
    }

    public static StatisticItem showPictureTextThreadStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_PICTURE_TEXT_THREAD_SHOW, threadData, str);
            baseThreadStatisticLog.param("uid", TbadkCoreApplication.getCurrentAccountId());
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param("obj_source", threadData.threadType);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            baseThreadStatisticLog.param("obj_type", threadData.picCount());
            if (threadData.getTopAgreePost() != null) {
                baseThreadStatisticLog.param("obj_name", threadData.getTopAgreePost().a0 ? 1 : 0);
            }
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
            }
            if (threadData.getAuthor() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.IS_FULL, threadData.isShowFullThread() ? 1 : 0);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, threadData.getIsOperateThread() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public static StatisticItem showVideoThreadStatisticLog(ThreadData threadData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, threadData, str)) == null) {
            if (threadData == null) {
                return null;
            }
            StatisticItem baseThreadStatisticLog = getBaseThreadStatisticLog(KEY_TAB_FEED_VIDEO_THREAD_SHOW, threadData, str);
            baseThreadStatisticLog.param("obj_locate", threadData.statFloor);
            baseThreadStatisticLog.param("obj_source", threadData.threadType);
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis());
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM5, getThreadType(threadData));
            baseThreadStatisticLog.param("obj_name", threadData.mRecomAbTag);
            if (threadData.getBaijiahaoData() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM4, threadData.getBaijiahaoData().oriUgcNid);
                baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_PARAM6, threadData.getBaijiahaoData().oriUgcVid);
            }
            if (threadData.middle_page_num > 0) {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
            } else {
                baseThreadStatisticLog.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
            }
            if (threadData.getAuthor() != null) {
                baseThreadStatisticLog.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().getIsLike() ? 1 : 0);
            }
            baseThreadStatisticLog.param(TiebaStatic.Params.OBJ_FEED_TYPE, threadData.getIsOperateThread() ? 1 : 2);
            return baseThreadStatisticLog;
        }
        return (StatisticItem) invokeLL.objValue;
    }
}
