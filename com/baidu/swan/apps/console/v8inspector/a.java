package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
/* loaded from: classes11.dex */
public class a {
    private InterfaceC0289a bJu;
    private b bJv;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0289a {
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
                if (com.baidu.swan.apps.console.debugger.b.Tq()) {
                    a.this.bJv = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bJu);
                } else if (com.baidu.swan.apps.console.debugger.b.Tr()) {
                    a.this.bJv = new com.baidu.swan.apps.console.v8inspector.a.b(d.TO(), a.this.bJu);
                }
                a.this.bJv.start();
            }
        }, "V8Inspector");
    }

    public void a(InterfaceC0289a interfaceC0289a) {
        this.bJu = interfaceC0289a;
    }
}
