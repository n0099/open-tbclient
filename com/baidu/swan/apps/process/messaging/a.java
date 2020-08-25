package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes8.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cJc;

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull c cVar);

        void axv();

        void clear(String str);

        void pN(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0421a {
        private static a cJf = new a();
    }

    public static a axs() {
        return C0421a.cJf;
    }

    public void a(@NonNull final c cVar) {
        long axB = cVar.axB();
        if (axB > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, axB >= 0 ? axB : 0L);
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
        if (this.cJc == null) {
            this.cJc = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.cJc);
        this.cJc.axv();
        this.cJc.a(cVar);
        this.cJc.axv();
    }

    public void pL(String str) {
        if (this.cJc != null) {
            this.cJc.clear(str);
        }
    }

    public void axt() {
        if (this.cJc != null) {
            this.cJc.axv();
        }
    }

    public void pM(String str) {
        if (this.cJc != null) {
            this.cJc.pN(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
