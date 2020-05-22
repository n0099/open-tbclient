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
    private b ctG;

    /* loaded from: classes11.dex */
    public interface b {
        void a(@NonNull c cVar);

        void amJ();

        void clear(String str);

        void na(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0366a {
        private static a ctJ = new a();
    }

    public static a amG() {
        return C0366a.ctJ;
    }

    public void a(@NonNull final c cVar) {
        long amP = cVar.amP();
        if (amP > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, amP >= 0 ? amP : 0L);
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
        if (this.ctG == null) {
            this.ctG = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.ctG);
        this.ctG.amJ();
        this.ctG.a(cVar);
        this.ctG.amJ();
    }

    public void mY(String str) {
        if (this.ctG != null) {
            this.ctG.clear(str);
        }
    }

    public void amH() {
        if (this.ctG != null) {
            this.ctG.amJ();
        }
    }

    public void mZ(String str) {
        if (this.ctG != null) {
            this.ctG.na(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
