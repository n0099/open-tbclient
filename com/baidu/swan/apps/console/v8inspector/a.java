package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes9.dex */
public class a {
    private static int mStatus;
    private InterfaceC0415a cQB;
    private b cQC;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0415a {
        void onConnected();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aPH().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.apr() || a.getStatus() != 0) {
                    a.this.cQC = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cQB);
                } else if (com.baidu.swan.apps.console.debugger.b.aps()) {
                    a.this.cQC = new com.baidu.swan.apps.console.v8inspector.a.b(d.apP(), a.this.cQB);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cQC.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cQC != null) {
            this.cQC.stop();
            this.cQC = null;
        }
    }

    public void a(InterfaceC0415a interfaceC0415a) {
        this.cQB = interfaceC0415a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aPH().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
