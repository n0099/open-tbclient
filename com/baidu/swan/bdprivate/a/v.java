package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class v implements com.baidu.swan.apps.adaptation.a.e {
    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public boolean bd(Context context) {
        return a.cM(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String be(Context context) {
        return a.cO(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bf(@NonNull Context context) {
        return a.cP(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bg(@NonNull Context context) {
        return a.cN(context);
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
