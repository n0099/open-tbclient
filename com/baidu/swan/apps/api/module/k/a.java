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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jS(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                final k kVar = new k("accelerometerChange", jSONObject, str2);
                com.baidu.swan.apps.al.a.a aDw = com.baidu.swan.apps.al.a.a.aDw();
                aDw.m(a.this.getContext(), C0363a.jT(jSONObject.optString("interval")));
                aDw.a(new a.InterfaceC0337a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.al.a.a.InterfaceC0337a
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
                aDw.aDx();
                kVar.a(a.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ach() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.al.a.a.aDw().aDy();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0363a {
        private static ArrayMap<String, Integer> bXB = new ArrayMap<>(3);

        static {
            bXB.put("ui", 60);
            bXB.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            bXB.put("normal", 200);
        }

        public static int jT(String str) {
            Integer num = bXB.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
