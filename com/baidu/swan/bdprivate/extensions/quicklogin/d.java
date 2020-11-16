package com.baidu.swan.bdprivate.extensions.quicklogin;

import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes7.dex */
public class d extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        f.b(getAgent(), u.a(this.mParams, "quick_login_mode", 0), new e() { // from class: com.baidu.swan.bdprivate.extensions.quicklogin.d.1
            @Override // com.baidu.swan.bdprivate.extensions.quicklogin.e
            public void onResult(int i) {
                d.this.mResult.putInt("quick_login", i);
                d.this.finish();
            }
        });
        return false;
    }
}
