package com.baidu.swan.apps.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aEw;
    private SwanAppMessengerService aEx;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0151a {
        void onReady();
    }

    private a() {
    }

    public static a Gk() {
        if (aEw == null) {
            synchronized (a.class) {
                if (aEw == null) {
                    aEw = new a();
                }
            }
        }
        return aEw;
    }

    private void a(final InterfaceC0151a interfaceC0151a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.aEx = SwanAppMessengerService.getServiceObject();
                if (interfaceC0151a != null) {
                    interfaceC0151a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.aEx = null;
            }
        }, 1);
    }

    public void b(InterfaceC0151a interfaceC0151a) {
        if (interfaceC0151a != null) {
            if (this.aEx == null) {
                a(interfaceC0151a);
            } else {
                interfaceC0151a.onReady();
            }
        }
    }
}
