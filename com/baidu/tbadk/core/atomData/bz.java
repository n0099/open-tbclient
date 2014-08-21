package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class bz extends com.baidu.tbadk.core.frameworkData.a {
    public bz(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
