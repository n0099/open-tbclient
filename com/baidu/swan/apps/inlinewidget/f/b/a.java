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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, Long> dfW = new HashMap<>();
    private final HashMap<String, String> dfX = new HashMap<>();
    private boolean dfY = false;
    private boolean isFinished = false;

    public synchronized void ow(@NonNull String str) {
        if (!this.isFinished && !this.dfW.containsKey(str)) {
            this.dfW.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean ox(@NonNull String str) {
        return this.dfW.containsKey(str);
    }

    public synchronized boolean oy(@NonNull String str) {
        return this.dfX.containsKey(str);
    }

    public synchronized void bH(String str, String str2) {
        if (!this.isFinished) {
            this.dfX.put(str, str2);
        }
    }

    public synchronized void awx() {
        this.isFinished = true;
    }

    public synchronized boolean isFinished() {
        return this.isFinished;
    }

    public void awy() {
        final b.a aIR = d.aIJ().aIF().aIR();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aIR);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.dfY) {
            this.dfY = true;
            boolean equals = TextUtils.equals("1", this.dfX.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.dfX.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                awz();
            } else {
                i.qz("video");
                HybridUbcFlow qr = i.qr("video");
                for (Map.Entry<String, Long> entry : this.dfW.entrySet()) {
                    qr.f(new UbcFlowEvent(entry.getKey()).cE(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.dfX.entrySet()) {
                    qr.cg(entry2.getKey(), entry2.getValue());
                }
                String qw = qr.qw("fmpArrived");
                if (TextUtils.isEmpty(qw)) {
                    qw = "0";
                }
                qr.cg("fmpArrived", qw);
                qr.f(new UbcFlowEvent("na_start").cE(aVar.getLong("launch_time", 0L)));
                qr.cg("launchID", aVar.azw());
                qr.aDL();
                awz();
            }
        }
    }

    private void awz() {
        this.dfW.clear();
        this.dfX.clear();
    }
}
