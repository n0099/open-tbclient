package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes8.dex */
public class a {
    private static int mStatus;
    private InterfaceC0401a cPD;
    private b cPE;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0401a {
        void onConnected();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aMk().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.alY() || a.getStatus() != 0) {
                    a.this.cPE = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cPD);
                } else if (com.baidu.swan.apps.console.debugger.b.alZ()) {
                    a.this.cPE = new com.baidu.swan.apps.console.v8inspector.a.b(d.amw(), a.this.cPD);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cPE.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cPE != null) {
            this.cPE.stop();
            this.cPE = null;
        }
    }

    public void a(InterfaceC0401a interfaceC0401a) {
        this.cPD = interfaceC0401a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aMk().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
