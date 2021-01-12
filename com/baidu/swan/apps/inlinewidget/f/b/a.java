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
    private final HashMap<String, Long> dch = new HashMap<>();
    private final HashMap<String, String> dci = new HashMap<>();
    private boolean dcj = false;
    private boolean isFinished = false;

    public synchronized void nV(@NonNull String str) {
        if (!this.isFinished && !this.dch.containsKey(str)) {
            this.dch.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean nW(@NonNull String str) {
        return this.dch.containsKey(str);
    }

    public synchronized boolean nX(@NonNull String str) {
        return this.dci.containsKey(str);
    }

    public synchronized void bN(String str, String str2) {
        if (!this.isFinished) {
            this.dci.put(str, str2);
        }
    }

    public synchronized void avW() {
        this.isFinished = true;
    }

    public synchronized boolean isFinished() {
        return this.isFinished;
    }

    public void avX() {
        final b.a aIv = d.aIn().aIj().aIv();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aIv);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.dcj) {
            this.dcj = true;
            boolean equals = TextUtils.equals("1", this.dci.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.dci.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                avY();
            } else {
                i.qa("video");
                HybridUbcFlow pS = i.pS("video");
                for (Map.Entry<String, Long> entry : this.dch.entrySet()) {
                    pS.f(new UbcFlowEvent(entry.getKey()).cy(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.dci.entrySet()) {
                    pS.cm(entry2.getKey(), entry2.getValue());
                }
                String pX = pS.pX("fmpArrived");
                if (TextUtils.isEmpty(pX)) {
                    pX = "0";
                }
                pS.cm("fmpArrived", pX);
                pS.f(new UbcFlowEvent("na_start").cy(aVar.getLong("launch_time", 0L)));
                pS.cm("launchID", aVar.ayV());
                pS.aDm();
                avY();
            }
        }
    }

    private void avY() {
        this.dch.clear();
        this.dci.clear();
    }
}
