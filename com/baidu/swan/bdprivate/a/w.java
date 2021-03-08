package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class w implements com.baidu.swan.apps.adaptation.a.e {
    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public boolean bY(Context context) {
        return a.dT(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bZ(Context context) {
        return a.dV(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String ca(@NonNull Context context) {
        return a.dW(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String cb(@NonNull Context context) {
        return a.dU(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(com.baidu.swan.apps.a.c cVar) {
        a.a(cVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public void b(com.baidu.swan.apps.a.a aVar) {
        new com.baidu.swan.bdprivate.extensions.loginauthmobile.a().c(aVar);
    }
}
