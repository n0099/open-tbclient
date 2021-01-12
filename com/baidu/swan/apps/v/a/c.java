package com.baidu.swan.apps.v.a;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> dff;
    private Runnable dfg;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.dff = new ArrayList();
        if (a.aAa()) {
            if (a.aAc()) {
                this.dff.add(new d());
            }
            if (a.aAd()) {
                this.dff.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a azZ() {
        return b.dfk;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aAa()) {
            this.dfg = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.dff) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.dfg = null;
                }
            };
            ak.c(this.dfg, a.aAb() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aAa()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.dfg != null) {
                            ak.k(c.this.dfg);
                            c.this.dfg = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.dff) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes8.dex */
    private static class a {
        private static int dfi = -2;
        private static int dfj = -2;

        public static boolean aAa() {
            if (dfi == -2) {
                dfi = com.baidu.swan.apps.t.a.awB().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return dfi > -1;
        }

        public static int aAb() {
            return dfi;
        }

        public static boolean aAc() {
            if (dfj == -2) {
                dfj = com.baidu.swan.apps.t.a.awB().getSwitch("swan_webview_pause_control", 3);
            }
            return (dfj & 1) == 1;
        }

        public static boolean aAd() {
            if (dfj == -2) {
                dfj = com.baidu.swan.apps.t.a.awB().getSwitch("swan_webview_pause_control", 3);
            }
            return (dfj & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static final c dfk = new c();
    }
}
