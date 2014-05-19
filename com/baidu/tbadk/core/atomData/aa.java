package com.baidu.tbadk.core.atomData;

import android.content.Context;
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.core.frameworkData.a {
    public aa(Context context, int[] iArr) {
        super(context);
        getIntent().putExtra("timeouts", iArr);
    }
}
