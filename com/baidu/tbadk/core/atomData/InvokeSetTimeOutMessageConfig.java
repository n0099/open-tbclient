package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InvokeSetTimeOutMessageConfig extends a {
    public InvokeSetTimeOutMessageConfig(Context context, int[] iArr) {
        super(context);
        getIntent().putExtra("timeouts", iArr);
    }
}
