package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes3.dex */
public class a {
    private static int mStatus;
    private InterfaceC0370a cfM;
    private b cfN;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0370a {
        void onConnected();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.aDP().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.aez() || a.getStatus() != 0) {
                    a.this.cfN = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.cfM);
                } else if (com.baidu.swan.apps.console.debugger.b.aeA()) {
                    a.this.cfN = new com.baidu.swan.apps.console.v8inspector.a.b(d.aeX(), a.this.cfM);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.cfN.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.cfN != null) {
            this.cfN.stop();
            this.cfN = null;
        }
    }

    public void a(InterfaceC0370a interfaceC0370a) {
        this.cfM = interfaceC0370a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.aDP().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
