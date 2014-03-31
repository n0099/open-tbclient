package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class ad extends com.baidu.tbadk.core.frameworkData.a {
    public static String a = "from_page";
    public static String b = "from_account";
    public static String c = "form_logo";

    public ad(Context context, String str) {
        super(context);
        d().putExtra(a, str);
    }
}
