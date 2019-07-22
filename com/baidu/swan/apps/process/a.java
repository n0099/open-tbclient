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
    private static volatile a aHa;
    private SwanAppMessengerService aHb;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0153a {
        void onReady();
    }

    private a() {
    }

    public static a Jh() {
        if (aHa == null) {
            synchronized (a.class) {
                if (aHa == null) {
                    aHa = new a();
                }
            }
        }
        return aHa;
    }

    private void a(final InterfaceC0153a interfaceC0153a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.aHb = SwanAppMessengerService.getServiceObject();
                if (interfaceC0153a != null) {
                    interfaceC0153a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.aHb = null;
            }
        }, 1);
    }

    public void b(InterfaceC0153a interfaceC0153a) {
        if (interfaceC0153a != null) {
            if (this.aHb == null) {
                a(interfaceC0153a);
            } else {
                interfaceC0153a.onReady();
            }
        }
    }
}
