package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PbActivityConfig extends IntentConfig {
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
    public static final String KEY_FROM_PERSONALIZE = "from_personalize";
    public static final String KEY_FROM_SMART_FRS = "from_smart_frs";
    public static final String KEY_FROM_TIEBA_KUANG = "from_tieba_kuang";
    public static final String KEY_FROM_VIDEO_TAB = "from_video_tab";
    public static final String KEY_GOD_REPLY_ID = "god_reply_id";
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
    private String key_video_source_value;
    private final Context mContext;

    public PbActivityConfig(Context context) {
        super(context);
        this.key_video_source_value = "";
        this.mContext = context;
    }

    public PbActivityConfig createCfgForPersonCenter(String str, String str2, String str3, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_start_for_result", "1");
            intent.putExtra("request_code", i);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, boolean z) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(KEY_IS_FROM_BAR_VOTE, z);
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, int i, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra(KEY_SORTTYPE, 0);
            intent.putExtra("post_id", str2);
            intent.putExtra("thread_type", i);
            intent.putExtra("st_type", str3);
            intent.putExtra(KEY_SHOULD_ADD_POST_ID, true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createCfgForPbChosen(String str, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("praise_data", i);
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, String str4) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("from", str4);
            intent.putExtra(KEY_SORTTYPE, 0);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str4)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, String str4, String str5) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("from", str4);
            intent.putExtra(KEY_SORTTYPE, 0);
            intent.putExtra("query_word", str5);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_baidu_searchbox".equals(str4)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createMessageCfg(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        if (str != null) {
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
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createSubPbCfg(String str, String str2, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_sub_pb", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createMarkCfg(String str, String str2, boolean z, boolean z2, String str3, int i) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("host_only", z);
        intent.putExtra("squence", z2);
        if (z2) {
            intent.putExtra(KEY_SORTTYPE, 0);
        } else {
            intent.putExtra(KEY_SORTTYPE, 1);
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

    public PbActivityConfig createGodHistoryCfg(String str, String str2, boolean z, boolean z2, String str3, boolean z3, int i) {
        Intent intent = getIntent();
        intent.putExtra("is_good", i);
        intent.putExtra("is_top", z3);
        intent.putExtra("is_from_my_god_config", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return createHistoryCfg(str, str2, z, z2, str3);
    }

    public PbActivityConfig createHistoryCfg(String str, String str2, boolean z, boolean z2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("host_only", z);
        intent.putExtra("squence", z2);
        if (z2) {
            intent.putExtra(KEY_SORTTYPE, 0);
        } else {
            intent.putExtra(KEY_SORTTYPE, 1);
        }
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createFromThreadCfg(bx bxVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (bxVar != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", bxVar.getTid());
            if (bxVar.bnh() != null && !StringUtils.isNull(bxVar.bnh().getId())) {
                intent.putExtra(KEY_GOD_REPLY_ID, bxVar.bnh().getId());
            }
            intent.putExtra("is_good", bxVar.bly());
            intent.putExtra("is_top", bxVar.blx());
            intent.putExtra("thread_time", bxVar.blv());
            intent.putExtra("st_type", str2);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("from_forum_name", str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", "1");
            intent.putExtra("request_code", i);
            intent.putExtra("is_from_thread_config", true);
            intent.putExtra("extra_pb_cache_key", "zan=" + (bxVar.bln() == null ? 0L : bxVar.bln().getNum()));
            if (bxVar.blC() != null && bxVar.blC().getGodUserData().getId() != null) {
                intent.putExtra("extra_pb_funs_count_key", bxVar.blC().getFansNum());
                intent.putExtra("extra_pb_is_attention_key", bxVar.blC().getGodUserData().getIsLike());
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            String valueOf = String.valueOf(bxVar.getFid());
            String blG = bxVar.blG();
            if (bxVar.eEQ != null) {
                setFromForumId(valueOf);
                valueOf = bxVar.eEQ.id;
                blG = bxVar.eEQ.ori_fname;
            }
            setThreadData(bxVar);
            setForumId(String.valueOf(valueOf));
            setForumName(blG);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createFromInterviewCfg(String str, String str2, int i, int i2) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("is_top", i);
            intent.putExtra("is_good", i2);
            intent.putExtra("from", str2);
            intent.putExtra("is_from_interview_live_config", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str2)) {
                intent.addFlags(268435456);
            }
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createViewTypeCfg(String str, boolean z, boolean z2, String str2) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("st_type", str2);
            intent.putExtra("host_only", z);
            intent.putExtra("squence", z2);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbActivityConfig createMangaCfg(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2, boolean z3) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
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

    public PbActivityConfig addLocateParam(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("locate", str);
        }
        return this;
    }

    public PbActivityConfig disablePbKeyPostId() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("is_pb_key_need_post_id", true);
        }
        return this;
    }

    public void setVideo_source(String str) {
        this.key_video_source_value = str;
        getIntent().putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
    }

    public void setNeedPreLoad(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_NEED_PRELOAD, z);
        }
    }

    public void setFrom(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from", str);
        }
    }

    public void setFromSmartFrs(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_smart_frs", z);
        }
    }

    public void setSmartFrsPosition(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_SMART_FRS_POSITION", i);
        }
    }

    public void setJumpToTopArea(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_JUMP_TO_TOP_AREA, z);
        }
    }

    public void setJumpGodReply(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_jump_to_god_reply", z);
        }
    }

    public void setBjhFrom(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_BJH_FROM, i);
        }
    }

    public void setLastTid(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_LAST_TID, str);
        }
    }

    public void setJumpToCommentArea(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_jump_to_comment_area", z);
        }
    }

    public void setFromHomePageQuality(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_FROM_HOME_QUALITY_CARD, z);
        }
    }

    private void addMoreIntentExtraParam() {
        Intent intent = getIntent();
        if (intent != null && this.mContext != null) {
            String simpleName = this.mContext.getClass().getSimpleName();
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

    public void setUserName(String str) {
        getIntent().putExtra("big_pic_type", str);
    }

    public void setFromPushNotify() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
            intent.putExtra("key_start_from", 7);
        }
    }

    public void setForumId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("forum_id", str);
        }
    }

    public void setUnKnowPbType(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_UNKNOW_PB_TYPE, str);
        }
    }

    public void setForumName(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_forum_name", str);
        }
    }

    public void setFromForumId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_forum_id", str);
        }
    }

    public void setNeedRepostRecommendForum(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", z);
        }
    }

    public void setPostThreadTip(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_POST_THREAD_TIP", str);
        }
    }

    public void setStartFrom(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_start_from", i);
        }
    }

    public void setOfficialBarMessageId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_OFFICIAL_BAR_MESSAGE_ID, str);
        }
    }

    public void setIsShareThread(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_SHARE_THREAD, z);
        }
    }

    public void setPreLoad(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_PRE_LOAD, str);
        }
    }

    public PbActivityConfig setSquence(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("squence", z);
        }
        return this;
    }

    public void setSortType(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_SORTTYPE, i);
        }
    }

    public void setHighLightPostId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("high_light_post_id", str);
        }
    }

    public void setRecomData(bg bgVar) {
        Intent intent = getIntent();
        if (intent != null && bgVar != null) {
            bgVar.D(intent);
        }
    }

    public PbActivityConfig setThreadData(bx bxVar) {
        Intent intent = getIntent();
        if (intent != null && bxVar != null) {
            BaijiahaoData baijiahaoData = bxVar.getBaijiahaoData();
            if (baijiahaoData != null) {
                intent.putExtra("key_is_from_dynamic", bxVar.bkm());
                intent.putExtra("key_ori_ugc_nid", baijiahaoData.oriUgcNid);
                intent.putExtra("key_ori_ugc_tid", baijiahaoData.oriUgcTid);
                intent.putExtra("key_ori_ugc_type", baijiahaoData.oriUgcType);
                intent.putExtra("key_ori_ugc_vid", baijiahaoData.oriUgcVid);
            }
            intent.putExtra(KEY_REC_WEIGHT, bxVar.mRecomWeight);
            intent.putExtra(KEY_REC_SOURCE, bxVar.mRecomSource);
            intent.putExtra(KEY_REC_AB_TAG, bxVar.mRecomAbTag);
            intent.putExtra(KEY_REC_EXTRA, bxVar.mRecomExtra);
        }
        return this;
    }

    public PbActivityConfig setBjhData(BaijiahaoData baijiahaoData) {
        boolean z = true;
        Intent intent = getIntent();
        if (intent != null && baijiahaoData != null && baijiahaoData != null) {
            if (baijiahaoData.oriUgcType != 1 && baijiahaoData.oriUgcType != 2 && baijiahaoData.oriUgcType != 3 && baijiahaoData.oriUgcType != 4) {
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

    public PbActivityConfig setBjhData(String str, String str2, String str3, String str4) {
        boolean z = true;
        Intent intent = getIntent();
        if (intent != null) {
            int parseInt = Integer.parseInt(str3);
            if (parseInt != 1 && parseInt != 2 && parseInt != 3 && parseInt != 4) {
                z = false;
            }
            intent.putExtra("key_is_from_dynamic", z);
            intent.putExtra("key_ori_ugc_nid", str);
            intent.putExtra("key_ori_ugc_tid", str2);
            intent.putExtra("key_ori_ugc_type", parseInt);
            intent.putExtra("key_ori_ugc_vid", str4);
        }
        return this;
    }

    public PbActivityConfig setVideoOriginArea(Rect rect) {
        getIntent().putExtra(VIDEO_ORIGIN_AREA, rect);
        return this;
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setIsPrivacy(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_PRIVACY, z);
        }
    }
}
