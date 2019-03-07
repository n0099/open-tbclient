package com.baidu.swan.apps.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = c.DEBUG;
    private static volatile a aEv;
    private SwanAppMessengerService aEw;

    /* renamed from: com.baidu.swan.apps.process.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0122a {
        void onReady();
    }

    private a() {
    }

    public static a Gk() {
        if (aEv == null) {
            synchronized (a.class) {
                if (aEv == null) {
                    aEv = new a();
                }
            }
        }
        return aEv;
    }

    private void a(final InterfaceC0122a interfaceC0122a) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, SwanAppMessengerService.class), new ServiceConnection() { // from class: com.baidu.swan.apps.process.a.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                a.this.aEw = SwanAppMessengerService.getServiceObject();
                if (interfaceC0122a != null) {
                    interfaceC0122a.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                a.this.aEw = null;
            }
        }, 1);
    }

    public void b(InterfaceC0122a interfaceC0122a) {
        if (interfaceC0122a != null) {
            if (this.aEw == null) {
                a(interfaceC0122a);
            } else {
                interfaceC0122a.onReady();
            }
        }
    }
}
