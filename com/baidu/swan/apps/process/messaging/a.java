package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes10.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b bEU;

    /* loaded from: classes10.dex */
    public interface b {
        void Yy();

        void a(@NonNull c cVar);

        void clear(String str);

        void ke(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0262a {
        private static a bEX = new a();
    }

    public static a Yv() {
        return C0262a.bEX;
    }

    public void a(@NonNull final c cVar) {
        long YE = cVar.YE();
        if (YE > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, YE >= 0 ? YE : 0L);
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
        if (this.bEU == null) {
            this.bEU = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.bEU);
        this.bEU.Yy();
        this.bEU.a(cVar);
        this.bEU.Yy();
    }

    public void kc(String str) {
        if (this.bEU != null) {
            this.bEU.clear(str);
        }
    }

    public void Yw() {
        if (this.bEU != null) {
            this.bEU.Yy();
        }
    }

    public void kd(String str) {
        if (this.bEU != null) {
            this.bEU.ke(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
