package com.baidu.tbadk.core.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
public final class l extends com.baidu.tbadk.core.frameworkData.a {
    public static String a = "has_shown_frs_guide";

    public l(Context context) {
        super(context);
    }

    public final l a(String str, String str2) {
        return a(str, str2, false, false);
    }

    public final l b(String str, String str2) {
        return a(str, null, false, true);
    }

    private l a(String str, String str2, boolean z, boolean z2) {
        Intent d = d();
        d.putExtra(PersonInfoActivity.TAG_NAME, str);
        d.putExtra("from", str2);
        d.putExtra("back_special", false);
        d.putExtra("good", z2);
        if (!(c() instanceof Activity)) {
            d.addFlags(268435456);
        }
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public final l a(String str, String str2, int i) {
        Intent d = d();
        d.putExtra(PersonInfoActivity.TAG_NAME, str);
        d.putExtra("from", str2);
        d.putExtra("flag", 1);
        if (!(c() instanceof Activity)) {
            d.addFlags(268435456);
        }
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public final l b(String str, String str2, int i) {
        Intent d = d();
        d.addFlags(268435456);
        d.putExtra(PersonInfoActivity.TAG_NAME, str);
        d.putExtra("from", (String) null);
        d.putExtra("add_search", 0);
        d.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }
}
