package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes25.dex */
public class w implements com.baidu.swan.apps.adaptation.a.e {
    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public boolean bU(Context context) {
        return a.dD(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bV(Context context) {
        return a.dF(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bW(@NonNull Context context) {
        return a.dG(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bX(@NonNull Context context) {
        return a.dE(context);
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
