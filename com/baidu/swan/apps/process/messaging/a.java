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
    private b cXj;

    /* loaded from: classes10.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aAN();

        void clear(String str);

        void qT(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0433a {
        private static a cXm = new a();
    }

    public static a aAK() {
        return C0433a.cXm;
    }

    public void a(@NonNull final c cVar) {
        long aAT = cVar.aAT();
        if (aAT > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aAT >= 0 ? aAT : 0L);
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
        if (this.cXj == null) {
            this.cXj = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.cXj);
        this.cXj.aAN();
        this.cXj.a(cVar);
        this.cXj.aAN();
    }

    public void qR(String str) {
        if (this.cXj != null) {
            this.cXj.clear(str);
        }
    }

    public void aAL() {
        if (this.cXj != null) {
            this.cXj.aAN();
        }
    }

    public void qS(String str) {
        if (this.cXj != null) {
            this.cXj.qT(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
