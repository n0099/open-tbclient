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
/* loaded from: classes5.dex */
public class s {
    private static volatile IRemoteUBCService cBy;

    public static final k atD() {
        return com.baidu.swan.apps.ad.b.Xd();
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
        k atD = atD();
        if (com.baidu.swan.c.d.atP()) {
            o.atr().a(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Ct() && atD != null) {
                atD.c(str, map, i);
            }
        } else if (atD != null) {
            atD.c(str, map, i);
        }
    }

    public static void l(String str, String str2, int i) {
        k atD = atD();
        if (com.baidu.swan.c.d.atP()) {
            o.atr().l(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Ct() && atD != null) {
                atD.c(str, str2, i);
            }
        } else if (atD != null) {
            atD.c(str, str2, i);
        }
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        k atD = atD();
        if (com.baidu.swan.c.d.atP()) {
            o.atr().b(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Ct() && atD != null) {
                atD.c(str, jSONObject, i);
            }
        } else if (atD != null) {
            atD.c(str, jSONObject, i);
        }
    }

    public static final Flow qM(String str) {
        return k(str, "", 0);
    }

    public static Flow k(String str, String str2, int i) {
        return o.atr().k(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService att() throws RemoteException {
        if (cBy == null) {
            synchronized (s.class) {
                if (cBy == null) {
                    IBinder o = IPCServiceManager.o("open_log", true);
                    if (o == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (o != null) {
                        cBy = IRemoteUBCService.Stub.asInterface(o);
                    }
                }
            }
        }
        return cBy;
    }
}
