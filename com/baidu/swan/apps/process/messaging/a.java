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
    private b djY;

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aEz();

        void clear(String str);

        void ru(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0457a {
        private static a dkb = new a();
    }

    public static a aEw() {
        return C0457a.dkb;
    }

    public void a(@NonNull final c cVar) {
        long aEF = cVar.aEF();
        if (aEF > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aEF >= 0 ? aEF : 0L);
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
        if (this.djY == null) {
            this.djY = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.djY);
        this.djY.aEz();
        this.djY.a(cVar);
        this.djY.aEz();
    }

    public void rs(String str) {
        if (this.djY != null) {
            this.djY.clear(str);
        }
    }

    public void aEx() {
        if (this.djY != null) {
            this.djY.aEz();
        }
    }

    public void rt(String str) {
        if (this.djY != null) {
            this.djY.ru(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
