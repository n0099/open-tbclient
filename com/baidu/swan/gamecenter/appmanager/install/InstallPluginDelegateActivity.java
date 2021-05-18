package com.baidu.swan.gamecenter.appmanager.install;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallPluginDelegateActivity extends PluginDelegateActivity {
    public static final String INSTALL_ERROR_CODE = "install_error";
    public static final int INSTALL_REQUEST_CODE = 1245421;
    public int mErrorCode = 31003;

    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity
    public void exit(int i2, String str) {
        Bundle bundle;
        Intent intent = new Intent();
        intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
        intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i2);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
        }
        ActivityDelegation activityDelegation = this.mDelegation;
        if (activityDelegation != null && (bundle = activityDelegation.mResult) != null) {
            bundle.putInt(INSTALL_ERROR_CODE, this.mErrorCode);
            intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
        }
        setResult(-1, intent);
        finish();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1245421) {
            if (i3 == -1) {
                this.mErrorCode = 31021;
            } else if (i3 == 1) {
                this.mErrorCode = 31022;
                if (intent != null) {
                    this.mErrorCode = intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022);
                }
            }
        }
    }
}
