package com.baidu.swan.apps.inlinewidget.f.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> dev = new HashMap<>();
    private final HashMap<String, String> dew = new HashMap<>();
    private boolean dex = false;
    private boolean isFinished = false;

    public synchronized void op(@NonNull String str) {
        if (!this.isFinished && !this.dev.containsKey(str)) {
            this.dev.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean oq(@NonNull String str) {
        return this.dev.containsKey(str);
    }

    public synchronized boolean or(@NonNull String str) {
        return this.dew.containsKey(str);
    }

    public synchronized void bH(String str, String str2) {
        if (!this.isFinished) {
            this.dew.put(str, str2);
        }
    }

    public synchronized void awu() {
        this.isFinished = true;
    }

    public synchronized boolean isFinished() {
        return this.isFinished;
    }

    public void awv() {
        final b.a aIO = d.aIG().aIC().aIO();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aIO);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.dex) {
            this.dex = true;
            boolean equals = TextUtils.equals("1", this.dew.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.dew.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                aww();
            } else {
                i.qs("video");
                HybridUbcFlow qk = i.qk("video");
                for (Map.Entry<String, Long> entry : this.dev.entrySet()) {
                    qk.f(new UbcFlowEvent(entry.getKey()).cE(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.dew.entrySet()) {
                    qk.cg(entry2.getKey(), entry2.getValue());
                }
                String qp = qk.qp("fmpArrived");
                if (TextUtils.isEmpty(qp)) {
                    qp = "0";
                }
                qk.cg("fmpArrived", qp);
                qk.f(new UbcFlowEvent("na_start").cE(aVar.getLong("launch_time", 0L)));
                qk.cg("launchID", aVar.azt());
                qk.aDI();
                aww();
            }
        }
    }

    private void aww() {
        this.dev.clear();
        this.dew.clear();
    }
}
