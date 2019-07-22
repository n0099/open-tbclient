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
    private static volatile IRemoteUBCService bxk;

    public static final k Yn() {
        return com.baidu.swan.apps.z.b.Ig();
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
        k Yn = Yn();
        if (com.baidu.swan.b.d.YA()) {
            o.Yb().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vb() && Yn != null) {
                Yn.b(str, map, i);
            }
        } else if (Yn != null) {
            Yn.b(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k Yn = Yn();
        if (com.baidu.swan.b.d.YA()) {
            o.Yb().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vb() && Yn != null) {
                Yn.b(str, str2, i);
            }
        } else if (Yn != null) {
            Yn.b(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k Yn = Yn();
        if (com.baidu.swan.b.d.YA()) {
            o.Yb().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.vb() && Yn != null) {
                Yn.b(str, jSONObject, i);
            }
        } else if (Yn != null) {
            Yn.b(str, jSONObject, i);
        }
    }

    public static final Flow kZ(String str) {
        return g(str, "", 0);
    }

    public static Flow g(String str, String str2, int i) {
        return o.Yb().g(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService Yd() throws RemoteException {
        if (bxk == null) {
            synchronized (s.class) {
                if (bxk == null) {
                    IBinder h = IPCServiceManager.h("open_log", true);
                    if (h == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (h != null) {
                        bxk = IRemoteUBCService.Stub.asInterface(h);
                    }
                }
            }
        }
        return bxk;
    }
}
