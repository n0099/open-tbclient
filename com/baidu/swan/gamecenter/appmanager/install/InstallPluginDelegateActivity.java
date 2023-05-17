package com.baidu.swan.gamecenter.appmanager.install;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class InstallPluginDelegateActivity extends PluginDelegateActivity {
    public int a = 31003;

    public int a() {
        return this.a;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity
    public void exit(int i, String str) {
        Bundle bundle;
        Intent intent = new Intent();
        intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
        intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
        }
        ActivityDelegation activityDelegation = this.mDelegation;
        if (activityDelegation != null && (bundle = activityDelegation.mResult) != null) {
            bundle.putInt("install_error", this.a);
            intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
        }
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1245421) {
            if (i2 == -1) {
                this.a = 31021;
            } else if (i2 == 1) {
                this.a = 31022;
                if (intent != null) {
                    this.a = intent.getIntExtra("android.intent.extra.INSTALL_RESULT", 31022);
                }
            }
        }
    }
}
