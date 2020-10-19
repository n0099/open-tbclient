package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes8.dex */
public class b extends ActivityDelegation implements com.baidu.swan.apps.ap.e.b<Bundle> {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        boolean c = com.baidu.swan.apps.ap.u.c(this.mParams, "isRealName", false);
        String safeGetString = com.baidu.swan.apps.ap.u.safeGetString(this.mParams, "swanAppId");
        if (c) {
            a.a(getAgent(), safeGetString, this);
        } else {
            a.b(getAgent(), safeGetString, this);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ap.e.b
    /* renamed from: B */
    public void M(Bundle bundle) {
        this.mResult.putBundle("result", bundle);
        finish();
    }
}
