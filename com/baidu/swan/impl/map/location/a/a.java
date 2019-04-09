package com.baidu.swan.impl.map.location.a;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.impl.map.a.b.d;
import com.baidu.swan.impl.map.location.a;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.a> implements a.InterfaceC0207a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.swan.apps.x.b biD;
    private com.baidu.swan.apps.x.a.a biE;

    public static a Qz() {
        return new a();
    }

    private boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, final com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2) {
        c.i("map", "ChooseLocationAction start");
        if (!aVar.isValid()) {
            c.e("map", "model is invalid");
            return false;
        }
        final String str = aVar.callBack;
        if (TextUtils.isEmpty(str)) {
            c.e("map", "cb is empty");
            return false;
        }
        this.biD = bVar;
        this.biE = aVar;
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.a.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                a.this.QA();
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                bVar.d(str, 1003, "location permission fail");
            }
        });
        c.i("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QA() {
        com.baidu.swan.impl.map.location.a A = com.baidu.swan.impl.map.location.a.A(null);
        A.a(this);
        A.Qg();
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0207a
    public void onCancel() {
        c.i("map", "choose location cancel");
        if (this.biD != null && this.biE != null) {
            this.biD.d(this.biE.callBack, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0207a
    public void onError() {
        c.i("map", "choose location fail");
        if (this.biD != null && this.biE != null) {
            this.biD.d(this.biE.callBack, PointerIconCompat.TYPE_CROSSHAIR, "choose location failed");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0207a
    public void a(SelectedLocationInfo selectedLocationInfo) {
        if (this.biD != null && this.biE != null) {
            this.biD.e(this.biE.callBack, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return a(context, aVar, bVar, bVar2);
    }
}
