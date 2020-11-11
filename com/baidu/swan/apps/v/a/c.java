package com.baidu.swan.apps.v.a;

import android.support.annotation.AnyThread;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ak;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements com.baidu.swan.apps.v.a.a {
    @NonNull
    private final List<com.baidu.swan.apps.v.a.a> cZL;
    private Runnable cZM;
    private volatile boolean mIsPaused;

    private c() {
        this.mIsPaused = false;
        this.cZL = new ArrayList();
        if (a.aAb()) {
            if (a.aAd()) {
                this.cZL.add(new d());
            }
            if (a.aAe()) {
                this.cZL.add(new com.baidu.swan.apps.v.a.b());
            }
        }
    }

    public static com.baidu.swan.apps.v.a.a aAa() {
        return b.cZQ;
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onPause() {
        if (a.aAb()) {
            this.cZM = new Runnable() { // from class: com.baidu.swan.apps.v.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    for (com.baidu.swan.apps.v.a.a aVar : c.this.cZL) {
                        aVar.onPause();
                    }
                    c.this.mIsPaused = true;
                    c.this.cZM = null;
                }
            };
            ak.c(this.cZM, a.aAc() * 1000);
        }
    }

    @Override // com.baidu.swan.apps.v.a.a
    @AnyThread
    public void onResume() {
        if (a.aAb()) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.mIsPaused) {
                        if (c.this.cZM != null) {
                            ak.l(c.this.cZM);
                            c.this.cZM = null;
                        }
                        for (com.baidu.swan.apps.v.a.a aVar : c.this.cZL) {
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
        private static int cZO = -2;
        private static int cZP = -2;

        public static boolean aAb() {
            if (cZO == -2) {
                cZO = com.baidu.swan.apps.t.a.awD().getSwitch("swan_webview_backstage_optimize", -1);
            }
            return cZO > -1;
        }

        public static int aAc() {
            return cZO;
        }

        public static boolean aAd() {
            if (cZP == -2) {
                cZP = com.baidu.swan.apps.t.a.awD().getSwitch("swan_webview_pause_control", 3);
            }
            return (cZP & 1) == 1;
        }

        public static boolean aAe() {
            if (cZP == -2) {
                cZP = com.baidu.swan.apps.t.a.awD().getSwitch("swan_webview_pause_control", 3);
            }
            return (cZP & 2) == 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b {
        private static final c cZQ = new c();
    }
}
