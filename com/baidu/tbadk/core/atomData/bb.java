package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bb extends com.baidu.tbadk.core.frameworkData.a {
    public bb(Context context, int i) {
        super(context);
        getIntent().putExtra("showBack", true);
        getIntent().putExtra("NotifiIdKey", i);
        getIntent().addFlags(268435456);
        am.a = true;
        am.b = i;
    }
}
