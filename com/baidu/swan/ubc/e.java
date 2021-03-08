package com.baidu.swan.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.IRemoteUBCService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    private static volatile IRemoteUBCService ezR;
    private static Map<String, Integer> ezS = new HashMap();
    private static Set<String> ezT = new HashSet();

    static {
        ezT.add("606");
        ezT.add("671");
        ezS.put("606", -1);
        ezS.put("671", -1);
    }

    public static final l beJ() {
        return com.baidu.swan.apps.z.b.aDE();
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
        if (com.baidu.swan.b.d.bfC()) {
            p.bfg().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            str2 = dv(str, str2);
        }
        if (com.baidu.swan.b.d.bfC()) {
            p.bfg().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
            o(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bfC()) {
            p.bfg().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yK(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return p.bfg().n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService beK() throws RemoteException {
        if (ezR == null) {
            synchronized (e.class) {
                if (ezR == null) {
                    IBinder J = IPCServiceManager.J("open_log", true);
                    if (J == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (J != null) {
                        ezR = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return ezR;
    }

    private static String dv(String str, String str2) {
        l beJ;
        Integer valueOf;
        if (ezT.contains(str) && (beJ = beJ()) != null && beJ.aDD()) {
            synchronized (e.class) {
                Integer num = ezS.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfr().getInt(str3, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    JSONObject jSONObject = new JSONObject(str2);
                    jSONObject.put("counter", valueOf);
                    str2 = jSONObject.toString();
                    u.bfr().putInt("ubc_counter" + str, valueOf.intValue());
                    ezS.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject o(String str, JSONObject jSONObject) {
        l beJ;
        Integer valueOf;
        if (ezT.contains(str) && (beJ = beJ()) != null && beJ.aDD()) {
            synchronized (e.class) {
                Integer num = ezS.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfr().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bfr().putInt("ubc_counter" + str, valueOf.intValue());
                    ezS.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
