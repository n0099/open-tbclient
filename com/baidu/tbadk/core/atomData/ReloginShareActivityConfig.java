package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class ReloginShareActivityConfig extends a {
    public int mGotoType;
    public k mRawData;

    public ReloginShareActivityConfig(Context context, k kVar, int i) {
        super(context);
        this.mGotoType = i;
        this.mRawData = kVar;
    }
}
