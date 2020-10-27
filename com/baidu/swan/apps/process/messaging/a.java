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
    private b dfK;

    /* loaded from: classes10.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aCH();

        void clear(String str);

        void rm(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0447a {
        private static a dfN = new a();
    }

    public static a aCE() {
        return C0447a.dfN;
    }

    public void a(@NonNull final c cVar) {
        long aCN = cVar.aCN();
        if (aCN > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aCN >= 0 ? aCN : 0L);
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
        if (this.dfK == null) {
            this.dfK = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.dfK);
        this.dfK.aCH();
        this.dfK.a(cVar);
        this.dfK.aCH();
    }

    public void rk(String str) {
        if (this.dfK != null) {
            this.dfK.clear(str);
        }
    }

    public void aCF() {
        if (this.dfK != null) {
            this.dfK.aCH();
        }
    }

    public void rl(String str) {
        if (this.dfK != null) {
            this.dfK.rm(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
