package com.baidu.swan.bdprivate.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes8.dex */
public class b extends ActivityDelegation implements com.baidu.swan.apps.ao.e.b<Bundle> {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        boolean c = com.baidu.swan.apps.ao.u.c(this.mParams, "isRealName", false);
        String h = com.baidu.swan.apps.ao.u.h(this.mParams, "swanAppId");
        if (c) {
            a.a(getAgent(), h, this);
        } else {
            a.b(getAgent(), h, this);
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.ao.e.b
    /* renamed from: B */
    public void L(Bundle bundle) {
        this.mResult.putBundle("result", bundle);
        finish();
    }
}
