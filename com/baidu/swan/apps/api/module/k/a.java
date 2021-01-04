package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.swan.apps.ak.a.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ma(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                final k kVar = new k("accelerometerChange", jSONObject, str2);
                com.baidu.swan.apps.ak.a.a aPY = com.baidu.swan.apps.ak.a.a.aPY();
                aPY.w(a.this.getContext(), C0403a.mb(jSONObject.optString("interval")));
                aPY.a(new a.InterfaceC0377a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.ak.a.a.InterfaceC0377a
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
                aPY.aPZ();
                kVar.a(a.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b anG() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.ak.a.a.aPY().aQa();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0403a {
        private static ArrayMap<String, Integer> cKr = new ArrayMap<>(3);

        static {
            cKr.put("ui", 60);
            cKr.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            cKr.put("normal", 200);
        }

        public static int mb(String str) {
            Integer num = cKr.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
