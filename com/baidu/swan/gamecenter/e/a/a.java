package com.baidu.swan.gamecenter.e.a;

import android.util.Log;
import com.baidu.swan.apps.aq.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("startPermissionsPage");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        e arw = e.arw();
        if (arw != null && arw.arp() != null) {
            x.cr(arw.arp());
            bVar.aj(null);
        } else if (DEBUG) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
