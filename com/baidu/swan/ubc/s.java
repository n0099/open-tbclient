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
    private static volatile IRemoteUBCService cFw;

    public static final k avR() {
        return com.baidu.swan.apps.ad.b.Zr();
    }

    public static final void onEvent(String str) {
        k(str, "", 0);
    }

    public static final void onEvent(String str, String str2) {
        k(str, str2, 0);
    }

    public static final void k(String str, JSONObject jSONObject) {
        b(str, jSONObject, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        a(str, map, 0);
    }

    public static final void a(String str, Map<String, String> map, int i) {
        k avR = avR();
        if (com.baidu.swan.c.d.awd()) {
            o.avF().a(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.EP() && avR != null) {
                avR.c(str, map, i);
            }
        } else if (avR != null) {
            avR.c(str, map, i);
        }
    }

    public static void k(String str, String str2, int i) {
        k avR = avR();
        if (com.baidu.swan.c.d.awd()) {
            o.avF().k(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.EP() && avR != null) {
                avR.c(str, str2, i);
            }
        } else if (avR != null) {
            avR.c(str, str2, i);
        }
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        k avR = avR();
        if (com.baidu.swan.c.d.awd()) {
            o.avF().b(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.EP() && avR != null) {
                avR.c(str, jSONObject, i);
            }
        } else if (avR != null) {
            avR.c(str, jSONObject, i);
        }
    }

    public static final Flow rb(String str) {
        return j(str, "", 0);
    }

    public static Flow j(String str, String str2, int i) {
        return o.avF().j(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService avH() throws RemoteException {
        if (cFw == null) {
            synchronized (s.class) {
                if (cFw == null) {
                    IBinder o = IPCServiceManager.o("open_log", true);
                    if (o == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (o != null) {
                        cFw = IRemoteUBCService.Stub.asInterface(o);
                    }
                }
            }
        }
        return cFw;
    }
}
