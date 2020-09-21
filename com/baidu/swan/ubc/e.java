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
/* loaded from: classes19.dex */
public class e {
    private static volatile IRemoteUBCService dLB;
    private static Map<String, Integer> dLC = new HashMap();
    private static Set<String> dLD = new HashSet();

    static {
        dLD.add("606");
        dLD.add("671");
        dLC.put("606", -1);
        dLC.put("671", -1);
    }

    public static final l aWr() {
        return com.baidu.swan.apps.z.b.avY();
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
        if (com.baidu.swan.b.d.aXk()) {
            p.aWO().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.WR()) {
            str2 = dl(str, str2);
        }
        if (com.baidu.swan.b.d.aXk()) {
            p.aWO().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.WR()) {
            k(str, jSONObject);
        }
        if (com.baidu.swan.b.d.aXk()) {
            p.aWO().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow xB(String str) {
        return j(str, "", 0);
    }

    public static Flow j(String str, String str2, int i) {
        return p.aWO().j(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aWs() throws RemoteException {
        if (dLB == null) {
            synchronized (e.class) {
                if (dLB == null) {
                    IBinder E = IPCServiceManager.E("open_log", true);
                    if (E == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (E != null) {
                        dLB = IRemoteUBCService.Stub.asInterface(E);
                    }
                }
            }
        }
        return dLB;
    }

    private static String dl(String str, String str2) {
        l aWr;
        Integer valueOf;
        if (dLD.contains(str) && (aWr = aWr()) != null && aWr.avX()) {
            synchronized (e.class) {
                Integer num = dLC.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aWZ().getInt(str3, 0));
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
                    u.aWZ().putInt("ubc_counter" + str, valueOf.intValue());
                    dLC.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject k(String str, JSONObject jSONObject) {
        l aWr;
        Integer valueOf;
        if (dLD.contains(str) && (aWr = aWr()) != null && aWr.avX()) {
            synchronized (e.class) {
                Integer num = dLC.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aWZ().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.aWZ().putInt("ubc_counter" + str, valueOf.intValue());
                    dLC.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
