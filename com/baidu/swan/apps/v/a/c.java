package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cLw;
    private Runnable cLx;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cLw = new ArrayList();
        if (a.avH()) {
            if (a.avJ()) {
                this.cLw.add(new d());
            }
            if (a.avK()) {
                this.cLw.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a avG() {
        return b.cLB;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.avH()) {
            this.cLx = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cLw) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cLx = null;
                }
            };
            ak.c(this.cLx, a.avI() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.avH()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.cLx != null) {
                            ak.l(c.this.cLx);
                            c.this.cLx = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cLw) {
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
        private static int cLz = -2;
        private static int cLA = -2;

        public static boolean avH() {
            if (cLz == -2) {
                cLz = com.baidu.swan.apps.t.a.asi().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cLz > -1;
        }

        public static int avI() {
            return cLz;
        }

        public static boolean avJ() {
            if (cLA == -2) {
                cLA = com.baidu.swan.apps.t.a.asi().getSwitch("swan_webview_pause_control", 3);
            }
            return (cLA & 1) == 1;
        }

        public static boolean avK() {
            if (cLA == -2) {
                cLA = com.baidu.swan.apps.t.a.asi().getSwitch("swan_webview_pause_control", 3);
            }
            return (cLA & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static final c cLB = new c();
    }
}
