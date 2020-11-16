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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> cVf = new HashMap<>();
    private final HashMap<String, String> cVg = new HashMap<>();
    private boolean cVh = false;
    private boolean cVi = false;

    public synchronized void oI(@NonNull String str) {
        if (!this.cVi && !this.cVf.containsKey(str)) {
            this.cVf.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean oJ(@NonNull String str) {
        return this.cVf.containsKey(str);
    }

    public synchronized boolean oK(@NonNull String str) {
        return this.cVg.containsKey(str);
    }

    public synchronized void bI(String str, String str2) {
        if (!this.cVi) {
            this.cVg.put(str, str2);
        }
    }

    public synchronized void avq() {
        this.cVi = true;
    }

    public synchronized boolean isFinished() {
        return this.cVi;
    }

    public void avr() {
        final b.a aGQ = d.aGI().aGE().aGQ();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aGQ);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cVh) {
            this.cVh = true;
            boolean equals = TextUtils.equals("1", this.cVg.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cVg.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                avs();
            } else {
                i.qL("video");
                HybridUbcFlow qD = i.qD("video");
                for (Map.Entry<String, Long> entry : this.cVf.entrySet()) {
                    qD.f(new UbcFlowEvent(entry.getKey()).bY(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cVg.entrySet()) {
                    qD.ch(entry2.getKey(), entry2.getValue());
                }
                String qI = qD.qI("fmpArrived");
                if (TextUtils.isEmpty(qI)) {
                    qI = "0";
                }
                qD.ch("fmpArrived", qI);
                qD.f(new UbcFlowEvent("na_start").bY(aVar.getLong("launch_time", 0L)));
                qD.ch("launchID", aVar.ayo());
                qD.aCD();
                avs();
            }
        }
    }

    private void avs() {
        this.cVf.clear();
        this.cVg.clear();
    }
}
