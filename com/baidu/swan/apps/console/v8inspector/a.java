package com.baidu.swan.apps.console.v8inspector;

import android.content.Context;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.console.debugger.b.d;
import com.baidu.swan.apps.console.v8inspector.a.c;
/* loaded from: classes11.dex */
public class a {
    private InterfaceC0238a bkT;
    private b bkU;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.console.v8inspector.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0238a {
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
                if (com.baidu.swan.apps.console.debugger.b.LA()) {
                    a.this.bkU = new c(String.format("v8in%s_devtools_remote", a.this.mContext.getPackageName()), a.this.bkT);
                } else if (com.baidu.swan.apps.console.debugger.b.LB()) {
                    a.this.bkU = new com.baidu.swan.apps.console.v8inspector.a.b(d.LY(), a.this.bkT);
                }
                a.this.bkU.start();
            }
        }, "V8Inspector");
    }

    public void a(InterfaceC0238a interfaceC0238a) {
        this.bkT = interfaceC0238a;
    }
}
