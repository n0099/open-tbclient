package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.core.frameworkData.a {
    public static String a = com.baidu.tbadk.core.frameworkData.a.ST_TYPE;

    public j(Context context, String str) {
        super(context);
        getIntent().putExtra(a, str);
    }
}
