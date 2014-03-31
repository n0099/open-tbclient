package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class af extends com.baidu.tbadk.core.frameworkData.a {
    private final Context a;

    public af(Context context) {
        super(context);
        this.a = context;
    }

    public final af a(String str, String str2, String str3) {
        if (str != null) {
            Intent d = d();
            d.putExtra("thread_id", str);
            d.putExtra("post_id", str2);
            d.putExtra("st_type", str3);
            d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                d.addFlags(268435456);
            }
        }
        return this;
    }

    public final af a(String str, String str2, String str3, long j) {
        if (str != null) {
            Intent d = d();
            d.putExtra("thread_id", str);
            d.putExtra("post_id", (String) null);
            d.putExtra("st_type", str3);
            d.putExtra("is_pv", true);
            d.putExtra("msg_id", j);
            d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                d.addFlags(268435456);
            }
        }
        return this;
    }

    public final af b(String str, String str2, String str3) {
        if (str != null) {
            Intent d = d();
            d.putExtra("thread_id", str);
            d.putExtra("post_id", str2);
            d.putExtra("st_type", str3);
            d.putExtra("is_sub_pb", true);
            d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (!(this.a instanceof Activity)) {
                d.addFlags(268435456);
            }
        }
        return this;
    }

    public final af a(com.baidu.tbadk.core.data.o oVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (oVar != null) {
            Intent d = d();
            d.putExtra("thread_id", oVar.l());
            d.putExtra("is_good", oVar.r());
            d.putExtra("is_top", oVar.q());
            d.putExtra("thread_time", oVar.p());
            d.putExtra("st_type", (String) null);
            d.putExtra("from_frs", true);
            d.putExtra("squence", z);
            d.putExtra("host_only", z2);
            d.putExtra("is_ad", z3);
            d.putExtra("forum_name", str);
            d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            d.putExtra("is_start_for_result", "1");
            d.putExtra("request_code", 18003);
        }
        return this;
    }
}
