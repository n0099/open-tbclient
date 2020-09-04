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
    private final HashMap<String, Long> cus = new HashMap<>();
    private final HashMap<String, String> cuu = new HashMap<>();
    private boolean cuv = false;
    private boolean cuw = false;

    public synchronized void na(@NonNull String str) {
        if (!this.cuw && !this.cus.containsKey(str)) {
            this.cus.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean nb(@NonNull String str) {
        return this.cus.containsKey(str);
    }

    public synchronized boolean nc(@NonNull String str) {
        return this.cuu.containsKey(str);
    }

    public synchronized void bx(String str, String str2) {
        if (!this.cuw) {
            this.cuu.put(str, str2);
        }
    }

    public synchronized void aoh() {
        this.cuw = true;
    }

    public synchronized boolean isFinished() {
        return this.cuw;
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
        if (!this.cuv) {
            this.cuv = true;
            boolean equals = TextUtils.equals("1", this.cuu.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.cuu.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                aoj();
            } else {
                i.pf("video");
                HybridUbcFlow oX = i.oX("video");
                for (Map.Entry<String, Long> entry : this.cus.entrySet()) {
                    oX.f(new UbcFlowEvent(entry.getKey()).br(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.cuu.entrySet()) {
                    oX.bW(entry2.getKey(), entry2.getValue());
                }
                String pc = oX.pc("fmpArrived");
                if (TextUtils.isEmpty(pc)) {
                    pc = "0";
                }
                oX.bW("fmpArrived", pc);
                oX.f(new UbcFlowEvent("na_start").br(aVar.getLong("launch_time", 0L)));
                oX.bW("launchID", aVar.arg());
                oX.avx();
                aoj();
            }
        }
    }

    private void aoj() {
        this.cus.clear();
        this.cuu.clear();
    }
}
