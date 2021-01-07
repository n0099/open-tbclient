package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes9.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dvW;

    /* loaded from: classes9.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aJb();

        void clear(String str);

        void rU(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0461a {
        private static a dvZ = new a();
    }

    public static a aIY() {
        return C0461a.dvZ;
    }

    public void a(@NonNull final c cVar) {
        long aJh = cVar.aJh();
        if (aJh > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aJh >= 0 ? aJh : 0L);
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
        if (this.dvW == null) {
            this.dvW = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.dvW);
        this.dvW.aJb();
        this.dvW.a(cVar);
        this.dvW.aJb();
    }

    public void rS(String str) {
        if (this.dvW != null) {
            this.dvW.clear(str);
        }
    }

    public void aIZ() {
        if (this.dvW != null) {
            this.dvW.aJb();
        }
    }

    public void rT(String str) {
        if (this.dvW != null) {
            this.dvW.rU(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
