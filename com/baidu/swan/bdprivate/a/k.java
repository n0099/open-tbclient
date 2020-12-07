package com.baidu.swan.bdprivate.a;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes25.dex */
public class k extends ActivityDelegation implements com.baidu.swan.apps.a.a {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        if (!this.mParams.getBoolean("key_login_force", false) && a.isLogin(getAgent())) {
            this.mResult.putInt("result_code", 0);
            finish();
            return true;
        }
        a.a(getAgent(), this.mParams.getBundle("key_login_params"), this);
        return false;
    }

    @Override // com.baidu.swan.apps.a.a
    public void onResult(int i) {
        this.mResult.putInt("result_code", i);
        finish();
    }
}
