package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class InvokeRequestUpdateMaskInfoEncodeMessageConfig extends a {
    public InvokeRequestUpdateMaskInfoEncodeMessageConfig(Context context, int i, int i2, String str) {
        super(context);
        getIntent().putExtra(a.MASK_TYPE, i);
        getIntent().putExtra(a.IS_MASK, i2);
        getIntent().putExtra(a.LIST, str);
    }
}
