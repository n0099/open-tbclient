package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class ReloginShareActivityConfig extends a {
    public int mGotoType;
    public o mRawData;

    public ReloginShareActivityConfig(Context context, o oVar, int i) {
        super(context);
        this.mGotoType = i;
        this.mRawData = oVar;
    }
}
