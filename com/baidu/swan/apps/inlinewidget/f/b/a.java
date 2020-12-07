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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> dcb = new HashMap<>();
    private final HashMap<String, String> dcc = new HashMap<>();
    private boolean dcd = false;
    private boolean dce = false;

    public synchronized void pp(@NonNull String str) {
        if (!this.dce && !this.dcb.containsKey(str)) {
            this.dcb.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean pq(@NonNull String str) {
        return this.dcb.containsKey(str);
    }

    public synchronized boolean pr(@NonNull String str) {
        return this.dcc.containsKey(str);
    }

    public synchronized void bP(String str, String str2) {
        if (!this.dce) {
            this.dcc.put(str, str2);
        }
    }

    public synchronized void ayy() {
        this.dce = true;
    }

    public synchronized boolean isFinished() {
        return this.dce;
    }

    public void ayz() {
        final b.a aJY = d.aJQ().aJM().aJY();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aJY);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.dcd) {
            this.dcd = true;
            boolean equals = TextUtils.equals("1", this.dcc.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.dcc.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                ayA();
            } else {
                i.rs("video");
                HybridUbcFlow rk = i.rk("video");
                for (Map.Entry<String, Long> entry : this.dcb.entrySet()) {
                    rk.f(new UbcFlowEvent(entry.getKey()).cx(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.dcc.entrySet()) {
                    rk.co(entry2.getKey(), entry2.getValue());
                }
                String rp = rk.rp("fmpArrived");
                if (TextUtils.isEmpty(rp)) {
                    rp = "0";
                }
                rk.co("fmpArrived", rp);
                rk.f(new UbcFlowEvent("na_start").cx(aVar.getLong("launch_time", 0L)));
                rk.co("launchID", aVar.aBx());
                rk.aFL();
                ayA();
            }
        }
    }

    private void ayA() {
        this.dcb.clear();
        this.dcc.clear();
    }
}
