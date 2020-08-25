package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cxm;
    private Runnable cxn;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cxm = new ArrayList();
        if (a.asl()) {
            if (a.aso()) {
                this.cxm.add(new d());
            }
            if (a.asp()) {
                this.cxm.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a ask() {
        return b.cxr;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.asl()) {
            this.cxn = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cxm) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cxn = null;
                }
            };
            ak.c(this.cxn, a.asn() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.asl()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.cxn != null) {
                            ak.l(c.this.cxn);
                            c.this.cxn = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cxm) {
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
        private static int cxp = -2;
        private static int cxq = -2;

        public static boolean asl() {
            if (cxp == -2) {
                cxp = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cxp > -1;
        }

        public static int asn() {
            return cxp;
        }

        public static boolean aso() {
            if (cxq == -2) {
                cxq = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_pause_control", 3);
            }
            return (cxq & 1) == 1;
        }

        public static boolean asp() {
            if (cxq == -2) {
                cxq = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_pause_control", 3);
            }
            return (cxq & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static final c cxr = new c();
    }
}
