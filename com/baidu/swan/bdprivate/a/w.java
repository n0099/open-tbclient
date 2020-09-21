package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class w implements com.baidu.swan.apps.adaptation.a.e {
    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public boolean bi(Context context) {
        return a.cR(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bj(Context context) {
        return a.cT(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bk(@NonNull Context context) {
        return a.cU(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bl(@NonNull Context context) {
        return a.cS(context);
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
