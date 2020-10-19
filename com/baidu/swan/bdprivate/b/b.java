package com.baidu.swan.bdprivate.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.swan.apps.adaptation.a.o;
/* loaded from: classes8.dex */
public class b implements o {
    private static final String TAG = b.class.getSimpleName();

    @Override // com.baidu.swan.apps.adaptation.a.o
    public void a(Context context, String str, String str2, com.baidu.swan.apps.b.a.b bVar) {
        if (bVar != null) {
            if (!(context instanceof Activity)) {
                bVar.gV(0);
            } else {
                com.baidu.swan.bdprivate.a.a.a((Activity) context, bVar);
            }
        }
    }
}
