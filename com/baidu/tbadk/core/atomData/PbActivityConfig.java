package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class PbActivityConfig extends a {
    public static final int ACTIVITY_RESULT_DELETE = 1;
    public static final String KEY_FORUM_NAME = "forum_name";
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_HOST_ONLY = "host_only";
    public static final String KEY_INTENT_EXTRA_PB_CACHE_KEY = "extra_pb_cache_key";
    public static final String KEY_INTENT_GOOD_DATA = "good_data";
    public static final String KEY_INTENT_TID = "tid";
    public static final String KEY_INTENT_TOP_DATA = "top_data";
    public static final String KEY_INTENT_TYPE = "type";
    public static final String KEY_IS_AD = "is_ad";
    public static final String KEY_IS_GOOD = "is_good";
    public static final String KEY_IS_PV = "is_pv";
    public static final String KEY_IS_SUB_PB = "is_sub_pb";
    public static final String KEY_IS_TOP = "is_top";
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
    public static final String KYE_IS_START_FOR_RESULT = "is_start_for_result";
    public static final String START_FOR_RESULT = "1";
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
            intent.putExtra(KEY_FROM_FRS, true);
            intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
            intent.putExtra(a.REQUEST_CODE, i);
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
        intent.putExtra(KEY_FROM_MARK, true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
        intent.putExtra(a.REQUEST_CODE, i);
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

    public PbActivityConfig createFromThreadCfg(w wVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (wVar != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", wVar.getId());
            intent.putExtra(KEY_IS_GOOD, wVar.getIs_good());
            intent.putExtra(KEY_IS_TOP, wVar.getIs_top());
            intent.putExtra(KEY_THREAD_TIME, wVar.getLast_time_int());
            intent.putExtra("st_type", str2);
            intent.putExtra(KEY_FROM_FRS, wVar.getIs_top() != 2);
            intent.putExtra(KEY_SQUENCE, z);
            intent.putExtra(KEY_HOST_ONLY, z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("forum_name", str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(KYE_IS_START_FOR_RESULT, "1");
            intent.putExtra(a.REQUEST_CODE, i);
            intent.putExtra(KEY_INTENT_EXTRA_PB_CACHE_KEY, "zan=" + (wVar.getPraise() == null ? 0L : wVar.getPraise().getNum()));
        }
        return this;
    }
}
