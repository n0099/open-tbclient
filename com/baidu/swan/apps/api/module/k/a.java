package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.am.a.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b iv(String str) {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "start listen accelerometer");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable final String str2) {
                com.baidu.swan.apps.console.c.i("Api-Accelerometer", " init ");
                final i iVar = new i("accelerometerChange", jSONObject, str2);
                com.baidu.swan.apps.am.a.a avn = com.baidu.swan.apps.am.a.a.avn();
                avn.m(a.this.getContext(), C0317a.iw(jSONObject.optString("interval")));
                avn.a(new a.InterfaceC0295a() { // from class: com.baidu.swan.apps.api.module.k.a.1.1
                    @Override // com.baidu.swan.apps.am.a.a.InterfaceC0295a
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
                            iVar.a(a.this, jSONObject2);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Accelerometer", "handle compass,json error，" + e.toString());
                            iVar.a(a.this, "Json error");
                        }
                    }
                });
                avn.avo();
                iVar.a(a.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b Wb() {
        if (DEBUG) {
            Log.d("Api-Accelerometer", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Accelerometer", "stop listen accelerometer");
        com.baidu.swan.apps.am.a.a.avn().avp();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* renamed from: com.baidu.swan.apps.api.module.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0317a {
        private static ArrayMap<String, Integer> bRW = new ArrayMap<>(3);

        static {
            bRW.put("ui", 60);
            bRW.put(ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME, 20);
            bRW.put("normal", 200);
        }

        public static int iw(String str) {
            Integer num = bRW.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 200;
        }
    }
}
