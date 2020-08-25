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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> cun = new HashMap<>();
    private final HashMap<String, String> cuo = new HashMap<>();
    private boolean cup = false;
    private boolean cuq = false;

    public synchronized void mZ(@NonNull String str) {
        if (!this.cuq && !this.cun.containsKey(str)) {
            this.cun.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean na(@NonNull String str) {
        return this.cun.containsKey(str);
    }

    public synchronized boolean nb(@NonNull String str) {
        return this.cuo.containsKey(str);
    }

    public synchronized void bx(String str, String str2) {
        if (!this.cuq) {
            this.cuo.put(str, str2);
        }
    }

    public synchronized void aoh() {
        this.cuq = true;
    }

    public synchronized boolean isFinished() {
        return this.cuq;
    }

    public void aoi() {
        final b.a azM = d.azE().azA().azM();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(azM);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cup) {
            this.cup = true;
            boolean equals = TextUtils.equals("1", this.cuo.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cuo.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                aoj();
            } else {
                i.pe("video");
                HybridUbcFlow oW = i.oW("video");
                for (Map.Entry<String, Long> entry : this.cun.entrySet()) {
                    oW.f(new UbcFlowEvent(entry.getKey()).br(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cuo.entrySet()) {
                    oW.bW(entry2.getKey(), entry2.getValue());
                }
                String pb = oW.pb("fmpArrived");
                if (TextUtils.isEmpty(pb)) {
                    pb = "0";
                }
                oW.bW("fmpArrived", pb);
                oW.f(new UbcFlowEvent("na_start").br(aVar.getLong("launch_time", 0L)));
                oW.bW("launchID", aVar.arg());
                oW.avx();
                aoj();
            }
        }
    }

    private void aoj() {
        this.cun.clear();
        this.cuo.clear();
    }
}
