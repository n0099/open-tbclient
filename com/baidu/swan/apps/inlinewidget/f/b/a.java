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
    private final HashMap<String, Long> cIA = new HashMap<>();
    private final HashMap<String, String> cIB = new HashMap<>();
    private boolean cIC = false;
    private boolean cID = false;

    public synchronized void og(@NonNull String str) {
        if (!this.cID && !this.cIA.containsKey(str)) {
            this.cIA.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean oh(@NonNull String str) {
        return this.cIA.containsKey(str);
    }

    public synchronized boolean oi(@NonNull String str) {
        return this.cIB.containsKey(str);
    }

    public synchronized void bC(String str, String str2) {
        if (!this.cID) {
            this.cIB.put(str, str2);
        }
    }

    public synchronized void arD() {
        this.cID = true;
    }

    public synchronized boolean isFinished() {
        return this.cID;
    }

    public void arE() {
        final b.a aDe = d.aCW().aCS().aDe();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aDe);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cIC) {
            this.cIC = true;
            boolean equals = TextUtils.equals("1", this.cIB.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cIB.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                arF();
            } else {
                i.qk("video");
                HybridUbcFlow qc = i.qc("video");
                for (Map.Entry<String, Long> entry : this.cIA.entrySet()) {
                    qc.f(new UbcFlowEvent(entry.getKey()).bA(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cIB.entrySet()) {
                    qc.cb(entry2.getKey(), entry2.getValue());
                }
                String qh = qc.qh("fmpArrived");
                if (TextUtils.isEmpty(qh)) {
                    qh = "0";
                }
                qc.cb("fmpArrived", qh);
                qc.f(new UbcFlowEvent("na_start").bA(aVar.getLong("launch_time", 0L)));
                qc.cb("launchID", aVar.auC());
                qc.ayR();
                arF();
            }
        }
    }

    private void arF() {
        this.cIA.clear();
        this.cIB.clear();
    }
}
