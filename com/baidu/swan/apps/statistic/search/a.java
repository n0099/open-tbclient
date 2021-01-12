package com.baidu.swan.apps.statistic.search;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<String, String> dJD;
    private int dJE;
    private String mAppId;
    private String mSource;
    private String mType;
    private String mUbcId;
    private String mValue;
    private HashMap<String, SearchFlowEvent> dJC = new HashMap<>();
    private Timer mTimer = new Timer();

    public a(String str) {
        this.dJE = 0;
        this.mUbcId = str;
        this.dJE = 0;
        if (DEBUG) {
            Log.d("SearchFlow", "-----New SearchFlow-----");
        }
    }

    public synchronized void a(SearchFlowEvent searchFlowEvent) {
        if (!b(searchFlowEvent)) {
            if (DEBUG) {
                Log.d("SearchFlow", "SearchFlowEvent is invalid");
            }
        } else if (TextUtils.isEmpty(this.mUbcId) || this.dJC == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc flow status is invalid");
            }
        } else {
            if (this.dJC.get(searchFlowEvent.id) != null) {
                this.dJC.remove(searchFlowEvent.id);
                if (DEBUG) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.id);
                }
            } else if (searchFlowEvent.dJG == SearchFlowEvent.EventType.END) {
                this.dJE++;
            }
            this.dJC.put(searchFlowEvent.id, searchFlowEvent);
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
                    this.mType = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    this.mValue = searchFlowEvent.data;
                    break;
            }
        }
    }

    public void addExt(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.dJD == null) {
                this.dJD = new HashMap<>();
            }
            this.dJD.put(str, str2);
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
        if (this.dJE >= 2) {
            if (DEBUG) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            cancelTimer();
            aLs();
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
                    a.this.aLs();
                }
            };
            if (DEBUG) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.mTimer.schedule(timerTask, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLs() {
        p.aNw().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.search.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.aLt();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aLt() {
        if (TextUtils.equals(this.mSource, "1250000000000000")) {
            if (DEBUG) {
                Log.w("SearchFlow", "source=" + this.mSource + ", ignore this case");
            }
        } else if (this.dJC == null) {
            if (DEBUG) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (DEBUG) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            com.baidu.swan.apps.statistic.a so = h.so(this.mUbcId);
            if (so == null) {
                if (DEBUG) {
                    Log.w("SearchFlow", "Ceres Flow create failed");
                }
            } else {
                for (SearchFlowEvent searchFlowEvent : this.dJC.values()) {
                    com.baidu.swan.apps.statistic.b.a(so, searchFlowEvent.id, searchFlowEvent.extData, searchFlowEvent.timestamp);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                    jSONObject.put("type", this.mType);
                    jSONObject.put("source", this.mSource);
                    jSONObject.put("value", this.mValue);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", this.mAppId);
                    if (this.dJD != null) {
                        for (String str : this.dJD.keySet()) {
                            jSONObject2.put(str, this.dJD.get(str));
                        }
                    }
                    jSONObject.put("ext", jSONObject2);
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.w("SearchFlow", Log.getStackTraceString(e));
                    }
                }
                com.baidu.swan.apps.statistic.b.a(so, jSONObject.toString());
                com.baidu.swan.apps.statistic.b.c(so);
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
        if (this.dJC != null) {
            this.dJC.clear();
        }
        if (this.dJD != null) {
            this.dJD.clear();
        }
        this.mAppId = null;
        this.mType = null;
        this.mSource = null;
        this.mValue = null;
        this.dJC = null;
        this.dJD = null;
        this.dJE = 0;
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
