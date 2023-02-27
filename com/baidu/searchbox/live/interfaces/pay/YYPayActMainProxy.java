package com.baidu.searchbox.live.interfaces.pay;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
/* loaded from: classes2.dex */
public class YYPayActMainProxy extends ProcessDelegateBaseActivity {
    public static final String EXTRA_RESULT = "yy_pay_result";
    public static final int REQUEST_CODE = 100;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (this.mDelegation != null && intent != null && !TextUtils.isEmpty(intent.getStringExtra(EXTRA_RESULT))) {
                this.mDelegation.mResult.putString(EXTRA_RESULT, intent.getStringExtra(EXTRA_RESULT));
            }
            exit();
        }
    }
}
