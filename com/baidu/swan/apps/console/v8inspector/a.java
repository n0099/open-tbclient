package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
/* loaded from: classes11.dex */
public class a {
    private InterfaceC0268a bJp;
    private b bJq;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0268a {
        void onConnected();
    }

    /* loaded from: classes11.dex */
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
                if (com.baidu.swan.apps.console.debugger.b.Tr()) {
                    a.this.bJq = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bJp);
                } else if (com.baidu.swan.apps.console.debugger.b.Ts()) {
                    a.this.bJq = new com.baidu.swan.apps.console.v8inspector.a.b(d.TP(), a.this.bJp);
                }
                a.this.bJq.start();
            }
        }, "V8Inspector");
    }

    public void a(InterfaceC0268a interfaceC0268a) {
        this.bJp = interfaceC0268a;
    }
}
