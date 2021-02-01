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
    private b dtu;

    /* loaded from: classes9.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aFC();

        void clear(String str);

        void rb(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0441a {
        private static a dtx = new a();
    }

    public static a aFz() {
        return C0441a.dtx;
    }

    public void a(@NonNull final c cVar) {
        long aFI = cVar.aFI();
        if (aFI > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aFI >= 0 ? aFI : 0L);
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
        if (this.dtu == null) {
            this.dtu = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.dtu);
        this.dtu.aFC();
        this.dtu.a(cVar);
        this.dtu.aFC();
    }

    public void qZ(String str) {
        if (this.dtu != null) {
            this.dtu.clear(str);
        }
    }

    public void aFA() {
        if (this.dtu != null) {
            this.dtu.aFC();
        }
    }

    public void ra(String str) {
        if (this.dtu != null) {
            this.dtu.rb(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
