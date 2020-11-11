package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes10.dex */
public class a {
    private static int mStatus;
    private InterfaceC0413a cGw;
    private b cGx;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0413a {
        void onConnected();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aKS().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.alE() || a.getStatus() != 0) {
                    a.this.cGx = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cGw);
                } else if (com.baidu.swan.apps.console.debugger.b.alF()) {
                    a.this.cGx = new com.baidu.swan.apps.console.v8inspector.a.b(d.amc(), a.this.cGw);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cGx.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cGx != null) {
            this.cGx.stop();
            this.cGx = null;
        }
    }

    public void a(InterfaceC0413a interfaceC0413a) {
        this.cGw = interfaceC0413a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aKS().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
