package com.baidu.swan.apps.al;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.al.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cKo;
    private com.baidu.swan.apps.al.b.b cKp = new com.baidu.swan.apps.al.b.b();
    private c cKq = new c();
    private C0294a cKr = new C0294a();
    private com.baidu.swan.apps.al.a.a cKs = new com.baidu.swan.apps.al.a.a();

    private a() {
    }

    public static a arZ() {
        if (cKo == null) {
            synchronized (a.class) {
                if (cKo == null) {
                    cKo = new a();
                }
            }
        }
        return cKo;
    }

    public void bx(JSONObject jSONObject) {
        this.cKp.bz(jSONObject);
    }

    public void ow(String str) {
        bS(str, null);
    }

    public void bS(String str, String str2) {
        this.cKp.add(str, str2);
    }

    public void u(String str, Object obj) {
        this.cKr.add(str, obj);
    }

    public void by(JSONObject jSONObject) {
        this.cKq.bz(jSONObject);
    }

    public JSONObject asa() {
        JSONObject asg = this.cKp.asg();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + asg);
        }
        return asg;
    }

    public JSONObject asb() {
        JSONObject asg = this.cKq.asg();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + asg);
        }
        return asg;
    }

    public JSONObject asc() {
        JSONObject asg = this.cKr.asg();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + asg);
        }
        return asg;
    }

    public void clear() {
        this.cKp.clear();
        this.cKq.clear();
        this.cKr.clear();
    }

    public File asd() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(asa());
        jSONArray.put(asb());
        jSONArray.put(asc());
        return this.cKs.D(jSONArray);
    }

    public void ase() {
        if (this.cKr.cKt != null && this.cKr.cKt.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(asa());
            jSONArray.put(asb());
            jSONArray.put(asc());
            this.cKs.D(jSONArray);
        }
    }

    public com.baidu.swan.apps.al.a.a asf() {
        return this.cKs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0294a implements com.baidu.swan.apps.al.b.a<JSONObject> {
        private JSONArray cKt;

        private C0294a() {
        }

        public void bz(JSONObject jSONObject) {
            if (jSONObject != null) {
                if (this.cKt == null) {
                    this.cKt = new JSONArray();
                }
                if (this.cKt.length() >= 200) {
                    try {
                        this.cKt.put(0, jSONObject);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e("SwanStabilityTracer", "ExtraCollector JSONException", e);
                        }
                    }
                } else {
                    this.cKt.put(jSONObject);
                }
                if (DEBUG) {
                    Log.d("SwanStabilityTracer", "add: " + jSONObject);
                }
            }
        }

        public void add(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                if (DEBUG) {
                    Log.d("SwanStabilityTracer", "event is empty");
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("actionId", str);
                jSONObject.put("timeStamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("info", obj);
                bz(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
        }

        public JSONObject asg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cKt);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cKt = null;
        }
    }
}
