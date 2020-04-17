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
    private b chV;

    /* loaded from: classes11.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aiW();

        void clear(String str);

        void lF(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0302a {
        private static a chY = new a();
    }

    public static a aiT() {
        return C0302a.chY;
    }

    public void a(@NonNull final c cVar) {
        long ajc = cVar.ajc();
        if (ajc > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, ajc >= 0 ? ajc : 0L);
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
        if (this.chV == null) {
            this.chV = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.chV);
        this.chV.aiW();
        this.chV.a(cVar);
        this.chV.aiW();
    }

    public void lD(String str) {
        if (this.chV != null) {
            this.chV.clear(str);
        }
    }

    public void aiU() {
        if (this.chV != null) {
            this.chV.aiW();
        }
    }

    public void lE(String str) {
        if (this.chV != null) {
            this.chV.lF(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
