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
    private static volatile a bau;
    private SwanAppMessengerService bav;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0194a {
        void onReady();
    }

    private a() {
    }

    public static a Og() {
        if (bau == null) {
            synchronized (a.class) {
                if (bau == null) {
                    bau = new a();
                }
            }
        }
        return bau;
    }

    private void a(final InterfaceC0194a interfaceC0194a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.bav = SwanAppMessengerService.getServiceObject();
                if (interfaceC0194a != null) {
                    interfaceC0194a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.bav = null;
            }
        }, 1);
    }

    public void b(InterfaceC0194a interfaceC0194a) {
        if (interfaceC0194a != null) {
            if (this.bav == null) {
                a(interfaceC0194a);
            } else {
                interfaceC0194a.onReady();
            }
        }
    }
}
