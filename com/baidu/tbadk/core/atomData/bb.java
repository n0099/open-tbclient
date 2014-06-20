package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bb extends com.baidu.tbadk.core.frameworkData.a {
    public bb(Context context) {
        super(context);
    }

    public bb(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
