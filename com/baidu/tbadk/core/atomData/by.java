package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class by extends com.baidu.tbadk.core.frameworkData.a {
    public by(Context context) {
        super(context);
    }

    public by(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("start_from", str);
        getIntent().putExtra("back_special", z);
    }
}
