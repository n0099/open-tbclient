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
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.x.a.a> implements a.InterfaceC0232a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.swan.apps.x.b bpR;
    private com.baidu.swan.apps.x.a.a bpS;

    public static a Vh() {
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
        this.bpR = bVar;
        this.bpS = aVar;
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.a.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                a.this.Vi();
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
    public void Vi() {
        com.baidu.swan.impl.map.location.a B = com.baidu.swan.impl.map.location.a.B(null);
        B.a(this);
        B.UO();
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0232a
    public void onCancel() {
        c.i("map", "choose location cancel");
        if (this.bpR != null && this.bpS != null) {
            this.bpR.d(this.bpS.callBack, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0232a
    public void onError() {
        c.i("map", "choose location fail");
        if (this.bpR != null && this.bpS != null) {
            this.bpR.d(this.bpS.callBack, PointerIconCompat.TYPE_CROSSHAIR, "choose location failed");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0232a
    public void a(SelectedLocationInfo selectedLocationInfo) {
        if (this.bpR != null && this.bpS != null) {
            this.bpR.e(this.bpS.callBack, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.x.a.a aVar, com.baidu.swan.apps.x.b bVar, com.baidu.swan.apps.ae.b bVar2, JSONObject jSONObject) {
        return a(context, aVar, bVar, bVar2);
    }
}
