package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class aa extends com.baidu.tbadk.core.frameworkData.a {
    public aa(Context context) {
        super(context);
    }

    public final aa a(int i, boolean z) {
        Intent d = d();
        d.setFlags(603979776);
        if (!(c() instanceof Activity)) {
            d.addFlags(268435456);
        }
        if (i >= 0) {
            d.putExtra("locate_type", i);
        }
        d.putExtra("is_new_user", z);
        d.putExtra("close_dialog", true);
        return this;
    }
}
