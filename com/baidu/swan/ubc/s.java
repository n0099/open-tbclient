package com.baidu.swan.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.IRemoteUBCService;
import java.util.Map;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class s {
    private static volatile IRemoteUBCService cBn;

    public static final k atk() {
        return com.baidu.swan.apps.ad.b.WG();
    }

    public static final void onEvent(String str) {
        l(str, "", 0);
    }

    public static final void onEvent(String str, String str2) {
        l(str, str2, 0);
    }

    public static final void k(String str, JSONObject jSONObject) {
        b(str, jSONObject, 0);
    }

    public static final void i(String str, Map<String, String> map) {
        a(str, map, 0);
    }

    public static final void a(String str, Map<String, String> map, int i) {
        k atk = atk();
        if (com.baidu.swan.c.d.atw()) {
            o.asY().a(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.BX() && atk != null) {
                atk.c(str, map, i);
            }
        } else if (atk != null) {
            atk.c(str, map, i);
        }
    }

    public static void l(String str, String str2, int i) {
        k atk = atk();
        if (com.baidu.swan.c.d.atw()) {
            o.asY().l(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.BX() && atk != null) {
                atk.c(str, str2, i);
            }
        } else if (atk != null) {
            atk.c(str, str2, i);
        }
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        k atk = atk();
        if (com.baidu.swan.c.d.atw()) {
            o.asY().b(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.BX() && atk != null) {
                atk.c(str, jSONObject, i);
            }
        } else if (atk != null) {
            atk.c(str, jSONObject, i);
        }
    }

    public static final Flow qJ(String str) {
        return k(str, "", 0);
    }

    public static Flow k(String str, String str2, int i) {
        return o.asY().k(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService ata() throws RemoteException {
        if (cBn == null) {
            synchronized (s.class) {
                if (cBn == null) {
                    IBinder o = IPCServiceManager.o("open_log", true);
                    if (o == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (o != null) {
                        cBn = IRemoteUBCService.Stub.asInterface(o);
                    }
                }
            }
        }
        return cBn;
    }
}
