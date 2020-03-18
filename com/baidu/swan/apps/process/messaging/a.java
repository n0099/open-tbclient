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
    private b bJm;

    /* loaded from: classes11.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aaR();

        void clear(String str);

        void ks(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0272a {
        private static a bJp = new a();
    }

    public static a aaO() {
        return C0272a.bJp;
    }

    public void a(@NonNull final c cVar) {
        long aaX = cVar.aaX();
        if (aaX > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aaX >= 0 ? aaX : 0L);
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
        if (this.bJm == null) {
            this.bJm = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.bJm);
        this.bJm.aaR();
        this.bJm.a(cVar);
        this.bJm.aaR();
    }

    public void kq(String str) {
        if (this.bJm != null) {
            this.bJm.clear(str);
        }
    }

    public void aaP() {
        if (this.bJm != null) {
            this.bJm.aaR();
        }
    }

    public void kr(String str) {
        if (this.bJm != null) {
            this.bJm.ks(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
