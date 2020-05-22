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
    private static a cFE;
    private com.baidu.swan.apps.al.b.b cFF = new com.baidu.swan.apps.al.b.b();
    private c cFG = new c();
    private C0288a cFH = new C0288a();
    private com.baidu.swan.apps.al.a.a cFI = new com.baidu.swan.apps.al.a.a();

    private a() {
    }

    public static a aqT() {
        if (cFE == null) {
            synchronized (a.class) {
                if (cFE == null) {
                    cFE = new a();
                }
            }
        }
        return cFE;
    }

    public void bq(JSONObject jSONObject) {
        this.cFF.bs(jSONObject);
    }

    public void oo(String str) {
        bQ(str, null);
    }

    public void bQ(String str, String str2) {
        this.cFF.add(str, str2);
    }

    public void u(String str, Object obj) {
        this.cFH.add(str, obj);
    }

    public void br(JSONObject jSONObject) {
        this.cFG.bs(jSONObject);
    }

    public JSONObject aqU() {
        JSONObject ara = this.cFF.ara();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "LaunchTraces: " + ara);
        }
        return ara;
    }

    public JSONObject aqV() {
        JSONObject ara = this.cFG.ara();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "WhiteTraces: " + ara);
        }
        return ara;
    }

    public JSONObject aqW() {
        JSONObject ara = this.cFH.ara();
        if (DEBUG) {
            Log.d("SwanStabilityTracer", "extraTraces: " + ara);
        }
        return ara;
    }

    public void clear() {
        this.cFF.clear();
        this.cFG.clear();
        this.cFH.clear();
    }

    public File aqX() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(aqU());
        jSONArray.put(aqV());
        jSONArray.put(aqW());
        return this.cFI.D(jSONArray);
    }

    public void aqY() {
        if (this.cFH.cFJ != null && this.cFH.cFJ.length() != 0) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(aqU());
            jSONArray.put(aqV());
            jSONArray.put(aqW());
            this.cFI.D(jSONArray);
        }
    }

    public com.baidu.swan.apps.al.a.a aqZ() {
        return this.cFI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.al.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0288a implements com.baidu.swan.apps.al.b.a<JSONObject> {
        private JSONArray cFJ;

        private C0288a() {
        }

        public void bs(JSONObject jSONObject) {
            if (jSONObject != null) {
                if (this.cFJ == null) {
                    this.cFJ = new JSONArray();
                }
                if (this.cFJ.length() >= 200) {
                    try {
                        this.cFJ.put(0, jSONObject);
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.e("SwanStabilityTracer", "ExtraCollector JSONException", e);
                        }
                    }
                } else {
                    this.cFJ.put(jSONObject);
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
                bs(jSONObject);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
        }

        public JSONObject ara() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("extra", this.cFJ);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("SwanStabilityTracer", Log.getStackTraceString(e));
                }
            }
            return jSONObject;
        }

        public void clear() {
            this.cFJ = null;
        }
    }
}
