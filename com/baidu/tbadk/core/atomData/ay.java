package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ay extends com.baidu.tbadk.core.frameworkData.a {
    public ay(Context context, int i, WriteData writeData, boolean z) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        if (writeData != null) {
            getIntent().putExtra("model", writeData);
            getIntent().putExtra("is_ad", z);
        }
    }
}
