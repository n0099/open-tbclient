package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes25.dex */
public class a {
    private static int mStatus;
    private InterfaceC0423a cLG;
    private b cLH;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0423a {
        void onConnected();
    }

    /* loaded from: classes25.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aNr().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.aoe() || a.getStatus() != 0) {
                    a.this.cLH = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cLG);
                } else if (com.baidu.swan.apps.console.debugger.b.aof()) {
                    a.this.cLH = new com.baidu.swan.apps.console.v8inspector.a.b(d.aoC(), a.this.cLG);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cLH.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cLH != null) {
            this.cLH.stop();
            this.cLH = null;
        }
    }

    public void a(InterfaceC0423a interfaceC0423a) {
        this.cLG = interfaceC0423a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aNr().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
