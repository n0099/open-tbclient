package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.e35;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PbCommentFloatActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVITY_RESULT_DELETE = 1;
    public static final String BIG_PIC_NAME = "big_pic_type";
    public static final String FROM_BAIDU_SEARCHBOX = "from_baidu_searchbox";
    public static final String FROM_INTERVIEW_LIVE = "from_interview_live";
    public static final String FROM_SEARCHBOX = "from_searchbox";
    public static final String FROM_VIDEO_LIST = "from_video_list";
    public static final int INVALID_SMART_FRS_POSITION = -1;
    public static final String KEY_BJH_FROM = "bjh_from";
    public static final String KEY_FORUM_ID = "forum_id";
    public static final int KEY_FOR_PRAISE_DATA_NO_ACTION = -1;
    public static final String KEY_FROM = "from";
    public static final String KEY_FROM_FORUM_ID = "from_forum_id";
    public static final String KEY_FROM_FORUM_NAME = "from_forum_name";
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_GAME_VIDEO = "from_game_video";
    public static final String KEY_FROM_GUIDE = "game_guide";
    public static final String KEY_FROM_HOME_QUALITY_CARD = "from_home_quality_card";
    public static final String KEY_FROM_HOTTOPIC = "from_hottopic";
    public static final String KEY_FROM_MAINTAB = "from_maintab";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_FROM_NEWS = "game_news";
    public static final String KEY_FROM_PAGE_TYPE = "key_from_page_type";
    public static final String KEY_FROM_PERSONALIZE = "from_personalize";
    public static final String KEY_FROM_SMART_FRS = "from_smart_frs";
    public static final String KEY_FROM_TIEBA_KUANG = "from_tieba_kuang";
    public static final String KEY_FROM_VIDEO_PAGE_ID = "key_from_video_page_id";
    public static final String KEY_FROM_VIDEO_PAGE_TYPE = "key_from_video_page_type";
    public static final String KEY_FROM_VIDEO_TAB = "from_video_tab";
    public static final String KEY_GOD_REPLY_ID = "god_reply_id";
    public static final String KEY_HIGH_LIGHT_3S_POST_ID = "key_high_light_3s_post_id";
    public static final String KEY_HIGH_LIGHT_POST_ID = "high_light_post_id";
    public static final String KEY_HOST_ONLY = "host_only";
    public static final String KEY_INTENT_EXTRA_PB_CACHE_KEY = "extra_pb_cache_key";
    public static final String KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY = "extra_pb_funs_count_key";
    public static final String KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY = "extra_pb_is_attention_key";
    public static final String KEY_INTENT_GOOD_DATA = "good_data";
    public static final String KEY_INTENT_GUESS_LIKE_DATA = "guess_like_data";
    public static final String KEY_INTENT_TID = "tid";
    public static final String KEY_INTENT_TOP_DATA = "top_data";
    public static final String KEY_INTENT_TYPE = "type";
    public static final String KEY_IS_AD = "is_ad";
    public static final String KEY_IS_FROM_BAR_VOTE = "is_from_bar_vote";
    public static final String KEY_IS_FROM_DYNAMIC = "key_is_from_dynamic";
    public static final String KEY_IS_FROM_INTERVIEW_LIVE_CONFIG = "is_from_interview_live_config";
    public static final String KEY_IS_FROM_LOCAL_PUSH = "key_is_from_local_push";
    public static final String KEY_IS_FROM_MY_GOD = "is_from_my_god_config";
    public static final String KEY_IS_FROM_THREAD_CONFIG = "is_from_thread_config";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_INTERVIEW_LIVE = "KEY_IS_INTERVIEW_LIVE";
    public static final String KEY_IS_PB_KEY_NEED_POSTID = "is_pb_key_need_post_id";
    public static final String KEY_IS_PRIVACY = "key_is_privacy";
    public static final String KEY_IS_PV = "is_pv";
    public static final String KEY_IS_SHARE_THREAD = "key_is_share_thread";
    public static final String KEY_IS_SUB_PB = "is_sub_pb";
    public static final String KEY_IS_TOP = "is_top";
    public static final String KEY_JUMP_TO_COMMENT_AREA = "key_jump_to_comment_area";
    public static final String KEY_JUMP_TO_GOD_REPLY = "key_jump_to_god_reply";
    public static final String KEY_JUMP_TO_TOP_AREA = "key_jump_to_top";
    public static final String KEY_LAST_TID = "last_tid";
    public static final String KEY_LOCATE = "locate";
    public static final String KEY_MANGA_IS_NEXT_CHAPTER_VIP = "key_manga_is_next_chapter_vip";
    public static final String KEY_MANGA_IS_PRE_CHAPTER_VIP = "key_manga_is_pre_chapter_vip";
    public static final String KEY_MANGA_IS_USER_VIP = "key_manga_is_user_vip";
    public static final String KEY_MANGA_NEXT_CHAPTER = "key_manga_next_chapter";
    public static final String KEY_MANGA_PREV_CHAPTER = "key_manga_prev_chapter";
    public static final String KEY_MANGA_TITLE = "key_manga_title";
    public static final String KEY_MARK = "mark";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MSG_OP_STAT = "op_stat";
    public static final String KEY_MSG_OP_TYPE = "op_type";
    public static final String KEY_MSG_OP_URL = "op_url";
    public static final String KEY_NEED_PRELOAD = "key_need_preload";
    public static final String KEY_NEED_REPOST_RECOMMEND_FORUM = "KEY_NEED_REPOST_RECOMMEND_FORUM";
    public static final String KEY_OFFICIAL_BAR_MESSAGE_ID = "key_official_bar_message_id";
    public static final String KEY_OPEN_EDITOR_TIPS = "key_open_editor_tips";
    public static final String KEY_ORI_UGC_NID = "key_ori_ugc_nid";
    public static final String KEY_ORI_UGC_TID = "key_ori_ugc_tid";
    public static final String KEY_ORI_UGC_TYPE = "key_ori_ugc_type";
    public static final String KEY_ORI_UGC_VID = "key_ori_ugc_vid";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_POST_THREAD_TIP = "KEY_POST_THREAD_TIP";
    public static final String KEY_PRE_LOAD = "lego_pre_load_data";
    public static final String KEY_PUSH_COLLECT = "fr=collect";
    public static final String KEY_REC_AB_TAG = "key_rec_ab_tag";
    public static final String KEY_REC_EXTRA = "key_rec_extra";
    public static final String KEY_REC_SOURCE = "key_rec_source";
    public static final String KEY_REC_WEIGHT = "key_rec_weight";
    public static final String KEY_SHOULD_ADD_POST_ID = "KEY_SHOULD_ADD_POST_ID";
    public static final String KEY_SMART_FRS_POSITION = "KEY_SMART_FRS_POSITION";
    public static final String KEY_SORTTYPE = "sort_type";
    public static final String KEY_SQUENCE = "squence";
    public static final String KEY_START_FROM = "key_start_from";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_THREAD_TIME = "thread_time";
    public static final String KEY_THREAD_TYPE = "thread_type";
    public static final String KEY_UNKNOW_PB_TYPE = "unKnowPbType";
    public static String KEY_VIDEO_SOURCE = "key_video_source";
    public static final String KYE_IS_START_FOR_RESULT = "is_start_for_result";
    public static final String PRAISE_DATA = "praise_data";
    public static final String QUERY_WORD = "query_word";
    public static final String START_FOR_RESULT = "1";
    public static final int THREAD_TYPE_NOT_SHOW_IS_TOP = 0;
    public static final int THREAD_TYPE_SHOW_IS_TOP = 1;
    public static final String VALUE_FROM_FRS = "FrsActivity";
    public static final String VALUE_FROM_HOT_TOPIC = "HotTopicActivity";
    public static final String VALUE_FROM_MAINTAB = "MainTabActivity";
    public static final String VIDEO_ORIGIN_AREA = "video_origin_area";
    public transient /* synthetic */ FieldHolder $fh;
    public String key_video_source_value;
    public final Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1932770732, "Lcom/baidu/tbadk/core/atomData/PbCommentFloatActivityConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1932770732, "Lcom/baidu/tbadk/core/atomData/PbCommentFloatActivityConfig;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommentFloatActivityConfig(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.key_video_source_value = "";
        this.mContext = context;
    }

    private void addMoreIntentExtraParam() {
        Intent intent;
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (intent = getIntent()) != null && (context = this.mContext) != null) {
            String simpleName = context.getClass().getSimpleName();
            if ("FrsActivity".equalsIgnoreCase(simpleName)) {
                intent.putExtra("from_frs", true);
            } else {
                intent.putExtra("from_frs", false);
            }
            if ("MainTabActivity".equalsIgnoreCase(simpleName)) {
                intent.putExtra("from_maintab", true);
            } else {
                intent.putExtra("from_maintab", false);
            }
            if ("HotTopicActivity".equalsIgnoreCase(simpleName)) {
                intent.putExtra("from_hottopic", true);
            } else {
                intent.putExtra("from_hottopic", false);
            }
        }
    }

    public PbCommentFloatActivityConfig addLocateParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                intent.putExtra("locate", str);
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeL.objValue;
    }

    public void setBjhFrom(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra("bjh_from", i);
        }
    }

    public void setForumId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("forum_id", str);
        }
    }

    public void setForumName(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("from_forum_name", str);
        }
    }

    public void setFrom(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("from", str);
        }
    }

    public void setFromForumId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("from_forum_id", str);
        }
    }

    public void setFromHomePageQuality(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("from_home_quality_card", z);
        }
    }

    public void setFromPageType(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_FROM_PAGE_TYPE, i);
        }
    }

    public void setFromSmartFrs(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048604, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("from_smart_frs", z);
        }
    }

    public void setFromVideoPageType(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_FROM_VIDEO_PAGE_TYPE, i);
        }
    }

    public void setFromVideoPageUniqueId(BdUniqueId bdUniqueId) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_from_video_page_id", bdUniqueId);
        }
    }

    public void setHighLight3sPostId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_HIGH_LIGHT_3S_POST_ID, str);
        }
    }

    public void setHighLightPostId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("high_light_post_id", str);
        }
    }

    public void setIsPrivacy(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_is_privacy", z);
        }
    }

    public void setIsShareThread(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_is_share_thread", z);
        }
    }

    public void setJumpGodReply(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_jump_to_god_reply", z);
        }
    }

    public void setJumpToCommentArea(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_jump_to_comment_area", z);
        }
    }

    public void setJumpToTopArea(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_jump_to_top", z);
        }
    }

    public void setLastTid(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("last_tid", str);
        }
    }

    public void setNeedPreLoad(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_need_preload", z);
        }
    }

    public void setNeedRepostRecommendForum(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", z);
        }
    }

    public void setOfficialBarMessageId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_official_bar_message_id", str);
        }
    }

    public void setPostThreadTip(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("KEY_POST_THREAD_TIP", str);
        }
    }

    public void setPreLoad(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("lego_pre_load_data", str);
        }
    }

    public void setRecomData(e35 e35Var) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, e35Var) == null) && (intent = getIntent()) != null && e35Var != null) {
            e35Var.c(intent);
        }
    }

    public void setSmartFrsPosition(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048621, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra("KEY_SMART_FRS_POSITION", i);
        }
    }

    public void setSortType(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra("sort_type", i);
        }
    }

    public PbCommentFloatActivityConfig setSquence(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048623, this, z)) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                intent.putExtra("squence", z);
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeZ.objValue;
    }

    public void setStartFrom(int i) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048624, this, i) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_start_from", i);
        }
    }

    public void setUnKnowPbType(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("unKnowPbType", str);
        }
    }

    public void setUri(Uri uri) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, uri) == null) && (intent = getIntent()) != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            getIntent().putExtra("big_pic_type", str);
        }
    }

    public PbCommentFloatActivityConfig setVideoOriginArea(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, rect)) == null) {
            getIntent().putExtra("video_origin_area", rect);
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeL.objValue;
    }

    public void setVideo_source(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.key_video_source_value = str;
            getIntent().putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        }
    }

    public void showOpenEditorTips(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra("key_open_editor_tips", str);
        }
    }

    public PbCommentFloatActivityConfig createCfgForPbChosen(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("praise_data", i);
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLI.objValue;
    }

    public PbCommentFloatActivityConfig createCfgForPersonCenter(String str, String str2, String str3, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, i)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_start_for_result", "1");
            intent.putExtra("request_code", i);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLLI.objValue;
    }

    public PbCommentFloatActivityConfig createFromInterviewCfg(String str, String str2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, str, str2, i, i2)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("is_top", i);
            intent.putExtra("is_good", i2);
            intent.putExtra("from", str2);
            intent.putExtra("is_from_interview_live_config", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str2)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLII.objValue;
    }

    public PbCommentFloatActivityConfig createNormalCfg(String str, String str2, int i, String str3) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048586, this, str, str2, i, str3)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("sort_type", 0);
            intent.putExtra("post_id", str2);
            intent.putExtra("thread_type", i);
            intent.putExtra("st_type", str3);
            intent.putExtra("KEY_SHOULD_ADD_POST_ID", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLIL.objValue;
    }

    public PbCommentFloatActivityConfig createFromThreadCfg(ThreadData threadData, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        long num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{threadData, str, str2, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (threadData == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", threadData.getTid());
            if (threadData.getTopAgreePost() != null && !StringUtils.isNull(threadData.getTopAgreePost().S())) {
                intent.putExtra("god_reply_id", threadData.getTopAgreePost().S());
            }
            intent.putExtra("is_good", threadData.getIs_good());
            intent.putExtra("is_top", threadData.getIs_top());
            intent.putExtra("thread_time", threadData.getLast_time_int());
            intent.putExtra("st_type", str2);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("from_forum_name", str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", "1");
            intent.putExtra("request_code", i);
            intent.putExtra("is_from_thread_config", true);
            if (threadData.getPraise() == null) {
                num = 0;
            } else {
                num = threadData.getPraise().getNum();
            }
            intent.putExtra("extra_pb_cache_key", "zan=" + num);
            if (threadData.getAuthor() != null && threadData.getAuthor().getGodUserData().getId() != null) {
                intent.putExtra("extra_pb_funs_count_key", threadData.getAuthor().getFansNum());
                intent.putExtra("extra_pb_is_attention_key", threadData.getAuthor().getGodUserData().getIsLike());
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            if (threadData.mOriginalForumInfo != null) {
                setFromForumId(valueOf);
                OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
                String str3 = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
                valueOf = str3;
            }
            setThreadData(threadData);
            setForumId(String.valueOf(valueOf));
            setForumName(forum_name);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createGodHistoryCfg(String str, String str2, boolean z, boolean z2, String str3, boolean z3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3, Boolean.valueOf(z3), Integer.valueOf(i)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("is_good", i);
            intent.putExtra("is_top", z3);
            intent.putExtra("is_from_my_god_config", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            return createHistoryCfg(str, str2, z, z2, str3);
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createMessageCfg(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, str3, Long.valueOf(j), str4, str5, str6})) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_pv", true);
            intent.putExtra("msg_id", j);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (str4 != null) {
                intent.putExtra("op_url", str4);
            }
            if (str5 != null) {
                intent.putExtra("op_stat", str5);
            }
            if (str6 != null) {
                intent.putExtra("op_type", str6);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createHistoryCfg(String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("host_only", z);
            intent.putExtra("squence", z2);
            if (z2) {
                intent.putExtra("sort_type", 0);
            } else {
                intent.putExtra("sort_type", 1);
            }
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createNormalCfg(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048589, this, str, str2, str3, str4, str5)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("from", str4);
            intent.putExtra("sort_type", 0);
            intent.putExtra("query_word", str5);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_baidu_searchbox".equals(str4)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLLLL.objValue;
    }

    public PbCommentFloatActivityConfig createMangaCfg(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                intent.putExtra("thread_id", str);
                intent.putExtra("post_id", str2);
                intent.putExtra("st_type", str3);
                intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
                if (!(this.mContext instanceof Activity)) {
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                }
                intent.putExtra("key_manga_title", str4);
                intent.putExtra("key_manga_prev_chapter", i);
                intent.putExtra("key_manga_next_chapter", i2);
                intent.putExtra("key_manga_is_pre_chapter_vip", z);
                intent.putExtra("key_manga_is_next_chapter_vip", z2);
                intent.putExtra("key_manga_is_user_vip", z3);
                addMoreIntentExtraParam();
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createMarkCfg(String str, String str2, boolean z, boolean z2, String str3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3, Integer.valueOf(i)})) == null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("host_only", z);
            intent.putExtra("squence", z2);
            if (z2) {
                intent.putExtra("sort_type", 0);
            } else {
                intent.putExtra("sort_type", 1);
            }
            intent.putExtra("st_type", str3);
            intent.putExtra("from_mark", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", "1");
            intent.putExtra("request_code", i);
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createNormalCfg(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLL.objValue;
    }

    public PbCommentFloatActivityConfig createSubPbCfg(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, str2, str3)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_sub_pb", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLL.objValue;
    }

    public PbCommentFloatActivityConfig createNormalCfg(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, str2, str3, str4)) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("from", str4);
            intent.putExtra("sort_type", 0);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str4)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLLL.objValue;
    }

    public PbCommentFloatActivityConfig createNormalCfg(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, Boolean.valueOf(z)})) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_from_bar_vote", z);
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig createViewTypeCfg(String str, boolean z, boolean z2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), str2})) == null) {
            if (str == null) {
                return this;
            }
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("st_type", str2);
            intent.putExtra("host_only", z);
            intent.putExtra("squence", z2);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeCommon.objValue;
    }

    public PbCommentFloatActivityConfig disablePbKeyPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                intent.putExtra("is_pb_key_need_post_id", true);
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeV.objValue;
    }

    public void setFromPushNotify() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (intent = getIntent()) != null) {
            intent.putExtra("is_from_push", true);
            intent.putExtra("key_start_from", 7);
        }
    }

    public PbCommentFloatActivityConfig setBjhData(BaijiahaoData baijiahaoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, baijiahaoData)) == null) {
            Intent intent = getIntent();
            if (intent != null && baijiahaoData != null && baijiahaoData != null) {
                int i = baijiahaoData.oriUgcType;
                boolean z = true;
                if (i != 1 && i != 2 && i != 3 && i != 4) {
                    z = false;
                }
                intent.putExtra("key_is_from_dynamic", z);
                intent.putExtra("key_ori_ugc_nid", baijiahaoData.oriUgcNid);
                intent.putExtra("key_ori_ugc_tid", baijiahaoData.oriUgcTid);
                intent.putExtra("key_ori_ugc_type", baijiahaoData.oriUgcType);
                intent.putExtra("key_ori_ugc_vid", baijiahaoData.oriUgcVid);
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeL.objValue;
    }

    public PbCommentFloatActivityConfig setThreadData(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, threadData)) == null) {
            Intent intent = getIntent();
            if (intent != null && threadData != null) {
                BaijiahaoData baijiahaoData = threadData.getBaijiahaoData();
                if (baijiahaoData != null) {
                    intent.putExtra("key_is_from_dynamic", threadData.isUgcThreadType());
                    intent.putExtra("key_ori_ugc_nid", baijiahaoData.oriUgcNid);
                    intent.putExtra("key_ori_ugc_tid", baijiahaoData.oriUgcTid);
                    intent.putExtra("key_ori_ugc_type", baijiahaoData.oriUgcType);
                    intent.putExtra("key_ori_ugc_vid", baijiahaoData.oriUgcVid);
                }
                intent.putExtra("key_rec_weight", threadData.mRecomWeight);
                intent.putExtra("key_rec_source", threadData.mRecomSource);
                intent.putExtra("key_rec_ab_tag", threadData.mRecomAbTag);
                intent.putExtra("key_rec_extra", threadData.mRecomExtra);
            }
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeL.objValue;
    }

    public PbCommentFloatActivityConfig setBjhData(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048595, this, str, str2, str3, str4)) == null) {
            Intent intent = getIntent();
            if (intent == null) {
                return this;
            }
            int parseInt = Integer.parseInt(str3);
            boolean z = true;
            if (parseInt != 1 && parseInt != 2 && parseInt != 3 && parseInt != 4) {
                z = false;
            }
            intent.putExtra("key_is_from_dynamic", z);
            intent.putExtra("key_ori_ugc_nid", str);
            intent.putExtra("key_ori_ugc_tid", str2);
            intent.putExtra("key_ori_ugc_type", parseInt);
            intent.putExtra("key_ori_ugc_vid", str4);
            return this;
        }
        return (PbCommentFloatActivityConfig) invokeLLLL.objValue;
    }
}
