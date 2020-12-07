package com.baidu.swan.apps.process.messaging;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.d;
/* loaded from: classes25.dex */
public final class a {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private b dqX;

    /* loaded from: classes25.dex */
    public interface b {
        void a(@NonNull c cVar);

        void aHH();

        void clear(String str);

        void sb(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0469a {
        private static a dra = new a();
    }

    public static a aHE() {
        return C0469a.dra;
    }

    public void a(@NonNull final c cVar) {
        long aHN = cVar.aHN();
        if (aHN > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            d.getMainHandler().postDelayed(new Runnable() { // from class: com.baidu.swan.apps.process.messaging.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(cVar);
                }
            }, aHN >= 0 ? aHN : 0L);
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
        if (this.dqX == null) {
            this.dqX = isMainProcess ? new com.baidu.swan.apps.process.messaging.service.d() : new com.baidu.swan.apps.process.messaging.client.b();
        }
        log("send: sender=" + this.dqX);
        this.dqX.aHH();
        this.dqX.a(cVar);
        this.dqX.aHH();
    }

    public void rZ(String str) {
        if (this.dqX != null) {
            this.dqX.clear(str);
        }
    }

    public void aHF() {
        if (this.dqX != null) {
            this.dqX.aHH();
        }
    }

    public void sa(String str) {
        if (this.dqX != null) {
            this.dqX.sb(str);
        }
    }

    public static void log(String str) {
        if (DEBUG) {
            Log.i("SwanAppMessenger", str);
        }
    }
}
