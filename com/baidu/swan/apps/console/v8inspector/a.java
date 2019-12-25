package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
/* loaded from: classes9.dex */
public class a {
    private InterfaceC0226a bfQ;
    private b bfR;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0226a {
        void onConnected();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void start();
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void start() {
        ExecutorUtilsExt.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.console.v8inspector.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.console.debugger.b.IN()) {
                    a.this.bfR = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bfQ);
                } else if (com.baidu.swan.apps.console.debugger.b.IO()) {
                    a.this.bfR = new com.baidu.swan.apps.console.v8inspector.a.b(d.Jl(), a.this.bfQ);
                }
                a.this.bfR.start();
            }
        }, "V8Inspector");
    }

    public void a(InterfaceC0226a interfaceC0226a) {
        this.bfQ = interfaceC0226a;
    }
}
