package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> dfa;
    private Runnable dfb;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.dfa = new ArrayList();
        if (a.aCC()) {
            if (a.aCE()) {
                this.dfa.add(new d());
            }
            if (a.aCF()) {
                this.dfa.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a aCB() {
        return b.dff;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aCC()) {
            this.dfb = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.dfa) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.dfb = null;
                }
            };
            ak.c(this.dfb, a.aCD() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aCC()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.dfb != null) {
                            ak.l(c.this.dfb);
                            c.this.dfb = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.dfa) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes25.dex */
    private static class a {
        private static int dfd = -2;
        private static int dfe = -2;

        public static boolean aCC() {
            if (dfd == -2) {
                dfd = com.baidu.swan.apps.t.a.azd().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return dfd > -1;
        }

        public static int aCD() {
            return dfd;
        }

        public static boolean aCE() {
            if (dfe == -2) {
                dfe = com.baidu.swan.apps.t.a.azd().getSwitch("swan_webview_pause_control", 3);
            }
            return (dfe & 1) == 1;
        }

        public static boolean aCF() {
            if (dfe == -2) {
                dfe = com.baidu.swan.apps.t.a.azd().getSwitch("swan_webview_pause_control", 3);
            }
            return (dfe & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b {
        private static final c dff = new c();
    }
}
