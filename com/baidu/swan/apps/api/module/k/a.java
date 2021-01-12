package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ak.a.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kP(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                final k kVar = new k("accelerometerChange", jSONObject, str2);
                com.baidu.swan.apps.ak.a.a aMf = com.baidu.swan.apps.ak.a.a.aMf();
                aMf.w(a.this.getContext(), C0386a.kQ(jSONObject.optString("interval")));
                aMf.a(new a.InterfaceC0360a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.ak.a.a.InterfaceC0360a
                    public void a(double[] dArr) {
                        if (dArr == null || dArr.length != 3) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "illegal accelerometers");
                            a.this.a(str2, new com.baidu.swan.apps.api.c.b(1001));
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(Config.EVENT_HEAT_X, dArr[0]);
                            jSONObject2.put("y", dArr[1]);
                            jSONObject2.put("z", dArr[2]);
                            kVar.a(a.this, jSONObject2);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "handle compass,json error，" + e.toString());
                            kVar.a(a.this, "Json error");
                        }
                    }
                });
                aMf.aMg();
                kVar.a(a.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ajN() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.ak.a.a.aMf().aMh();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0386a {
        private static ArrayMap<String, Integer> cFF = new ArrayMap<>(3);

        static {
            cFF.put("ui", 60);
            cFF.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            cFF.put("normal", 200);
        }

        public static int kQ(String str) {
            Integer num = cFF.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
