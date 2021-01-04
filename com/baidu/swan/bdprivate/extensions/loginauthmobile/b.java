package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes9.dex */
public class b extends ActivityDelegation implements com.baidu.swan.apps.a.a {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        Intent intent = new Intent(getAgent(), LoginAndGetMobileActivity.class);
        intent.putExtras(this.mParams);
        getAgent().startActivity(intent);
        getAgent().overridePendingTransition(b.a.login_get_mobile_act_enter, 0);
        c.g(this);
        return false;
    }

    @Override // com.baidu.swan.apps.a.a
    public void onResult(int i) {
        this.mResult.putInt("loginStatusCode", i);
        aTh();
    }

    private void aTh() {
        c.release();
        finish();
    }
}
