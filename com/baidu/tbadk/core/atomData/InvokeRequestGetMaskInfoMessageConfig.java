package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InvokeRequestGetMaskInfoMessageConfig extends a {
    public InvokeRequestGetMaskInfoMessageConfig(Context context, int i) {
        super(context);
        getIntent().putExtra(a.MASK_TYPE, i);
    }
}
