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
    private static volatile a baM;
    private SwanAppMessengerService baN;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0199a {
        void onReady();
    }

    private a() {
    }

    public static a Of() {
        if (baM == null) {
            synchronized (a.class) {
                if (baM == null) {
                    baM = new a();
                }
            }
        }
        return baM;
    }

    private void a(final InterfaceC0199a interfaceC0199a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.baN = SwanAppMessengerService.getServiceObject();
                if (interfaceC0199a != null) {
                    interfaceC0199a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.baN = null;
            }
        }, 1);
    }

    public void b(InterfaceC0199a interfaceC0199a) {
        if (interfaceC0199a != null) {
            if (this.baN == null) {
                a(interfaceC0199a);
            } else {
                interfaceC0199a.onReady();
            }
        }
    }
}
