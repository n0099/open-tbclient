package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.swan.apps.al.a.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mh(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                final k kVar = new k("accelerometerChange", jSONObject, str2);
                com.baidu.swan.apps.al.a.a aNI = com.baidu.swan.apps.al.a.a.aNI();
                aNI.v(a.this.getContext(), C0411a.mi(jSONObject.optString("interval")));
                aNI.a(new a.InterfaceC0385a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.al.a.a.InterfaceC0385a
                    public void b(double[] dArr) {
                        if (dArr == null || dArr.length != 3) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "illegal accelerometers");
                            a.this.a(str2, new com.baidu.swan.apps.api.c.b(1001));
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("x", dArr[0]);
                            jSONObject2.put("y", dArr[1]);
                            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, dArr[2]);
                            kVar.a(a.this, jSONObject2);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "handle compass,json error，" + e.toString());
                            kVar.a(a.this, "Json error");
                        }
                    }
                });
                aNI.aNJ();
                kVar.a(a.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b amw() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.al.a.a.aNI().aNK();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0411a {
        private static ArrayMap<String, Integer> cFB = new ArrayMap<>(3);

        static {
            cFB.put("ui", 60);
            cFB.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            cFB.put("normal", 200);
        }

        public static int mi(String str) {
            Integer num = cFB.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
