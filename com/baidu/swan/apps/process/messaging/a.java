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
    private b duV;

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aFF();

        void clear(String str);

        void ri(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0447a {
        private static a duY = new a();
    }

    public static a aFC() {
        return C0447a.duY;
    }

    public void a(@NonNull final c cVar) {
        long aFL = cVar.aFL();
        if (aFL > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aFL >= 0 ? aFL : 0L);
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
        if (this.duV == null) {
            this.duV = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.duV);
        this.duV.aFF();
        this.duV.a(cVar);
        this.duV.aFF();
    }

    public void rg(String str) {
        if (this.duV != null) {
            this.duV.clear(str);
        }
    }

    public void aFD() {
        if (this.duV != null) {
            this.duV.aFF();
        }
    }

    public void rh(String str) {
        if (this.duV != null) {
            this.duV.ri(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
