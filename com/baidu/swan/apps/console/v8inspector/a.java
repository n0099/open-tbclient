package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes11.dex */
public class a {
    private static int mStatus;
    private InterfaceC0326a bSq;
    private b bSr;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0326a {
        void onConnected();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.arO().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.VX() || a.getStatus() != 0) {
                    a.this.bSr = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bSq);
                } else if (com.baidu.swan.apps.console.debugger.b.VY()) {
                    a.this.bSr = new com.baidu.swan.apps.console.v8inspector.a.b(d.Wv(), a.this.bSq);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.bSr.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.bSr != null) {
            this.bSr.stop();
            this.bSr = null;
        }
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        this.bSq = interfaceC0326a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.arO().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
