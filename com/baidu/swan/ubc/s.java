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
/* loaded from: classes7.dex */
public class s {
    private static volatile IRemoteUBCService deP;

    public static final k aEh() {
        return com.baidu.swan.apps.ad.b.ahA();
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
        k aEh = aEh();
        if (com.baidu.swan.c.d.aEt()) {
            o.aDV().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.MF() && aEh != null) {
                aEh.c(str, map, i);
            }
        } else if (aEh != null) {
            aEh.c(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        k aEh = aEh();
        if (com.baidu.swan.c.d.aEt()) {
            o.aDV().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.MF() && aEh != null) {
                aEh.c(str, str2, i);
            }
        } else if (aEh != null) {
            aEh.c(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        k aEh = aEh();
        if (com.baidu.swan.c.d.aEt()) {
            o.aDV().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.MF() && aEh != null) {
                aEh.c(str, jSONObject, i);
            }
        } else if (aEh != null) {
            aEh.c(str, jSONObject, i);
        }
    }

    public static final Flow sn(String str) {
        return j(str, "", 0);
    }

    public static Flow j(String str, String str2, int i) {
        return o.aDV().j(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aDX() throws RemoteException {
        if (deP == null) {
            synchronized (s.class) {
                if (deP == null) {
                    IBinder t = IPCServiceManager.t("open_log", true);
                    if (t == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (t != null) {
                        deP = IRemoteUBCService.Stub.asInterface(t);
                    }
                }
            }
        }
        return deP;
    }
}
