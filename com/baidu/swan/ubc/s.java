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
/* loaded from: classes2.dex */
public class s {
    private static volatile IRemoteUBCService bxI;

    public static final k Yr() {
        return com.baidu.swan.apps.z.b.Ik();
    }

    public static final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    public static final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
    }

    public static final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, 0);
    }

    public static final void onEvent(String str, Map<String, String> map, int i) {
        k Yr = Yr();
        if (com.baidu.swan.b.d.YE()) {
            o.Yf().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vf() && Yr != null) {
                Yr.b(str, map, i);
            }
        } else if (Yr != null) {
            Yr.b(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k Yr = Yr();
        if (com.baidu.swan.b.d.YE()) {
            o.Yf().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vf() && Yr != null) {
                Yr.b(str, str2, i);
            }
        } else if (Yr != null) {
            Yr.b(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k Yr = Yr();
        if (com.baidu.swan.b.d.YE()) {
            o.Yf().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vf() && Yr != null) {
                Yr.b(str, jSONObject, i);
            }
        } else if (Yr != null) {
            Yr.b(str, jSONObject, i);
        }
    }

    public static final Flow lb(String str) {
        return g(str, "", 0);
    }

    public static Flow g(String str, String str2, int i) {
        return o.Yf().g(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService Yh() throws RemoteException {
        if (bxI == null) {
            synchronized (s.class) {
                if (bxI == null) {
                    IBinder h = IPCServiceManager.h("open_log", true);
                    if (h == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (h != null) {
                        bxI = IRemoteUBCService.Stub.asInterface(h);
                    }
                }
            }
        }
        return bxI;
    }
}
