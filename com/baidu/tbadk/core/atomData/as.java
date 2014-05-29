package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class as extends com.baidu.tbadk.core.frameworkData.a {
    private final Context a;

    public as(Context context) {
        super(context);
        this.a = context;
    }

    public as a(String str, String str2, String str3, int i) {
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

    public as a(String str, String str2, String str3) {
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

    public as a(String str, String str2, String str3, long j) {
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

    public as b(String str, String str2, String str3) {
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

    public as a(String str, String str2, boolean z, boolean z2, String str3, int i) {
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

    public as a(com.baidu.tbadk.core.data.n nVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (nVar != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, nVar.p());
            intent.putExtra("is_good", nVar.v());
            intent.putExtra("is_top", nVar.u());
            intent.putExtra("thread_time", nVar.t());
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
            intent.putExtra("from_frs", nVar.u() != 2);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
            intent.putExtra("extra_pb_cache_key", "zan=" + (nVar.o() == null ? 0L : nVar.o().getNum()));
        }
        return this;
    }
}
