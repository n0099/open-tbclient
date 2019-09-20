package com.baidu.swan.apps.statistic.search;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aWH;
    private HashMap<String, String> aWJ;
    private int aWK;
    private String mAppId;
    private String mSource;
    private String mType;
    private String mValue;
    private HashMap<String, SearchFlowEvent> aWI = new HashMap<>();
    private Timer mTimer = new Timer();

    public a(String str) {
        this.aWK = 0;
        this.aWH = str;
        this.aWK = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----New SearchFlow-----");
        }
    }

    public void a(SearchFlowEvent searchFlowEvent) {
        if (!b(searchFlowEvent)) {
            if (DEBUG) {
                Log.d("SearchFlow", "SearchFlowEvent is invalid");
            }
        } else if (TextUtils.isEmpty(this.aWH) || this.aWI == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc flow status is invalid");
            }
        } else {
            if (this.aWI.get(searchFlowEvent.id) != null) {
                this.aWI.remove(searchFlowEvent.id);
                if (DEBUG) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.id);
                }
            } else if (searchFlowEvent.aWM == SearchFlowEvent.EventType.END) {
                this.aWK++;
            }
            this.aWI.put(searchFlowEvent.id, searchFlowEvent);
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

    public void aD(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.aWJ == null) {
                this.aWJ = new HashMap<>();
            }
            this.aWJ.put(str, str2);
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
        if (this.aWK >= 2) {
            if (DEBUG) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            xK();
            NP();
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
                    a.this.NP();
                }
            };
            if (DEBUG) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.mTimer.schedule(timerTask, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NP() {
        j.Ps().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.NQ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void NQ() {
        if (TextUtils.equals(this.mSource, "1250000000000000")) {
            if (DEBUG) {
                Log.w("SearchFlow", "source=" + this.mSource + ", ignore this case");
            }
        } else if (this.aWI == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            Flow lb = s.lb(this.aWH);
            if (lb == null) {
                if (DEBUG) {
                    Log.w("SearchFlow", "UBC Flow create failed");
                }
            } else {
                for (SearchFlowEvent searchFlowEvent : this.aWI.values()) {
                    lb.addEvent(searchFlowEvent.id, searchFlowEvent.extData, searchFlowEvent.timestamp);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", "swan");
                    jSONObject.put("type", this.mType);
                    jSONObject.put("source", this.mSource);
                    jSONObject.put(UBC.CONTENT_KEY_VALUE, this.mValue);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", this.mAppId);
                    if (this.aWJ != null) {
                        for (String str : this.aWJ.keySet()) {
                            jSONObject2.put(str, this.aWJ.get(str));
                        }
                    }
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.w("SearchFlow", Log.getStackTraceString(e));
                    }
                }
                lb.setValueWithDuration(jSONObject.toString());
                lb.end();
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
        xK();
        if (this.aWI != null) {
            this.aWI.clear();
        }
        if (this.aWJ != null) {
            this.aWJ.clear();
        }
        this.mAppId = null;
        this.mType = null;
        this.mSource = null;
        this.mValue = null;
        this.aWI = null;
        this.aWJ = null;
        this.aWK = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    private boolean b(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.id) || searchFlowEvent.timestamp <= 0) ? false : true;
    }

    private synchronized void xK() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }
}
