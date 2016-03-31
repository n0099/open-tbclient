package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PbActivityConfig extends IntentConfig {
    public static final int ACTIVITY_RESULT_DELETE = 1;
    public static final String FROM_BAIDU_SEARCHBOX = "from_baidu_searchbox";
    public static final String FROM_INTERVIEW_LIVE = "from_interview_live";
    public static final String FROM_READER_SERVICE = "from_reader_service";
    public static final String FROM_SEARCHBOX = "from_searchbox";
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final int KEY_FOR_PRAISE_DATA_NO_ACTION = -1;
    public static final String KEY_FROM = "from";
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_HOST_ONLY = "host_only";
    public static final String KEY_INTENT_EXTRA_PB_CACHE_KEY = "extra_pb_cache_key";
    public static final String KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY = "extra_pb_funs_count_key";
    public static final String KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY = "extra_pb_is_attention_key";
    public static final String KEY_INTENT_GOOD_DATA = "good_data";
    public static final String KEY_INTENT_TID = "tid";
    public static final String KEY_INTENT_TOP_DATA = "top_data";
    public static final String KEY_INTENT_TYPE = "type";
    public static final String KEY_IS_AD = "is_ad";
    public static final String KEY_IS_FROM_THREAD_CONFIG = "is_from_thread_config";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_PB_KEY_NEED_POSTID = "is_pb_key_need_post_id";
    public static final String KEY_IS_PV = "is_pv";
    public static final String KEY_IS_SUB_PB = "is_sub_pb";
    public static final String KEY_IS_TOP = "is_top";
    public static final String KEY_LOCATE = "locate";
    public static final String KEY_MANGA_NEXT_CHAPTER = "key_manga_next_chapter";
    public static final String KEY_MANGA_PREV_CHAPTER = "key_manga_prev_chapter";
    public static final String KEY_MANGA_TITLE = "key_manga_title";
    public static final String KEY_MARK = "mark";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_MSG_OP_STAT = "op_stat";
    public static final String KEY_MSG_OP_TYPE = "op_type";
    public static final String KEY_MSG_OP_URL = "op_url";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_SQUENCE = "squence";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_THREAD_TIME = "thread_time";
    public static final String KEY_THREAD_TYPE = "thread_type";
    public static final String KYE_IS_START_FOR_RESULT = "is_start_for_result";
    public static final String PRAISE_DATA = "praise_data";
    public static final String QUERY_WORD = "query_word";
    public static final String START_FOR_RESULT = "1";
    public static final int THREAD_TYPE_NOT_SHOW_IS_TOP = 0;
    public static final int THREAD_TYPE_SHOW_IS_TOP = 1;
    public static final boolean isBottomHaveShared = true;
    private final Context mContext;

    public PbActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    public PbActivityConfig createCfgForPersonCenter(String str, String str2, String str3, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("from_frs", true);
            intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
            intent.putExtra("request_code", i);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
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
        }
        return this;
    }

    public PbActivityConfig createNormalCfg(String str, String str2, int i, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("thread_type", i);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public PbActivityConfig createCfgForPbChosen(String str, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra(PRAISE_DATA, i);
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || FROM_SEARCHBOX.equals(str4)) {
                intent.addFlags(268435456);
            }
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
            intent.putExtra(QUERY_WORD, str5);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity) || "from_baidu_searchbox".equals(str4)) {
                intent.addFlags(268435456);
            }
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
            intent.putExtra(KEY_MSG_ID, j);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (str4 != null) {
                intent.putExtra(KEY_MSG_OP_URL, str4);
            }
            if (str5 != null) {
                intent.putExtra(KEY_MSG_OP_STAT, str5);
            }
            if (str6 != null) {
                intent.putExtra(KEY_MSG_OP_TYPE, str6);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public PbActivityConfig createSubPbCfg(String str, String str2, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra(KEY_IS_SUB_PB, true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public PbActivityConfig createMarkCfg(String str, String str2, boolean z, boolean z2, String str3, int i) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra(KEY_HOST_ONLY, z);
        intent.putExtra(KEY_SQUENCE, z2);
        intent.putExtra("st_type", str3);
        intent.putExtra("from_mark", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
        intent.putExtra("request_code", i);
        return this;
    }

    public PbActivityConfig createHistoryCfg(String str, String str2, boolean z, boolean z2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra(KEY_HOST_ONLY, z);
        intent.putExtra(KEY_SQUENCE, z2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public PbActivityConfig createReaderServiceCfg(String str, String str2, int i, boolean z, boolean z2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("thread_id", str);
        intent.putExtra("post_id", str2);
        intent.putExtra(KEY_HOST_ONLY, z);
        intent.putExtra(KEY_SQUENCE, z2);
        intent.putExtra("st_type", str3);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(FROM_READER_SERVICE, true);
        return this;
    }

    public PbActivityConfig createFromThreadCfg(as asVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (asVar != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", asVar.getId());
            intent.putExtra(KEY_IS_GOOD, asVar.getIs_good());
            intent.putExtra(KEY_IS_TOP, asVar.getIs_top());
            intent.putExtra(KEY_THREAD_TIME, asVar.getLast_time_int());
            intent.putExtra("st_type", str2);
            intent.putExtra("from_frs", asVar.getIs_top() != 2);
            intent.putExtra(KEY_SQUENCE, z);
            intent.putExtra(KEY_HOST_ONLY, z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("forum_name", str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
            intent.putExtra("request_code", i);
            intent.putExtra(KEY_IS_FROM_THREAD_CONFIG, true);
            intent.putExtra(KEY_INTENT_EXTRA_PB_CACHE_KEY, "zan=" + (asVar.getPraise() == null ? 0L : asVar.getPraise().getNum()));
            if (asVar.getAuthor() != null && asVar.getAuthor().getGodUserData().getId() != null) {
                intent.putExtra(KEY_INTENT_EXTRA_PB_FUNS_COUNT_KEY, asVar.getAuthor().getFansNum());
                intent.putExtra(KEY_INTENT_EXTRA_PB_IS_FOLLOWED_KEY, asVar.getAuthor().getGodUserData().getFollowed());
            }
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

    public PbActivityConfig addFrom(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("from", str);
        }
        return this;
    }

    public PbActivityConfig disablePbKeyPostId() {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_PB_KEY_NEED_POSTID, true);
        }
        return this;
    }

    public PbActivityConfig putMangaPrevChapterId(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_MANGA_PREV_CHAPTER, i);
        }
        return this;
    }

    public PbActivityConfig putMangaNextChapterId(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_MANGA_NEXT_CHAPTER, i);
        }
        return this;
    }

    public PbActivityConfig putMangaTitle(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_MANGA_TITLE, str);
        }
        return this;
    }
}
