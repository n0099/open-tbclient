package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class cd extends com.baidu.tbadk.core.frameworkData.a {
    public cd(Context context, WriteData writeData, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        if (writeData != null) {
            getIntent().putExtra("model", writeData);
        }
    }
}
