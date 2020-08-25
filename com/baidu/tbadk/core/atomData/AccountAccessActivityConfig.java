package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes2.dex */
public class AccountAccessActivityConfig extends IntentConfig {
    public static final String KEY_ACCESS_STATE = "access_state";
    public static final String KEY_WRITE_DATA = "write_data";

    public AccountAccessActivityConfig(Context context, int i, WriteData writeData, AccessState accessState) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        if (accessState != null && writeData != null) {
            getIntent().putExtra(KEY_WRITE_DATA, writeData);
            getIntent().putExtra(KEY_ACCESS_STATE, accessState);
        }
    }
}
