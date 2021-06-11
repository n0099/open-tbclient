package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.r.q.a2;
/* loaded from: classes3.dex */
public class PbVideoActivityConfig extends IntentConfig {
    public static final int ACTIVITY_RESULT_DELETE = 1;
    public static final String BIG_PIC_NAME = "big_pic_type";
    public static final String FROM_BAIDU_SEARCHBOX = "from_baidu_searchbox";
    public static final String FROM_INTERVIEW_LIVE = "from_interview_live";
    public static final String FROM_SEARCHBOX = "from_searchbox";
    public static final String FROM_VIDEO_LIST = "from_video_list";
    public static final int INVALID_SMART_FRS_POSITION = -1;
    public static final String KEY_FORUM_ID = "forum_id";
    public static final int KEY_FOR_PRAISE_DATA_NO_ACTION = -1;
    public static final String KEY_FROM = "from";
    public static final String KEY_FROM_FORUM_NAME = "from_forum_name";
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_HOTTOPIC = "from_hottopic";
    public static final String KEY_FROM_MAINTAB = "from_maintab";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_FROM_SMART_FRS = "from_smart_frs";
    public static final String KEY_FROM_TIEBA_KUANG = "from_tieba_kuang";
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
    public static final String KEY_IS_FROM_INTERVIEW_LIVE_CONFIG = "is_from_interview_live_config";
    public static final String KEY_IS_FROM_MY_GOD = "is_from_my_god_config";
    public static final String KEY_IS_FROM_THREAD_CONFIG = "is_from_thread_config";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_INTERVIEW_LIVE = "KEY_IS_INTERVIEW_LIVE";
    public static final String KEY_IS_PB_KEY_NEED_POSTID = "is_pb_key_need_post_id";
    public static final String KEY_IS_PV = "is_pv";
    public static final String KEY_IS_SUB_PB = "is_sub_pb";
    public static final String KEY_IS_TOP = "is_top";
    public static final String KEY_JUMP_TO_COMMENT_AREA = "key_jump_to_comment_area";
    public static final String KEY_JUMP_TO_GOD_REPLY = "key_jump_to_god_reply";
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
    public static final String KEY_NEED_REPOST_RECOMMEND_FORUM = "KEY_NEED_REPOST_RECOMMEND_FORUM";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_POST_THREAD_TIP = "KEY_POST_THREAD_TIP";
    public static final String KEY_SMART_FRS_POSITION = "KEY_SMART_FRS_POSITION";
    public static final String KEY_SQUENCE = "squence";
    public static final String KEY_START_FROM = "key_start_from";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_THREAD_TIME = "thread_time";
    public static final String KEY_THREAD_TYPE = "thread_type";
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
    public String key_video_source_value;
    public final Context mContext;

    public PbVideoActivityConfig(Context context) {
        super(context);
        this.key_video_source_value = "";
        this.mContext = context;
    }

    private void addMoreIntentExtraParam() {
        Context context;
        Intent intent = getIntent();
        if (intent == null || (context = this.mContext) == null) {
            return;
        }
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

    public PbVideoActivityConfig addLocateParam(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("locate", str);
        }
        return this;
    }

