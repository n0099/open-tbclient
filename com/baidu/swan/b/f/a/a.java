package com.baidu.swan.b.f.a;

import android.util.Log;
import com.baidu.swan.apps.aq.w;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.b.d.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("startPermissionsPage");
    }

    @Override // com.baidu.swan.b.d.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        e apN = e.apN();
        if (apN != null && apN.apG() != null) {
            w.cp(apN.apG());
            bVar.ah(null);
        } else if (DEBUG) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
