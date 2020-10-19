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
/* loaded from: classes20.dex */
public class e {
    private static volatile IRemoteUBCService dXC;
    private static Map<String, Integer> dXD = new HashMap();
    private static Set<String> dXE = new HashSet();

    static {
        dXE.add("606");
        dXE.add("671");
        dXD.put("606", -1);
        dXD.put("671", -1);
    }

    public static final l aYZ() {
        return com.baidu.swan.apps.z.b.ayJ();
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
        if (com.baidu.swan.b.d.aZS()) {
            p.aZw().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
            str2 = dq(str, str2);
        }
        if (com.baidu.swan.b.d.aZS()) {
            p.aZw().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
            k(str, jSONObject);
        }
        if (com.baidu.swan.b.d.aZS()) {
            p.aZw().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yn(String str) {
        return j(str, "", 0);
    }

    public static Flow j(String str, String str2, int i) {
        return p.aZw().j(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aZa() throws RemoteException {
        if (dXC == null) {
            synchronized (e.class) {
                if (dXC == null) {
                    IBinder H = IPCServiceManager.H("open_log", true);
                    if (H == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (H != null) {
                        dXC = IRemoteUBCService.Stub.asInterface(H);
                    }
                }
            }
        }
        return dXC;
    }

    private static String dq(String str, String str2) {
        l aYZ;
        Integer valueOf;
        if (dXE.contains(str) && (aYZ = aYZ()) != null && aYZ.ayI()) {
            synchronized (e.class) {
                Integer num = dXD.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aZH().getInt(str3, 0));
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
                    u.aZH().putInt("ubc_counter" + str, valueOf.intValue());
                    dXD.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject k(String str, JSONObject jSONObject) {
        l aYZ;
        Integer valueOf;
        if (dXE.contains(str) && (aYZ = aYZ()) != null && aYZ.ayI()) {
            synchronized (e.class) {
                Integer num = dXD.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aZH().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.aZH().putInt("ubc_counter" + str, valueOf.intValue());
                    dXD.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
