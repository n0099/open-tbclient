package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bx extends com.baidu.tbadk.core.frameworkData.a {
    public bx(Context context) {
        super(context);
    }

    public bx(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
