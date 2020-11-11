package com.baidu.swan.apps.inlinewidget.f.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> cWP = new HashMap<>();
    private final HashMap<String, String> cWQ = new HashMap<>();
    private boolean cWR = false;
    private boolean cWS = false;

    public synchronized void oO(@NonNull String str) {
        if (!this.cWS && !this.cWP.containsKey(str)) {
            this.cWP.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean oP(@NonNull String str) {
        return this.cWP.containsKey(str);
    }

    public synchronized boolean oQ(@NonNull String str) {
        return this.cWQ.containsKey(str);
    }

    public synchronized void bJ(String str, String str2) {
        if (!this.cWS) {
            this.cWQ.put(str, str2);
        }
    }

    public synchronized void avY() {
        this.cWS = true;
    }

    public synchronized boolean isFinished() {
        return this.cWS;
    }

    public void avZ() {
        final b.a aHy = d.aHq().aHm().aHy();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aHy);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cWR) {
            this.cWR = true;
            boolean equals = TextUtils.equals("1", this.cWQ.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cWQ.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                awa();
            } else {
                i.qR("video");
                HybridUbcFlow qJ = i.qJ("video");
                for (Map.Entry<String, Long> entry : this.cWP.entrySet()) {
                    qJ.f(new UbcFlowEvent(entry.getKey()).bY(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cWQ.entrySet()) {
                    qJ.ci(entry2.getKey(), entry2.getValue());
                }
                String qO = qJ.qO("fmpArrived");
                if (TextUtils.isEmpty(qO)) {
                    qO = "0";
                }
                qJ.ci("fmpArrived", qO);
                qJ.f(new UbcFlowEvent("na_start").bY(aVar.getLong("launch_time", 0L)));
                qJ.ci("launchID", aVar.ayW());
                qJ.aDl();
                awa();
            }
        }
    }

    private void awa() {
        this.cWP.clear();
        this.cWQ.clear();
    }
}
