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
    private static volatile IRemoteUBCService bPx;

    public static final k adf() {
        return com.baidu.swan.apps.z.b.Nf();
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
        k adf = adf();
        if (com.baidu.swan.b.d.adr()) {
            o.acT().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa() && adf != null) {
                adf.c(str, map, i);
            }
        } else if (adf != null) {
            adf.c(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k adf = adf();
        if (com.baidu.swan.b.d.adr()) {
            o.acT().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa() && adf != null) {
                adf.c(str, str2, i);
            }
        } else if (adf != null) {
            adf.c(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k adf = adf();
        if (com.baidu.swan.b.d.adr()) {
            o.acT().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa() && adf != null) {
                adf.c(str, jSONObject, i);
            }
        } else if (adf != null) {
            adf.c(str, jSONObject, i);
        }
    }

    public static final Flow lD(String str) {
        return g(str, "", 0);
    }

    public static Flow g(String str, String str2, int i) {
        return o.acT().g(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService acV() throws RemoteException {
        if (bPx == null) {
            synchronized (s.class) {
                if (bPx == null) {
                    IBinder k = IPCServiceManager.k("open_log", true);
                    if (k == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (k != null) {
                        bPx = IRemoteUBCService.Stub.asInterface(k);
                    }
                }
            }
        }
        return bPx;
    }
}
