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
    private static volatile IRemoteUBCService bwt;

    public static final k Xr() {
        return com.baidu.swan.apps.z.b.Hu();
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
        k Xr = Xr();
        if (com.baidu.swan.b.d.XE()) {
            o.Xg().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.uB() && Xr != null) {
                Xr.b(str, map, i);
            }
        } else if (Xr != null) {
            Xr.b(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k Xr = Xr();
        if (com.baidu.swan.b.d.XE()) {
            o.Xg().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.uB() && Xr != null) {
                Xr.b(str, str2, i);
            }
        } else if (Xr != null) {
            Xr.b(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k Xr = Xr();
        if (com.baidu.swan.b.d.XE()) {
            o.Xg().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.uB() && Xr != null) {
                Xr.b(str, jSONObject, i);
            }
        } else if (Xr != null) {
            Xr.b(str, jSONObject, i);
        }
    }

    public static final Flow kS(String str) {
        return g(str, "", 0);
    }

    public static Flow g(String str, String str2, int i) {
        return o.Xg().g(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService Xi() throws RemoteException {
        if (bwt == null) {
            synchronized (s.class) {
                if (bwt == null) {
                    IBinder h = IPCServiceManager.h("open_log", true);
                    if (h == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (h != null) {
                        bwt = IRemoteUBCService.Stub.asInterface(h);
                    }
                }
            }
        }
        return bwt;
    }
}
