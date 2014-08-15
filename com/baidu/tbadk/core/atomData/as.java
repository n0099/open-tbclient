package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class as extends com.baidu.tbadk.core.frameworkData.a {
    public as(Context context) {
        super(context);
    }

    public as a(int i) {
        return a(i, false);
    }

    public as a(int i, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        intent.putExtra("is_new_user", z);
        intent.putExtra("close_dialog", true);
        return this;
    }

    public as b(int i, boolean z) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        intent.putExtra("refresh_all", true);
        if (i >= 0) {
            intent.putExtra("locate_type", i);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        intent.putExtra("close_dialog", true);
        return this;
    }
}
