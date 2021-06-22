package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.n0.r.q.a2;
import d.a.n0.r.q.k1;
/* loaded from: classes3.dex */
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
    public String key_video_source_value;
    public final Context mContext;

    public PbActivityConfig(Context context) {
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

    public PbActivityConfig addLocateParam(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("locate", str);
        }
        return this;
    }

    public PbActivityConfig createCfgForPbChosen(String str, int i2) {
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

    public PbActivityConfig createCfgForPersonCenter(String str, String str2, String str3, int i2) {
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

    public PbActivityConfig createFromInterviewCfg(String str, String str2, int i2, int i3) {
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

    public PbActivityConfig createFromThreadCfg(a2 a2Var, String str, String str2, int i2, boolean z, boolean z2, boolean z3) {
        if (a2Var == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", a2Var.z1());
        if (a2Var.C1() != null && !StringUtils.isNull(a2Var.C1().E())) {
            intent.putExtra(KEY_GOD_REPLY_ID, a2Var.C1().E());
        }
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
        String valueOf = String.valueOf(a2Var.c0());
        String i0 = a2Var.i0();
        if (a2Var.E1 != null) {
            setFromForumId(valueOf);
            OriginalForumInfo originalForumInfo = a2Var.E1;
            String str3 = originalForumInfo.id;
            i0 = originalForumInfo.ori_fname;
            valueOf = str3;
        }
        setThreadData(a2Var);
        setForumId(String.valueOf(valueOf));
        setForumName(i0);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createGodHistoryCfg(String str, String str2, boolean z, boolean z2, String str3, boolean z3, int i2) {
        Intent intent = getIntent();
        intent.putExtra("is_good", i2);
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

    public PbActivityConfig createMangaCfg(String str, String str2, String str3, String str4, int i2, int i3, boolean z, boolean z2, boolean z3) {
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

    public PbActivityConfig createMarkCfg(String str, String str2, boolean z, boolean z2, String str3, int i2) {
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
        intent.putExtra("request_code", i2);
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createMessageCfg(String str, String str2, String str3, long j, String str4, String str5, String str6) {
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

    public PbActivityConfig createNormalCfg(String str, String str2, String str3) {
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

    public PbActivityConfig createSubPbCfg(String str, String str2, String str3) {
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

    public PbActivityConfig createViewTypeCfg(String str, boolean z, boolean z2, String str2) {
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

    public PbActivityConfig disablePbKeyPostId() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("is_pb_key_need_post_id", true);
        }
        return this;
    }

    public PbActivityConfig setBjhData(BaijiahaoData baijiahaoData) {
        Intent intent = getIntent();
        if (intent != null && baijiahaoData != null && baijiahaoData != null) {
            int i2 = baijiahaoData.oriUgcType;
            boolean z = true;
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
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

    public void setBjhFrom(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_BJH_FROM, i2);
        }
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

    public void setFromForumId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_forum_id", str);
        }
    }

    public void setFromHomePageQuality(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_FROM_HOME_QUALITY_CARD, z);
        }
    }

    public void setFromPushNotify() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(TbWebViewActivityConfig.INTENT_KEY_IS_FROM_PUSH_NOTIFY, true);
            intent.putExtra("key_start_from", 7);
        }
    }

    public void setFromSmartFrs(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from_smart_frs", z);
        }
    }

    public void setHighLightPostId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("high_light_post_id", str);
        }
    }

    public void setIsPrivacy(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_PRIVACY, z);
        }
    }

    public void setIsShareThread(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_SHARE_THREAD, z);
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

    public void setJumpToTopArea(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_JUMP_TO_TOP_AREA, z);
        }
    }

    public void setLastTid(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_LAST_TID, str);
        }
    }

    public void setNeedPreLoad(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_NEED_PRELOAD, z);
        }
    }

    public void setNeedRepostRecommendForum(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", z);
        }
    }

    public void setOfficialBarMessageId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_OFFICIAL_BAR_MESSAGE_ID, str);
        }
    }

    public void setPostThreadTip(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_POST_THREAD_TIP", str);
        }
    }

    public void setPreLoad(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_PRE_LOAD, str);
        }
    }

    public void setRecomData(k1 k1Var) {
        Intent intent = getIntent();
        if (intent == null || k1Var == null) {
            return;
        }
        k1Var.c(intent);
    }

    public void setSmartFrsPosition(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("KEY_SMART_FRS_POSITION", i2);
        }
    }

    public void setSortType(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("sort_type", i2);
        }
    }

    public PbActivityConfig setSquence(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("squence", z);
        }
        return this;
    }

    public void setStartFrom(int i2) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_start_from", i2);
        }
    }

    public PbActivityConfig setThreadData(a2 a2Var) {
        Intent intent = getIntent();
        if (intent != null && a2Var != null) {
            BaijiahaoData V = a2Var.V();
            if (V != null) {
                intent.putExtra("key_is_from_dynamic", a2Var.C2());
                intent.putExtra("key_ori_ugc_nid", V.oriUgcNid);
                intent.putExtra("key_ori_ugc_tid", V.oriUgcTid);
                intent.putExtra("key_ori_ugc_type", V.oriUgcType);
                intent.putExtra("key_ori_ugc_vid", V.oriUgcVid);
            }
            intent.putExtra(KEY_REC_WEIGHT, a2Var.U0);
            intent.putExtra(KEY_REC_SOURCE, a2Var.T0);
            intent.putExtra(KEY_REC_AB_TAG, a2Var.V0);
            intent.putExtra(KEY_REC_EXTRA, a2Var.W0);
        }
        return this;
    }

    public void setUnKnowPbType(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_UNKNOW_PB_TYPE, str);
        }
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setUserName(String str) {
        getIntent().putExtra("big_pic_type", str);
    }

    public PbActivityConfig setVideoOriginArea(Rect rect) {
        getIntent().putExtra(VIDEO_ORIGIN_AREA, rect);
        return this;
    }

    public void setVideo_source(String str) {
        this.key_video_source_value = str;
        getIntent().putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
    }

    public void showOpenEditorTips(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("key_open_editor_tips", str);
        }
    }

    public PbActivityConfig setBjhData(String str, String str2, String str3, String str4) {
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

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, boolean z) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KEY_IS_FROM_BAR_VOTE, z);
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, int i2, String str3) {
        if (str == null) {
            return this;
        }
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("sort_type", 0);
        intent.putExtra("post_id", str2);
        intent.putExtra("thread_type", i2);
        intent.putExtra("st_type", str3);
        intent.putExtra(KEY_SHOULD_ADD_POST_ID, true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        if (!(this.mContext instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, String str4) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, String str3, String str4, String str5) {
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        intent.putExtra(KEY_VIDEO_SOURCE, this.key_video_source_value);
        addMoreIntentExtraParam();
        return this;
    }
}
