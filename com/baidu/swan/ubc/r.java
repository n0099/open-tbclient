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
public class r {
    private static final boolean DEBUG = g.DEBUG;
    private static volatile IRemoteUBCService bpY;

    public static final k Ts() {
        return com.baidu.swan.apps.z.b.Fr();
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
        k Ts = Ts();
        if (com.baidu.swan.b.c.TE()) {
            o.Tl().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tR() && Ts != null) {
                Ts.b(str, map, i);
            }
        } else if (Ts != null) {
            Ts.b(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k Ts = Ts();
        if (com.baidu.swan.b.c.TE()) {
            o.Tl().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tR() && Ts != null) {
                Ts.b(str, str2, i);
            }
        } else if (Ts != null) {
            Ts.b(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k Ts = Ts();
        if (com.baidu.swan.b.c.TE()) {
            o.Tl().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tR() && Ts != null) {
                Ts.b(str, jSONObject, i);
            }
        } else if (Ts != null) {
            Ts.b(str, jSONObject, i);
        }
    }

    public static final Flow jS(String str) {
        return i(str, "", 0);
    }

    public static Flow i(String str, String str2, int i) {
        return o.Tl().i(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService Tm() throws RemoteException {
        if (bpY == null) {
            synchronized (r.class) {
                if (bpY == null) {
                    IBinder i = IPCServiceManager.i("open_log", true);
                    if (i == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (i != null) {
                        bpY = IRemoteUBCService.Stub.asInterface(i);
                    }
                }
            }
        }
        return bpY;
    }
}
