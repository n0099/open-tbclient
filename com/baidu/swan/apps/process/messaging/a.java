package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes9.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bEj;

    /* loaded from: classes9.dex */
    public interface b {
        void Yb();

        void a(@NonNull c cVar);

        void clear(String str);

        void kb(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0260a {
        private static a bEm = new a();
    }

    public static a XY() {
        return C0260a.bEm;
    }

    public void a(@NonNull final c cVar) {
        long Yh = cVar.Yh();
        if (Yh > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, Yh >= 0 ? Yh : 0L);
        } else {
            b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull c cVar) {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (!isMainProcess && !SwanAppProcessInfo.isInited()) {
            log("send: return by process check");
            return;
        }
        if (this.bEj == null) {
            this.bEj = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.bEj);
        this.bEj.Yb();
        this.bEj.a(cVar);
        this.bEj.Yb();
    }

    public void jZ(String str) {
        if (this.bEj != null) {
            this.bEj.clear(str);
        }
    }

    public void XZ() {
        if (this.bEj != null) {
            this.bEj.Yb();
        }
    }

    public void ka(String str) {
        if (this.bEj != null) {
            this.bEj.kb(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
