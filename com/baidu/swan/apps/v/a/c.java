package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> czr;
    private Runnable czs;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.czr = new ArrayList();
        if (a.asW()) {
            if (a.asY()) {
                this.czr.add(new d());
            }
            if (a.asZ()) {
                this.czr.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a asV() {
        return b.czw;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.asW()) {
            this.czs = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.czr) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.czs = null;
                }
            };
            ak.c(this.czs, a.asX() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.asW()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.czs != null) {
                            ak.l(c.this.czs);
                            c.this.czs = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.czr) {
                            aVar.onResume();
                        }
                        c.this.mIsPaused = false;
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static int czu = -2;
        private static int czv = -2;

        public static boolean asW() {
            if (czu == -2) {
                czu = com.baidu.swan.apps.t.a.apx().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return czu > -1;
        }

        public static int asX() {
            return czu;
        }

        public static boolean asY() {
            if (czv == -2) {
                czv = com.baidu.swan.apps.t.a.apx().getSwitch("swan_webview_pause_control", 3);
            }
            return (czv & 1) == 1;
        }

        public static boolean asZ() {
            if (czv == -2) {
                czv = com.baidu.swan.apps.t.a.apx().getSwitch("swan_webview_pause_control", 3);
            }
            return (czv & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private static final c czw = new c();
    }
}
