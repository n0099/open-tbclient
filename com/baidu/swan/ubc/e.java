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
/* loaded from: classes14.dex */
public class e {
    private static volatile IRemoteUBCService dAk;
    private static Map<String, Integer> dAl = new HashMap();
    private static Set<String> dAm = new HashSet();

    static {
        dAm.add("606");
        dAm.add("671");
        dAl.put("606", -1);
        dAl.put("671", -1);
    }

    public static final l aNf() {
        return com.baidu.swan.apps.aa.b.anu();
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
        if (com.baidu.swan.c.d.aNY()) {
            p.aNC().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            str2 = cV(str, str2);
        }
        if (com.baidu.swan.c.d.aNY()) {
            p.aNC().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
            l(str, jSONObject);
        }
        if (com.baidu.swan.c.d.aNY()) {
            p.aNC().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow uW(String str) {
        return i(str, "", 0);
    }

    public static Flow i(String str, String str2, int i) {
        return p.aNC().i(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aNg() throws RemoteException {
        if (dAk == null) {
            synchronized (e.class) {
                if (dAk == null) {
                    IBinder z = IPCServiceManager.z("open_log", true);
                    if (z == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (z != null) {
                        dAk = IRemoteUBCService.Stub.asInterface(z);
                    }
                }
            }
        }
        return dAk;
    }

    private static String cV(String str, String str2) {
        l aNf;
        Integer valueOf;
        if (dAm.contains(str) && (aNf = aNf()) != null && aNf.ant()) {
            synchronized (e.class) {
                Integer num = dAl.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aNN().getInt(str3, 0));
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
                    u.aNN().putInt("ubc_counter" + str, valueOf.intValue());
                    dAl.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject l(String str, JSONObject jSONObject) {
        l aNf;
        Integer valueOf;
        if (dAm.contains(str) && (aNf = aNf()) != null && aNf.ant()) {
            synchronized (e.class) {
                Integer num = dAl.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aNN().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.aNN().putInt("ubc_counter" + str, valueOf.intValue());
                    dAl.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
