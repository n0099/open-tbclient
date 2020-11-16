package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cYb;
    private Runnable cYc;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cYb = new ArrayList();
        if (a.azt()) {
            if (a.azv()) {
                this.cYb.add(new d());
            }
            if (a.azw()) {
                this.cYb.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a azs() {
        return b.cYg;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.azt()) {
            this.cYc = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cYb) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cYc = null;
                }
            };
            ak.c(this.cYc, a.azu() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.azt()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.cYc != null) {
                            ak.l(c.this.cYc);
                            c.this.cYc = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cYb) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static int cYe = -2;
        private static int cYf = -2;

        public static boolean azt() {
            if (cYe == -2) {
                cYe = com.baidu.swan.apps.t.a.avV().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cYe > -1;
        }

        public static int azu() {
            return cYe;
        }

        public static boolean azv() {
            if (cYf == -2) {
                cYf = com.baidu.swan.apps.t.a.avV().getSwitch("swan_webview_pause_control", 3);
            }
            return (cYf & 1) == 1;
        }

        public static boolean azw() {
            if (cYf == -2) {
                cYf = com.baidu.swan.apps.t.a.avV().getSwitch("swan_webview_pause_control", 3);
            }
            return (cYf & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b {
        private static final c cYg = new c();
    }
}
