package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
import com.baidu.swan.apps.storage.c.h;
/* loaded from: classes7.dex */
public class a {
    private static int mStatus;
    private InterfaceC0334a bXX;
    private b bXY;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0334a {
        void onConnected();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void start();

        void stop();
    }

    static {
        mStatus = h.auW().getBoolean("Inspector", false) ? 2 : 0;
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.XJ() || a.getStatus() != 0) {
                    a.this.bXY = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bXX);
                } else if (com.baidu.swan.apps.console.debugger.b.XK()) {
                    a.this.bXY = new com.baidu.swan.apps.console.v8inspector.a.b(d.Yh(), a.this.bXX);
                } else {
                    com.baidu.swan.apps.console.c.e("V8Inspector", "Unknown inspect mode");
                    return;
                }
                a.this.bXY.start();
            }
        }, "V8Inspector");
    }

    public void stop() {
        if (this.bXY != null) {
            this.bXY.stop();
            this.bXY = null;
        }
    }

    public void a(InterfaceC0334a interfaceC0334a) {
        this.bXX = interfaceC0334a;
    }

    public static int getStatus() {
        return mStatus;
    }

    public static void setStatus(int i) {
        h.auW().putBoolean("Inspector", i == 2);
        mStatus = i;
    }
}
