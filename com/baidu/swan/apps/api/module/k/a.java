package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.a.a;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.runtime.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.api.a.c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b hm(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new c.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public com.baidu.swan.apps.api.b.b a(e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                com.baidu.swan.apps.ao.a.a anO = com.baidu.swan.apps.ao.a.a.anO();
                anO.m(a.this.getContext(), C0277a.hn(jSONObject.optString("interval")));
                anO.a(new a.InterfaceC0255a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.ao.a.a.InterfaceC0255a
                    public void a(double[] dArr) {
                        if (dArr == null || dArr.length != 3) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "illegal accelerometers");
                            a.this.a(str2, new com.baidu.swan.apps.api.b.b(1001));
                            return;
                        }
                        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(Config.EVENT_HEAT_X, dArr[0]);
                            jSONObject2.put("y", dArr[1]);
                            jSONObject2.put("z", dArr[2]);
                            if (com.baidu.swan.apps.api.a.c.DEBUG) {
                                Log.d("Api-Accelerometer", "startAccelerometer --- accelerometer x: " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                            }
                            a.this.a(str2, new com.baidu.swan.apps.api.b.b(0, jSONObject2));
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "handle compass,json error，" + e.toString());
                            a.this.a(str2, new com.baidu.swan.apps.api.b.b(1001, "Json error"));
                        }
                    }
                });
                anO.anP();
                return new com.baidu.swan.apps.api.b.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b RO() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.ao.a.a.anO().anQ();
        return new com.baidu.swan.apps.api.b.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0277a {
        private static ArrayMap<String, Integer> bDU = new ArrayMap<>(3);

        static {
            bDU.put("ui", 60);
            bDU.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            bDU.put("normal", 200);
        }

        public static int hn(String str) {
            Integer num = bDU.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
