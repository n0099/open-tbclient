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

    public as a(com.baidu.tbadk.core.data.o oVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (oVar != null) {
            Intent intent = getIntent();
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, oVar.k());
            intent.putExtra("is_good", oVar.q());
            intent.putExtra("is_top", oVar.p());
            intent.putExtra("thread_time", oVar.o());
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, str2);
            intent.putExtra("from_frs", oVar.p() != 2);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, str);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra("is_start_for_result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            intent.putExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, i);
            intent.putExtra("extra_pb_cache_key", "zan=" + (oVar.j() == null ? 0L : oVar.j().getNum()));
        }
        return this;
    }
}
