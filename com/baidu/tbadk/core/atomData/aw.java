package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aw extends com.baidu.tbadk.core.frameworkData.a {
    private final Context a;

    public aw(Context context) {
        super(context);
        this.a = context;
    }

    public aw a(String str, String str2, String str3, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
            intent.putExtra("from_frs", true);
            intent.putExtra("is_start_for_result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public aw a(String str, String str2, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public aw a(String str, String str2, String str3, long j) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
            intent.putExtra("is_pv", true);
            intent.putExtra("msg_id", j);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public aw b(String str, String str2, String str3) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
            intent.putExtra("is_sub_pb", true);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    public aw a(String str, String str2, boolean z, boolean z2, String str3, int i) {
        Intent intent = getIntent();
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.POST_ID, str2);
        intent.putExtra("host_only", z);
        intent.putExtra("squence", z2);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str3);
        intent.putExtra("from_mark", true);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        intent.putExtra("is_start_for_result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
        return this;
    }

    public aw a(com.baidu.tbadk.core.data.m mVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (mVar != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, mVar.p());
            intent.putExtra("is_good", mVar.v());
            intent.putExtra("is_top", mVar.u());
            intent.putExtra("thread_time", mVar.t());
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
            intent.putExtra("from_frs", mVar.u() != 2);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
            intent.putExtra("extra_pb_cache_key", "zan=" + (mVar.o() == null ? 0L : mVar.o().getNum()));
        }
        return this;
    }
}
