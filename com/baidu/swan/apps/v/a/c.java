package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cTS;
    private Runnable cTT;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cTS = new ArrayList();
        if (a.axB()) {
            if (a.axD()) {
                this.cTS.add(new d());
            }
            if (a.axE()) {
                this.cTS.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a axA() {
        return b.cTX;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.axB()) {
            this.cTT = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cTS) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cTT = null;
                }
            };
            ak.c(this.cTT, a.axC() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.axB()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.cTT != null) {
                            ak.l(c.this.cTT);
                            c.this.cTT = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cTS) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static int cTV = -2;
        private static int cTW = -2;

        public static boolean axB() {
            if (cTV == -2) {
                cTV = com.baidu.swan.apps.t.a.aud().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cTV > -1;
        }

        public static int axC() {
            return cTV;
        }

        public static boolean axD() {
            if (cTW == -2) {
                cTW = com.baidu.swan.apps.t.a.aud().getSwitch("swan_webview_pause_control", 3);
            }
            return (cTW & 1) == 1;
        }

        public static boolean axE() {
            if (cTW == -2) {
                cTW = com.baidu.swan.apps.t.a.aud().getSwitch("swan_webview_pause_control", 3);
            }
            return (cTW & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static final c cTX = new c();
    }
}
