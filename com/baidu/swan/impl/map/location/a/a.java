package com.baidu.swan.impl.map.location.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.impl.map.a.b.d;
import com.baidu.swan.impl.map.location.a;
import com.baidu.swan.impl.map.location.model.SelectedLocationInfo;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.impl.map.a.a<com.baidu.swan.apps.w.a.a> implements a.InterfaceC0563a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private com.baidu.swan.apps.w.b eka;
    private com.baidu.swan.apps.w.a.a ekb;

    public static a bcr() {
        return new a();
    }

    private boolean a(Context context, com.baidu.swan.apps.w.a.a aVar, final com.baidu.swan.apps.w.b bVar, e eVar) {
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
        this.eka = bVar;
        this.ekb = aVar;
        d.a(context, new d.a() { // from class: com.baidu.swan.impl.map.location.a.a.1
            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onSuccess() {
                c.w("map", "location permission success");
                a.this.bcs();
            }

            @Override // com.baidu.swan.impl.map.a.b.d.a
            public void onFail() {
                c.w("map", "location permission fail");
                bVar.j(str, 1003, "location permission fail");
            }
        });
        c.i("map", "ChooseLocationAction end");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcs() {
        com.baidu.swan.impl.map.location.a aa = com.baidu.swan.impl.map.location.a.aa(null);
        aa.a(this);
        aa.bbY();
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0563a
    public void onCancel() {
        c.i("map", "choose location cancel");
        if (this.eka != null && this.ekb != null) {
            this.eka.j(this.ekb.callBack, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0563a
    public void onError() {
        c.i("map", "choose location fail");
        if (this.eka != null && this.ekb != null) {
            this.eka.j(this.ekb.callBack, 1007, "choose location failed");
        }
    }

    @Override // com.baidu.swan.impl.map.location.a.InterfaceC0563a
    public void a(SelectedLocationInfo selectedLocationInfo) {
        if (this.eka != null && this.ekb != null) {
            this.eka.f(this.ekb.callBack, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.impl.map.a.a
    public boolean a(Context context, com.baidu.swan.apps.w.a.a aVar, com.baidu.swan.apps.w.b bVar, e eVar, JSONObject jSONObject) {
        return a(context, aVar, bVar, eVar);
    }
}
