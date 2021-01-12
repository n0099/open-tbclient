package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes8.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b drh;

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aFh();

        void clear(String str);

        void qJ(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0444a {
        private static a drk = new a();
    }

    public static a aFe() {
        return C0444a.drk;
    }

    public void a(@NonNull final c cVar) {
        long aFn = cVar.aFn();
        if (aFn > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aFn >= 0 ? aFn : 0L);
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
        if (this.drh == null) {
            this.drh = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.drh);
        this.drh.aFh();
        this.drh.a(cVar);
        this.drh.aFh();
    }

    public void qH(String str) {
        if (this.drh != null) {
            this.drh.clear(str);
        }
    }

    public void aFf() {
        if (this.drh != null) {
            this.drh.aFh();
        }
    }

    public void qI(String str) {
        if (this.drh != null) {
            this.drh.qJ(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
