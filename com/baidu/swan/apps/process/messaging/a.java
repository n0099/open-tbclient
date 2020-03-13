package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes11.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bJb;

    /* loaded from: classes11.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aaO();

        void clear(String str);

        void kt(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0272a {
        private static a bJe = new a();
    }

    public static a aaL() {
        return C0272a.bJe;
    }

    public void a(@NonNull final c cVar) {
        long aaU = cVar.aaU();
        if (aaU > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aaU >= 0 ? aaU : 0L);
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
        if (this.bJb == null) {
            this.bJb = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.bJb);
        this.bJb.aaO();
        this.bJb.a(cVar);
        this.bJb.aaO();
    }

    public void kr(String str) {
        if (this.bJb != null) {
            this.bJb.clear(str);
        }
    }

    public void aaM() {
        if (this.bJb != null) {
            this.bJb.aaO();
        }
    }

    public void ks(String str) {
        if (this.bJb != null) {
            this.bJb.kt(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
