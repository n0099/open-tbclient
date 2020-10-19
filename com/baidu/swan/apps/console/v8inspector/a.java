package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes10.dex */
public class a {
    private static int mStatus;
    private InterfaceC0387a csd;
    private b cse;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0387a {
        void onConnected();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aGy().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.ahk() || a.getStatus() != 0) {
                    a.this.cse = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.csd);
                } else if (com.baidu.swan.apps.console.debugger.b.ahl()) {
                    a.this.cse = new com.baidu.swan.apps.console.v8inspector.a.b(d.ahI(), a.this.csd);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cse.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cse != null) {
            this.cse.stop();
            this.cse = null;
        }
    }

    public void a(InterfaceC0387a interfaceC0387a) {
        this.csd = interfaceC0387a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aGy().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
