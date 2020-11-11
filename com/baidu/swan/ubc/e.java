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
    private static volatile IRemoteUBCService elQ;
    private static Map<String, Integer> elR = new HashMap();
    private static Set<String> elS = new HashSet();

    static {
        elS.add("606");
        elS.add("671");
        elR.put("606", -1);
        elR.put("671", -1);
    }

    public static final l bds() {
        return com.baidu.swan.apps.z.b.aDd();
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
        if (com.baidu.swan.b.d.bel()) {
            p.bdP().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
            str2 = dx(str, str2);
        }
        if (com.baidu.swan.b.d.bel()) {
            p.bdP().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
            m(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bel()) {
            p.bdP().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yU(String str) {
        return k(str, "", 0);
    }

    public static Flow k(String str, String str2, int i) {
        return p.bdP().k(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bdt() throws RemoteException {
        if (elQ == null) {
            synchronized (e.class) {
                if (elQ == null) {
                    IBinder J = IPCServiceManager.J("open_log", true);
                    if (J == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (J != null) {
                        elQ = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return elQ;
    }

    private static String dx(String str, String str2) {
        l bds;
        Integer valueOf;
        if (elS.contains(str) && (bds = bds()) != null && bds.aDc()) {
            synchronized (e.class) {
                Integer num = elR.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bea().getInt(str3, 0));
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
                    u.bea().putInt("ubc_counter" + str, valueOf.intValue());
                    elR.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject m(String str, JSONObject jSONObject) {
        l bds;
        Integer valueOf;
        if (elS.contains(str) && (bds = bds()) != null && bds.aDc()) {
            synchronized (e.class) {
                Integer num = elR.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bea().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bea().putInt("ubc_counter" + str, valueOf.intValue());
                    elR.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
