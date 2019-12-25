package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class v implements com.baidu.swan.apps.adaptation.a.e {
    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(Activity activity, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        a.a(activity, false, bundle, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public boolean bl(Context context) {
        return a.cN(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bm(Context context) {
        return a.cP(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bn(@NonNull Context context) {
        return a.cQ(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bo(@NonNull Context context) {
        return a.cO(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(com.baidu.swan.apps.a.c cVar) {
        a.a(cVar);
    }
}
