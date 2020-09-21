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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> cwu = new HashMap<>();
    private final HashMap<String, String> cwv = new HashMap<>();
    private boolean cww = false;
    private boolean cwx = false;

    public synchronized void nt(@NonNull String str) {
        if (!this.cwx && !this.cwu.containsKey(str)) {
            this.cwu.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean nu(@NonNull String str) {
        return this.cwu.containsKey(str);
    }

    public synchronized boolean nv(@NonNull String str) {
        return this.cwv.containsKey(str);
    }

    public synchronized void bx(String str, String str2) {
        if (!this.cwx) {
            this.cwv.put(str, str2);
        }
    }

    public synchronized void aoR() {
        this.cwx = true;
    }

    public synchronized boolean isFinished() {
        return this.cwx;
    }

    public void aoS() {
        final b.a aAv = d.aAn().aAj().aAv();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aAv);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cww) {
            this.cww = true;
            boolean equals = TextUtils.equals("1", this.cwv.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cwv.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                aoT();
            } else {
                i.py("video");
                HybridUbcFlow pq = i.pq("video");
                for (Map.Entry<String, Long> entry : this.cwu.entrySet()) {
                    pq.f(new UbcFlowEvent(entry.getKey()).bs(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cwv.entrySet()) {
                    pq.bW(entry2.getKey(), entry2.getValue());
                }
                String pv = pq.pv("fmpArrived");
                if (TextUtils.isEmpty(pv)) {
                    pv = "0";
                }
                pq.bW("fmpArrived", pv);
                pq.f(new UbcFlowEvent("na_start").bs(aVar.getLong("launch_time", 0L)));
                pq.bW("launchID", aVar.arQ());
                pq.awg();
                aoT();
            }
        }
    }

    private void aoT() {
        this.cwu.clear();
        this.cwv.clear();
    }
}
