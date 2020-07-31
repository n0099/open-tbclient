package com.baidu.swan.apps.al;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.al.b.c;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static a cNF;
    private com.baidu.swan.apps.al.b.b cNG = new com.baidu.swan.apps.al.b.b();
    private c cNH = new c();
    private C0294a cNI = new C0294a();
    private com.baidu.swan.apps.al.a.a cNJ = new com.baidu.swan.apps.al.a.a();

    private a() {
    }

    public static a atW() {
        if (cNF == null) {
            synchronized (a.class) {
                if (cNF == null) {
                    cNF = new a();
                }
            }
        }
        return cNF;
    }

    public void bC(JSONObject jSONObject) {
        this.cNG.bE(jSONObject);
    }

    public void pf(String str) {
        bT(str, null);
    }

    public void bT(String str, String str2) {
        this.cNG.add(str, str2);
    }

    public void u(String str, Object obj) {
        this.cNI.add(str, obj);
    }

    public void bD(JSONObject jSONObject) {
        this.cNH.bE(jSONObject);
    }

    public JSONObject atX() {
        JSONObject aud = this.cNG.aud();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + aud);
        }
        return aud;
    }

    public JSONObject atY() {
        JSONObject aud = this.cNH.aud();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + aud);
        }
        return aud;
    }

    public JSONObject atZ() {
        JSONObject aud = this.cNI.aud();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + aud);
        }
        return aud;
    }

    public void clear() {
        this.cNG.clear();
        this.cNH.clear();
        this.cNI.clear();
    }

    public File aua() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(atX());
        jSONArray.put(atY());
        jSONArray.put(atZ());
        return this.cNJ.E(jSONArray);
    }

    public void aub() {
        if (this.cNI.cNK != null && this.cNI.cNK.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(atX());
            jSONArray.put(atY());
            jSONArray.put(atZ());
            this.cNJ.E(jSONArray);
        }
    }

    public com.baidu.swan.apps.al.a.a auc() {
        return this.cNJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0294a implements com.baidu.swan.apps.al.b.a<JSONObject> {
        private JSONArray cNK;

        private C0294a() {
        }

        public void bE(JSONObject jSONObject) {
            if (jSONObject != null) {
                if (this.cNK == null) {
                    this.cNK = new JSONArray();
                }
                if (this.cNK.length() >= 200) {
                    try {
                        this.cNK.put(0, jSONObject);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e("SwanStabilityTracer", "ExtraCollector JSONException", e);
                        }
                    }
                } else {
                    this.cNK.put(jSONObject);
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
                bE(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
        }

        public JSONObject aud() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cNK);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cNK = null;
        }
    }
}
