package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes3.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b cLg;

    /* loaded from: classes3.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aye();

        void clear(String str);

        void qh(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0416a {
        private static a cLj = new a();
    }

    public static a ayb() {
        return C0416a.cLj;
    }

    public void a(@NonNull final c cVar) {
        long ayk = cVar.ayk();
        if (ayk > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, ayk >= 0 ? ayk : 0L);
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
        if (this.cLg == null) {
            this.cLg = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.cLg);
        this.cLg.aye();
        this.cLg.a(cVar);
        this.cLg.aye();
    }

    public void qf(String str) {
        if (this.cLg != null) {
            this.cLg.clear(str);
        }
    }

    public void ayc() {
        if (this.cLg != null) {
            this.cLg.aye();
        }
    }

    public void qg(String str) {
        if (this.cLg != null) {
            this.cLg.qh(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
