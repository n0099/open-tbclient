package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.core.frameworkData.a {
    public static String a = "has_shown_frs_guide";

    public r(Context context) {
        super(context);
    }

    public r a(String str, String str2) {
        return a(str, str2, false, false);
    }

    public r b(String str, String str2) {
        return a(str, str2, false, true);
    }

    public r a(String str, String str2, boolean z, boolean z2) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str2);
        intent.putExtra("back_special", z);
        intent.putExtra("good", z2);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public r a(String str, String str2, int i) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str2);
        intent.putExtra("flag", i);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public r c(String str, String str2) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        intent.putExtra("refresh_all", true);
        intent.putExtra("content_show", true);
        intent.putExtra("name", str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str2);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public r b(String str, String str2, int i) {
        Intent intent = getIntent();
        intent.addFlags(268435456);
        intent.putExtra("name", str);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FROM, str2);
        intent.putExtra("add_search", i);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }
}
