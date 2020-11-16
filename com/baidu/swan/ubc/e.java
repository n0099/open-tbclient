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
    private static volatile IRemoteUBCService ekj;
    private static Map<String, Integer> ekk = new HashMap();
    private static Set<String> ekl = new HashSet();

    static {
        ekl.add("606");
        ekl.add("671");
        ekk.put("606", -1);
        ekk.put("671", -1);
    }

    public static final l bcL() {
        return com.baidu.swan.apps.z.b.aCv();
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
        if (com.baidu.swan.b.d.bdE()) {
            p.bdi().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
            str2 = dw(str, str2);
        }
        if (com.baidu.swan.b.d.bdE()) {
            p.bdi().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
            m(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bdE()) {
            p.bdi().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yP(String str) {
        return k(str, "", 0);
    }

    public static Flow k(String str, String str2, int i) {
        return p.bdi().k(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bcM() throws RemoteException {
        if (ekj == null) {
            synchronized (e.class) {
                if (ekj == null) {
                    IBinder J = IPCServiceManager.J("open_log", true);
                    if (J == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (J != null) {
                        ekj = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return ekj;
    }

    private static String dw(String str, String str2) {
        l bcL;
        Integer valueOf;
        if (ekl.contains(str) && (bcL = bcL()) != null && bcL.aCu()) {
            synchronized (e.class) {
                Integer num = ekk.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bdt().getInt(str3, 0));
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
                    u.bdt().putInt("ubc_counter" + str, valueOf.intValue());
                    ekk.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject m(String str, JSONObject jSONObject) {
        l bcL;
        Integer valueOf;
        if (ekl.contains(str) && (bcL = bcL()) != null && bcL.aCu()) {
            synchronized (e.class) {
                Integer num = ekk.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bdt().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bdt().putInt("ubc_counter" + str, valueOf.intValue());
                    ekk.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
