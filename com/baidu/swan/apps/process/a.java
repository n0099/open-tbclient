package com.baidu.swan.apps.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aGs;
    private SwanAppMessengerService aGt;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0156a {
        void onReady();
    }

    private a() {
    }

    public static a Iu() {
        if (aGs == null) {
            synchronized (a.class) {
                if (aGs == null) {
                    aGs = new a();
                }
            }
        }
        return aGs;
    }

    private void a(final InterfaceC0156a interfaceC0156a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.aGt = SwanAppMessengerService.getServiceObject();
                if (interfaceC0156a != null) {
                    interfaceC0156a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.aGt = null;
            }
        }, 1);
    }

    public void b(InterfaceC0156a interfaceC0156a) {
        if (interfaceC0156a != null) {
            if (this.aGt == null) {
                a(interfaceC0156a);
            } else {
                interfaceC0156a.onReady();
            }
        }
    }
}
