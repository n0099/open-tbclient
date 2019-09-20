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
    private static volatile a aHy;
    private SwanAppMessengerService aHz;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0167a {
        void onReady();
    }

    private a() {
    }

    public static a Jl() {
        if (aHy == null) {
            synchronized (a.class) {
                if (aHy == null) {
                    aHy = new a();
                }
            }
        }
        return aHy;
    }

    private void a(final InterfaceC0167a interfaceC0167a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.aHz = SwanAppMessengerService.getServiceObject();
                if (interfaceC0167a != null) {
                    interfaceC0167a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.aHz = null;
            }
        }, 1);
    }

    public void b(InterfaceC0167a interfaceC0167a) {
        if (interfaceC0167a != null) {
            if (this.aHz == null) {
                a(interfaceC0167a);
            } else {
                interfaceC0167a.onReady();
            }
        }
    }
}
