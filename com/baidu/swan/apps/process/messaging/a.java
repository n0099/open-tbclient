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
    private b cib;

    /* loaded from: classes11.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aiV();

        void clear(String str);

        void lF(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0323a {
        private static a cif = new a();
    }

    public static a aiS() {
        return C0323a.cif;
    }

    public void a(@NonNull final c cVar) {
        long ajb = cVar.ajb();
        if (ajb > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, ajb >= 0 ? ajb : 0L);
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
        if (this.cib == null) {
            this.cib = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.cib);
        this.cib.aiV();
        this.cib.a(cVar);
        this.cib.aiV();
    }

    public void lD(String str) {
        if (this.cib != null) {
            this.cib.clear(str);
        }
    }

    public void aiT() {
        if (this.cib != null) {
            this.cib.aiV();
        }
    }

    public void lE(String str) {
        if (this.cib != null) {
            this.cib.lF(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