    public PbVideoActivityConfig createCfgForPbChosen(String str, int i2) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("praise_data", i2);
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createCfgForPersonCenter(String str, String str2, String str3, int i2) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("is_start_for_result", "1");
        intent.putExtra("request_code", i2);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createFromInterviewCfg(String str, String str2, int i2, int i3) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("is_top", i2);
        intent.putExtra("is_good", i3);
        intent.putExtra("from", str2);
        intent.putExtra("is_from_interview_live_config", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str2)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createFromThreadCfg(a2 a2Var, String str, String str2, int i2, boolean z, boolean z2, boolean z3) {
        if (a2Var == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", a2Var.z1());
        intent.putExtra("is_good", a2Var.x0());
        intent.putExtra("is_top", a2Var.y0());
        intent.putExtra("thread_time", a2Var.C0());
        intent.putExtra("st_type", str2);
        intent.putExtra("squence", z);
        intent.putExtra("host_only", z2);
        intent.putExtra("is_ad", z3);
        intent.putExtra("from_forum_name", str);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra("is_start_for_result", "1");
        intent.putExtra("request_code", i2);
        intent.putExtra("is_from_thread_config", true);
        long num = a2Var.R0() == null ? 0L : a2Var.R0().getNum();
        intent.putExtra("extra_pb_cache_key", "zan=" + num);
        if (a2Var.T() != null && a2Var.T().getGodUserData().getId() != null) {
            intent.putExtra("extra_pb_funs_count_key", a2Var.T().getFansNum());
            intent.putExtra("extra_pb_is_attention_key", a2Var.T().getGodUserData().getIsLike());
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createGodHistoryCfg(String str, String str2, boolean z, boolean z2, String str3, boolean z3, int i2) {
        Intent intent = getIntent();
        intent.putExtra("is_good", i2);
        intent.putExtra("is_top", z3);
        intent.putExtra("is_from_my_god_config", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return createHistoryCfg(str, str2, z, z2, str3);
    }

    public PbVideoActivityConfig createHistoryCfg(String str, String str2, boolean z, boolean z2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("host_only", z);
        intent.putExtra("squence", z2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createMangaCfg(String str, String str2, String str3, String str4, int i2, int i3, boolean z, boolean z2, boolean z3) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            intent.putExtra("key_manga_title", str4);
            intent.putExtra("key_manga_prev_chapter", i2);
            intent.putExtra("key_manga_next_chapter", i3);
            intent.putExtra("key_manga_is_pre_chapter_vip", z);
            intent.putExtra("key_manga_is_next_chapter_vip", z2);
            intent.putExtra("key_manga_is_user_vip", z3);
            addMoreIntentExtraParam();
        }
        return this;
    }

    public PbVideoActivityConfig createMarkCfg(String str, String str2, boolean z, boolean z2, String str3, int i2) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("host_only", z);
        intent.putExtra("squence", z2);
        intent.putExtra("st_type", str3);
        intent.putExtra("from_mark", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra("is_start_for_result", "1");
        intent.putExtra("request_code", i2);
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createMessageCfg(String str, String str2, String str3, long j, String str4, String str5, String str6) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createNormalCfg(String str, String str2, String str3) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createSubPbCfg(String str, String str2, String str3) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createViewTypeCfg(String str, boolean z, boolean z2, String str2) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig disablePbKeyPostId() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("is_pb_key_need_post_id", true);
        }
        return this;
    }

    public void setForumId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("forum_id", str);
        }
    }

    public void setForumName(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_forum_name", str);
        }
    }

    public void setFrom(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from", str);
        }
    }

    public void setFromPushNotify() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
        }
    }

    public void setFromSmartFrs(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_smart_frs", z);
        }
    }

    public void setJumpGodReply(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_jump_to_god_reply", z);
        }
    }

    public void setJumpToCommentArea(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_jump_to_comment_area", z);
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

    public void setSmartFrsPosition(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_SMART_FRS_POSITION", i2);
        }
    }

    public void setStartFrom(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_start_from", i2);
        }
    }

    public void setUserName(String str) {
        getIntent().putExtra("big_pic_type", str);
    }

    public void setVideo_source(String str) {
        this.key_video_source_value = str;
        getIntent().putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
    }

    public PbVideoActivityConfig createNormalCfg(String str, String str2, int i2, String str3) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("thread_type", i2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createNormalCfg(String str, String str2, String str3, String str4) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("from", str4);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity) || "from_searchbox".equals(str4)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbVideoActivityConfig createNormalCfg(String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("from", str4);
        intent.putExtra("query_word", str5);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity) || "from_baidu_searchbox".equals(str4)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }
}
