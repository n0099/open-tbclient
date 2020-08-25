package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes2.dex */
public class VcodeActivityConfig extends IntentConfig {
    public static final String SAVE_KEY = "model";

    public VcodeActivityConfig(Context context, WriteData writeData, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        if (writeData != null) {
            getIntent().putExtra("model", writeData);
        }
    }
}
