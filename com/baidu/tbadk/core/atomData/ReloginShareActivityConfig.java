package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class ReloginShareActivityConfig extends a {
    public int mGotoType;
    public n mRawData;

    public ReloginShareActivityConfig(Context context, n nVar, int i) {
        super(context);
        this.mGotoType = i;
        this.mRawData = nVar;
    }
}
