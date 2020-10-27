package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes10.dex */
public class a {
    private static int mStatus;
    private InterfaceC0401a cAD;
    private b cAE;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0401a {
        void onConnected();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aIs().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.aje() || a.getStatus() != 0) {
                    a.this.cAE = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cAD);
                } else if (com.baidu.swan.apps.console.debugger.b.ajf()) {
                    a.this.cAE = new com.baidu.swan.apps.console.v8inspector.a.b(d.ajC(), a.this.cAD);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cAE.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cAE != null) {
            this.cAE.stop();
            this.cAE = null;
        }
    }

    public void a(InterfaceC0401a interfaceC0401a) {
        this.cAD = interfaceC0401a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aIs().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
