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
    private final HashMap<String, Long> cQW = new HashMap<>();
    private final HashMap<String, String> cQX = new HashMap<>();
    private boolean cQY = false;
    private boolean cQZ = false;

    public synchronized void oA(@NonNull String str) {
        if (!this.cQZ && !this.cQW.containsKey(str)) {
            this.cQW.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean oB(@NonNull String str) {
        return this.cQW.containsKey(str);
    }

    public synchronized boolean oC(@NonNull String str) {
        return this.cQX.containsKey(str);
    }

    public synchronized void bJ(String str, String str2) {
        if (!this.cQZ) {
            this.cQX.put(str, str2);
        }
    }

    public synchronized void aty() {
        this.cQZ = true;
    }

    public synchronized boolean isFinished() {
        return this.cQZ;
    }

    public void atz() {
        final b.a aEY = d.aEQ().aEM().aEY();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aEY);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.cQY) {
            this.cQY = true;
            boolean equals = TextUtils.equals("1", this.cQX.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cQX.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                atA();
            } else {
                i.qD("video");
                HybridUbcFlow qv = i.qv("video");
                for (Map.Entry<String, Long> entry : this.cQW.entrySet()) {
                    qv.f(new UbcFlowEvent(entry.getKey()).bC(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cQX.entrySet()) {
                    qv.ci(entry2.getKey(), entry2.getValue());
                }
                String qA = qv.qA("fmpArrived");
                if (TextUtils.isEmpty(qA)) {
                    qA = "0";
                }
                qv.ci("fmpArrived", qA);
                qv.f(new UbcFlowEvent("na_start").bC(aVar.getLong("launch_time", 0L)));
                qv.ci("launchID", aVar.aww());
                qv.aAL();
                atA();
            }
        }
    }

    private void atA() {
        this.cQW.clear();
        this.cQX.clear();
    }
}
