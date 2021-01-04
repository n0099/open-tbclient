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
    private final HashMap<String, Long> dgW = new HashMap<>();
    private final HashMap<String, String> dgX = new HashMap<>();
    private boolean dgY = false;
    private boolean isFinished = false;

    public synchronized void pi(@NonNull String str) {
        if (!this.isFinished && !this.dgW.containsKey(str)) {
            this.dgW.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public synchronized boolean pj(@NonNull String str) {
        return this.dgW.containsKey(str);
    }

    public synchronized boolean pk(@NonNull String str) {
        return this.dgX.containsKey(str);
    }

    public synchronized void bO(String str, String str2) {
        if (!this.isFinished) {
            this.dgX.put(str, str2);
        }
    }

    public synchronized void azP() {
        this.isFinished = true;
    }

    public synchronized boolean isFinished() {
        return this.isFinished;
    }

    public void azQ() {
        final b.a aMo = d.aMg().aMc().aMo();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.inlinewidget.f.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(aMo);
            }
        }, "VideoStaticRecorder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.a aVar) {
        if (!this.dgY) {
            this.dgY = true;
            boolean equals = TextUtils.equals("1", this.dgX.get("autoPlay"));
            boolean equals2 = TextUtils.equals("1", this.dgX.get("playMethod"));
            if (DEBUG) {
                Log.d("VideoStaticRecorder", "submit: autoPlay:" + equals + ",apiPlay:" + equals2);
            }
            if (!equals && !equals2) {
                azR();
            } else {
                i.rl("video");
                HybridUbcFlow rd = i.rd("video");
                for (Map.Entry<String, Long> entry : this.dgW.entrySet()) {
                    rd.f(new UbcFlowEvent(entry.getKey()).cy(entry.getValue().longValue()));
                }
                for (Map.Entry<String, String> entry2 : this.dgX.entrySet()) {
                    rd.cn(entry2.getKey(), entry2.getValue());
                }
                String ri = rd.ri("fmpArrived");
                if (TextUtils.isEmpty(ri)) {
                    ri = "0";
                }
                rd.cn("fmpArrived", ri);
                rd.f(new UbcFlowEvent("na_start").cy(aVar.getLong("launch_time", 0L)));
                rd.cn("launchID", aVar.aCO());
                rd.aHf();
                azR();
            }
        }
    }

    private void azR() {
        this.dgW.clear();
        this.dgX.clear();
    }
}
