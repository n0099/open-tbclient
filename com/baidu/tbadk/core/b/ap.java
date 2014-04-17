package com.baidu.tbadk.core.b;

import android.content.Context;
/* loaded from: classes.dex */
public class ap extends com.baidu.tbadk.core.frameworkData.a {
    public ap(Context context, int i) {
        super(context);
        d().putExtra("showBack", true);
        d().putExtra("NotifiIdKey", i);
        d().addFlags(268435456);
        ab.a = true;
        ab.b = i;
    }
}
