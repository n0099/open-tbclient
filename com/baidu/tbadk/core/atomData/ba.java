package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class ba extends com.baidu.tbadk.core.frameworkData.a {
    public ba(Context context, int i) {
        super(context);
        getIntent().putExtra("showBack", true);
        getIntent().putExtra("NotifiIdKey", i);
        getIntent().addFlags(268435456);
        al.a = true;
        al.b = i;
    }
}
