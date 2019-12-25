package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes9.dex */
public class b extends ActivityDelegation implements com.baidu.swan.apps.as.d.b<Bundle> {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        boolean c = com.baidu.swan.apps.as.r.c(this.mParams, "isRealName", false);
        String safeGetString = com.baidu.swan.apps.as.r.safeGetString(this.mParams, "swanAppId");
        if (c) {
            a.a(getAgent(), safeGetString, this);
        } else {
            a.b(getAgent(), safeGetString, this);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.as.d.b
    /* renamed from: z */
    public void B(Bundle bundle) {
        this.mResult.putBundle("result", bundle);
        finish();
    }
}
