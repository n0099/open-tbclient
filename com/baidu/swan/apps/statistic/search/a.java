package com.baidu.swan.apps.statistic.search;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bVv;
    private HashMap<String, String> bVx;
    private int bVy;
    private String mAppId;
    private String mSource;
    private String mType;
    private String mValue;
    private HashMap<String, SearchFlowEvent> bVw = new HashMap<>();
    private Timer mTimer = new Timer();

    public a(String str) {
        this.bVy = 0;
        this.bVv = str;
        this.bVy = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----New SearchFlow-----");
        }
    }

    public synchronized void a(SearchFlowEvent searchFlowEvent) {
        if (!b(searchFlowEvent)) {
            if (DEBUG) {
                Log.d("SearchFlow", "SearchFlowEvent is invalid");
            }
        } else if (TextUtils.isEmpty(this.bVv) || this.bVw == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc flow status is invalid");
            }
        } else {
            if (this.bVw.get(searchFlowEvent.id) != null) {
                this.bVw.remove(searchFlowEvent.id);
                if (DEBUG) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.id);
                }
            } else if (searchFlowEvent.bVA == SearchFlowEvent.EventType.END) {
                this.bVy++;
            }
            this.bVw.put(searchFlowEvent.id, searchFlowEvent);
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
                    break;
                case 2:
                    this.mType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    this.mValue = searchFlowEvent.data;
                    break;
            }
        }
    }

    public void addExt(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bVx == null) {
                this.bVx = new HashMap<>();
            }
            this.bVx.put(str, str2);
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
        if (this.bVy >= 2) {
            if (DEBUG) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            cancelTimer();
            afc();
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
                    a.this.afc();
                }
            };
            if (DEBUG) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.mTimer.schedule(timerTask, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afc() {
        m.agL().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.afd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void afd() {
        if (TextUtils.equals(this.mSource, "1250000000000000")) {
            if (DEBUG) {
                Log.w("SearchFlow", "source=" + this.mSource + ", ignore this case");
            }
        } else if (this.bVw == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            Flow rb = s.rb(this.bVv);
            if (rb == null) {
                if (DEBUG) {
                    Log.w("SearchFlow", "UBC Flow create failed");
                }
            } else {
                for (SearchFlowEvent searchFlowEvent : this.bVw.values()) {
                    rb.addEvent(searchFlowEvent.id, searchFlowEvent.extData, searchFlowEvent.timestamp);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", "swan");
                    jSONObject.put("type", this.mType);
                    jSONObject.put("source", this.mSource);
                    jSONObject.put("value", this.mValue);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", this.mAppId);
                    if (this.bVx != null) {
                        for (String str : this.bVx.keySet()) {
                            jSONObject2.put(str, this.bVx.get(str));
                        }
                    }
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.w("SearchFlow", Log.getStackTraceString(e));
                    }
                }
                rb.setValueWithDuration(jSONObject.toString());
                rb.end();
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

    public synchronized void destroy() {
        cancelTimer();
        if (this.bVw != null) {
            this.bVw.clear();
        }
        if (this.bVx != null) {
            this.bVx.clear();
        }
        this.mAppId = null;
        this.mType = null;
        this.mSource = null;
        this.mValue = null;
        this.bVw = null;
        this.bVx = null;
        this.bVy = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    private boolean b(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.id) || searchFlowEvent.timestamp <= 0) ? false : true;
    }

    private synchronized void cancelTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
    }
}
