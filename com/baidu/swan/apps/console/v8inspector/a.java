package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes7.dex */
public class a {
    private static int mStatus;
    private InterfaceC0411a cEM;
    private b cEN;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0411a {
        void onConnected();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aKk().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.akW() || a.getStatus() != 0) {
                    a.this.cEN = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cEM);
                } else if (com.baidu.swan.apps.console.debugger.b.akX()) {
                    a.this.cEN = new com.baidu.swan.apps.console.v8inspector.a.b(d.alu(), a.this.cEM);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cEN.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cEN != null) {
            this.cEN.stop();
            this.cEN = null;
        }
    }

    public void a(InterfaceC0411a interfaceC0411a) {
        this.cEM = interfaceC0411a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aKk().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
