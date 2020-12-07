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
    private static volatile IRemoteUBCService erl;
    private static Map<String, Integer> erm = new HashMap();
    private static Set<String> ern = new HashSet();

    static {
        ern.add("606");
        ern.add("671");
        erm.put("606", -1);
        erm.put("671", -1);
    }

    public static final l bfQ() {
        return com.baidu.swan.apps.z.b.aFE();
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
        if (com.baidu.swan.b.d.bgJ()) {
            p.bgn().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.afH()) {
            str2 = dD(str, str2);
        }
        if (com.baidu.swan.b.d.bgJ()) {
            p.bgn().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.afH()) {
            m(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bgJ()) {
            p.bgn().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow zw(String str) {
        return k(str, "", 0);
    }

    public static Flow k(String str, String str2, int i) {
        return p.bgn().k(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bfR() throws RemoteException {
        if (erl == null) {
            synchronized (e.class) {
                if (erl == null) {
                    IBinder K = IPCServiceManager.K("open_log", true);
                    if (K == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (K != null) {
                        erl = IRemoteUBCService.Stub.asInterface(K);
                    }
                }
            }
        }
        return erl;
    }

    private static String dD(String str, String str2) {
        l bfQ;
        Integer valueOf;
        if (ern.contains(str) && (bfQ = bfQ()) != null && bfQ.aFD()) {
            synchronized (e.class) {
                Integer num = erm.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bgy().getInt(str3, 0));
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
                    u.bgy().putInt("ubc_counter" + str, valueOf.intValue());
                    erm.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject m(String str, JSONObject jSONObject) {
        l bfQ;
        Integer valueOf;
        if (ern.contains(str) && (bfQ = bfQ()) != null && bfQ.aFD()) {
            synchronized (e.class) {
                Integer num = erm.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bgy().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bgy().putInt("ubc_counter" + str, valueOf.intValue());
                    erm.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
