package com.baidu.swan.apps.statistic.search;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.r;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = c.DEBUG;
    private String aSF;
    private HashMap<String, String> aSH;
    private int aSI;
    private String mAppId;
    private String mSource;
    private String mType;
    private String mValue;
    private HashMap<String, SearchFlowEvent> aSG = new HashMap<>();
    private Timer mTimer = new Timer();

    public a(String str) {
        this.aSI = 0;
        this.aSF = str;
        this.aSI = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----New SearchFlow-----");
        }
    }

    public void a(SearchFlowEvent searchFlowEvent) {
        if (!b(searchFlowEvent)) {
            if (DEBUG) {
                Log.d("SearchFlow", "SearchFlowEvent is invalid");
            }
        } else if (TextUtils.isEmpty(this.aSF) || this.aSG == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc flow status is invalid");
            }
        } else {
            if (this.aSG.get(searchFlowEvent.id) != null) {
                this.aSG.remove(searchFlowEvent.id);
                if (DEBUG) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.id);
                }
            } else if (searchFlowEvent.aSK == SearchFlowEvent.EventType.END) {
                this.aSI++;
            }
            this.aSG.put(searchFlowEvent.id, searchFlowEvent);
            if (DEBUG) {
                Log.d("SearchFlow", "SearchFlowEvent added: " + searchFlowEvent.id);
            }
            String str = searchFlowEvent.id;
            char c = 65535;
            switch (str.hashCode()) {
                case -1037374011:
                    if (str.equals("nreach")) {
                        c = 2;
                        break;
                    }
                    break;
                case -912085361:
                    if (str.equals("fe_first_paint")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1211923090:
                    if (str.equals("dom_first_paint")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    this.mType = "success";
                    this.mValue = "";
                    return;
                case 2:
                    this.mType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    this.mValue = searchFlowEvent.data;
                    return;
                default:
                    return;
            }
        }
    }

    public void aB(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.aSH == null) {
                this.aSH = new HashMap<>();
            }
            this.aSH.put(str, str2);
        }
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void send() {
        if (DEBUG) {
            Log.d("SearchFlow", "try to send ubc: ");
        }
        if (this.aSI >= 2) {
            if (DEBUG) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            wo();
            Kx();
        } else if (this.mTimer == null) {
            if (DEBUG) {
                Log.w("SearchFlow", "send delay timer is null");
            }
        } else {
            TimerTask timerTask = new TimerTask() { // from class: com.baidu.swan.apps.statistic.search.a.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.DEBUG) {
                        Log.d("SearchFlow", "timer: send ubc...");
                    }
                    a.this.Kx();
                }
            };
            if (DEBUG) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.mTimer.schedule(timerTask, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kx() {
        j.LU().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.Ky();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Ky() {
        if (TextUtils.equals(this.mSource, "1250000000000000")) {
            if (DEBUG) {
                Log.w("SearchFlow", "source=" + this.mSource + ", ignore this case");
            }
        } else if (this.aSG == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            Flow jS = r.jS(this.aSF);
            if (jS == null) {
                if (DEBUG) {
                    Log.w("SearchFlow", "UBC Flow create failed");
                }
            } else {
                for (SearchFlowEvent searchFlowEvent : this.aSG.values()) {
                    jS.addEvent(searchFlowEvent.id, searchFlowEvent.extData, searchFlowEvent.timestamp);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", "swan");
                    jSONObject.put("type", this.mType);
                    jSONObject.put("source", this.mSource);
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, this.mValue);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", this.mAppId);
                    if (this.aSH != null) {
                        for (String str : this.aSH.keySet()) {
                            jSONObject2.put(str, this.aSH.get(str));
                        }
                    }
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.w("SearchFlow", Log.getStackTraceString(e));
                    }
                }
                jS.setValueWithDuration(jSONObject.toString());
                jS.end();
                if (DEBUG) {
                    Log.d("SearchFlow", "ubc: end flow");
                }
                destroy();
                if (DEBUG) {
                    Log.d("SearchFlow", "send ubc log");
                }
            }
        }
    }

    public void destroy() {
        wo();
        if (this.aSG != null) {
            this.aSG.clear();
        }
        if (this.aSH != null) {
            this.aSH.clear();
        }
        this.mAppId = null;
        this.mType = null;
        this.mSource = null;
        this.mValue = null;
        this.aSG = null;
        this.aSH = null;
        this.aSI = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    private boolean b(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.id) || searchFlowEvent.timestamp <= 0) ? false : true;
    }

    private synchronized void wo() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }
}
