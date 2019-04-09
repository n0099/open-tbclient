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
public class q {
    private static volatile IRemoteUBCService bqd;

    public static final j Tq() {
        return com.baidu.swan.apps.z.b.Fp();
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
        j Tq = Tq();
        if (com.baidu.swan.b.c.TC()) {
            n.Tj().onEvent(str, map, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tQ() && Tq != null) {
                Tq.b(str, map, i);
            }
        } else if (Tq != null) {
            Tq.b(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        j Tq = Tq();
        if (com.baidu.swan.b.c.TC()) {
            n.Tj().onEvent(str, str2, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tQ() && Tq != null) {
                Tq.b(str, str2, i);
            }
        } else if (Tq != null) {
            Tq.b(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        j Tq = Tq();
        if (com.baidu.swan.b.c.TC()) {
            n.Tj().onEvent(str, jSONObject, i);
            if (com.baidu.pyramid.runtime.multiprocess.a.tQ() && Tq != null) {
                Tq.b(str, jSONObject, i);
            }
        } else if (Tq != null) {
            Tq.b(str, jSONObject, i);
        }
    }

    public static final Flow jT(String str) {
        return i(str, "", 0);
    }

    public static Flow i(String str, String str2, int i) {
        return n.Tj().i(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService Tk() throws RemoteException {
        if (bqd == null) {
            synchronized (q.class) {
                if (bqd == null) {
                    IBinder i = IPCServiceManager.i("open_log", true);
                    if (i == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (i != null) {
                        bqd = IRemoteUBCService.Stub.asInterface(i);
                    }
                }
            }
        }
        return bqd;
    }
}
