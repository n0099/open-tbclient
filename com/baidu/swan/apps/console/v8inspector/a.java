package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
/* loaded from: classes10.dex */
public class a {
    private InterfaceC0228a bgG;
    private b bgH;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0228a {
        void onConnected();
    }

    /* loaded from: classes10.dex */
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
                if (com.baidu.swan.apps.console.debugger.b.Jj()) {
                    a.this.bgH = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bgG);
                } else if (com.baidu.swan.apps.console.debugger.b.Jk()) {
                    a.this.bgH = new com.baidu.swan.apps.console.v8inspector.a.b(d.JH(), a.this.bgG);
                }
                a.this.bgH.start();
            }
        }, "V8Inspector");
    }

    public void a(InterfaceC0228a interfaceC0228a) {
        this.bgG = interfaceC0228a;
    }
}
