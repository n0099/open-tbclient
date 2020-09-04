package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cxq;
    private Runnable cxr;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cxq = new ArrayList();
        if (a.asl()) {
            if (a.aso()) {
                this.cxq.add(new d());
            }
            if (a.asp()) {
                this.cxq.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a ask() {
        return b.cxv;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.asl()) {
            this.cxr = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cxq) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cxr = null;
                }
            };
            ak.c(this.cxr, a.asn() * 1000);
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
                        if (c.this.cxr != null) {
                            ak.l(c.this.cxr);
                            c.this.cxr = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cxq) {
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
        private static int cxt = -2;
        private static int cxu = -2;

        public static boolean asl() {
            if (cxt == -2) {
                cxt = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cxt > -1;
        }

        public static int asn() {
            return cxt;
        }

        public static boolean aso() {
            if (cxu == -2) {
                cxu = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_pause_control", 3);
            }
            return (cxu & 1) == 1;
        }

        public static boolean asp() {
            if (cxu == -2) {
                cxu = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_webview_pause_control", 3);
            }
            return (cxu & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b {
        private static final c cxv = new c();
    }
}
