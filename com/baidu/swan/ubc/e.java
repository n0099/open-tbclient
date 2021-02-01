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
/* loaded from: classes7.dex */
public class e {
    private static volatile IRemoteUBCService eyq;
    private static Map<String, Integer> eyr = new HashMap();
    private static Set<String> eys = new HashSet();

    static {
        eys.add("606");
        eys.add("671");
        eyr.put("606", -1);
        eyr.put("671", -1);
    }

    public static final l beH() {
        return com.baidu.swan.apps.z.b.aDB();
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
        if (com.baidu.swan.b.d.bfA()) {
            p.bfe().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            str2 = dv(str, str2);
        }
        if (com.baidu.swan.b.d.bfA()) {
            p.bfe().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
            n(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bfA()) {
            p.bfe().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yD(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return p.bfe().n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService beI() throws RemoteException {
        if (eyq == null) {
            synchronized (e.class) {
                if (eyq == null) {
                    IBinder J = IPCServiceManager.J("open_log", true);
                    if (J == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (J != null) {
                        eyq = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return eyq;
    }

    private static String dv(String str, String str2) {
        l beH;
        Integer valueOf;
        if (eys.contains(str) && (beH = beH()) != null && beH.aDA()) {
            synchronized (e.class) {
                Integer num = eyr.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfp().getInt(str3, 0));
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
                    u.bfp().putInt("ubc_counter" + str, valueOf.intValue());
                    eyr.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject n(String str, JSONObject jSONObject) {
        l beH;
        Integer valueOf;
        if (eys.contains(str) && (beH = beH()) != null && beH.aDA()) {
            synchronized (e.class) {
                Integer num = eyr.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfp().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bfp().putInt("ubc_counter" + str, valueOf.intValue());
                    eyr.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
