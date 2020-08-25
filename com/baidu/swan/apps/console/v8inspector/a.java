package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes8.dex */
public class a {
    private static int mStatus;
    private InterfaceC0375a cdH;
    private b cdI;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0375a {
        void onConnected();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aDf().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.adP() || a.getStatus() != 0) {
                    a.this.cdI = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cdH);
                } else if (com.baidu.swan.apps.console.debugger.b.adQ()) {
                    a.this.cdI = new com.baidu.swan.apps.console.v8inspector.a.b(d.aen(), a.this.cdH);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cdI.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cdI != null) {
            this.cdI.stop();
            this.cdI = null;
        }
    }

    public void a(InterfaceC0375a interfaceC0375a) {
        this.cdH = interfaceC0375a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aDf().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
