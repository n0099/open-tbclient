package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class au extends com.baidu.tbadk.core.frameworkData.a {
    public static String a = "from_page";
    public static String b = "from_account";
    public static String c = "form_logo";
    public static String d = "from_hao123";

    public au(Context context, String str) {
        super(context);
        getIntent().putExtra(a, str);
    }
}
