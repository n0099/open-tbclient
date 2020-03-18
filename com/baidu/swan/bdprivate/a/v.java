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
    public boolean bo(Context context) {
        return a.cQ(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bp(Context context) {
        return a.cS(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String bq(@NonNull Context context) {
        return a.cT(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public String br(@NonNull Context context) {
        return a.cR(context);
    }

    @Override // com.baidu.swan.apps.adaptation.a.e
    public void a(com.baidu.swan.apps.a.c cVar) {
        a.a(cVar);
    }
}
