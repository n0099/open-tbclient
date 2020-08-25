package com.baidu.swan.gamecenter.e.a;

import android.util.Log;
import com.baidu.swan.apps.ap.y;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.gamecenter.c.a {
    public static final boolean DEBUG = b.DEBUG;

    public a() {
        super("startPermissionsPage");
    }

    @Override // com.baidu.swan.gamecenter.c.a
    public com.baidu.swan.apps.api.c.b b(JSONObject jSONObject, com.baidu.swan.apps.o.b bVar) {
        e azJ = e.azJ();
        if (azJ != null && azJ.azC() != null) {
            y.cy(azJ.azC());
            bVar.al(null);
        } else if (DEBUG) {
            Log.d("StartPermissionsPage", "swan or activity is null");
        }
        return null;
    }
}
