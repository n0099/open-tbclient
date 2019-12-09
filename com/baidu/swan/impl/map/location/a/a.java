package com.baidu.swan.impl.map.location.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.impl.map.a.b.d;
import com.baidu.swan.impl.map.location.a;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.a> implements a.InterfaceC0259a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.swan.apps.x.b bHM;
    private com.baidu.swan.apps.x.a.a bHN;

    public static a ZU() {
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
        this.bHM = bVar;
        this.bHN = aVar;
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.a.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                a.this.ZV();
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                bVar.f(str, 1003, "location permission fail");
            }
        });
        c.i("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZV() {
        com.baidu.swan.impl.map.location.a B = com.baidu.swan.impl.map.location.a.B(null);
        B.a(this);
        B.ZB();
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0259a
    public void onCancel() {
        c.i("map", "choose location cancel");
        if (this.bHM != null && this.bHN != null) {
            this.bHM.f(this.bHN.callBack, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0259a
    public void onError() {
        c.i("map", "choose location fail");
        if (this.bHM != null && this.bHN != null) {
            this.bHM.f(this.bHN.callBack, 1007, "choose location failed");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0259a
    public void a(SelectedLocationInfo selectedLocationInfo) {
        if (this.bHM != null && this.bHN != null) {
            this.bHM.e(this.bHN.callBack, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return a(context, aVar, bVar, bVar2);
    }
}
