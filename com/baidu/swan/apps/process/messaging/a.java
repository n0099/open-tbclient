package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes7.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cAT;

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull c cVar);

        void apz();

        void clear(String str);

        void nP(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0375a {
        private static a cAW = new a();
    }

    public static a apw() {
        return C0375a.cAW;
    }

    public void a(@NonNull final c cVar) {
        long apF = cVar.apF();
        if (apF > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, apF >= 0 ? apF : 0L);
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
        if (this.cAT == null) {
            this.cAT = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.cAT);
        this.cAT.apz();
        this.cAT.a(cVar);
        this.cAT.apz();
    }

    public void nN(String str) {
        if (this.cAT != null) {
            this.cAT.clear(str);
        }
    }

    public void apx() {
        if (this.cAT != null) {
            this.cAT.apz();
        }
    }

    public void nO(String str) {
        if (this.cAT != null) {
            this.cAT.nP(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
