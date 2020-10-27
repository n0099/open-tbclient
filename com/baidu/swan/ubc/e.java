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
    private static volatile IRemoteUBCService efY;
    private static Map<String, Integer> efZ = new HashMap();
    private static Set<String> ega = new HashSet();

    static {
        ega.add("606");
        ega.add("671");
        efZ.put("606", -1);
        efZ.put("671", -1);
    }

    public static final l baS() {
        return com.baidu.swan.apps.z.b.aAD();
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
        if (com.baidu.swan.b.d.bbL()) {
            p.bbp().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aaH()) {
            str2 = dx(str, str2);
        }
        if (com.baidu.swan.b.d.bbL()) {
            p.bbp().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.aaH()) {
            k(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bbL()) {
            p.bbp().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yG(String str) {
        return j(str, "", 0);
    }

    public static Flow j(String str, String str2, int i) {
        return p.bbp().j(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService baT() throws RemoteException {
        if (efY == null) {
            synchronized (e.class) {
                if (efY == null) {
                    IBinder J = IPCServiceManager.J("open_log", true);
                    if (J == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (J != null) {
                        efY = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return efY;
    }

    private static String dx(String str, String str2) {
        l baS;
        Integer valueOf;
        if (ega.contains(str) && (baS = baS()) != null && baS.aAC()) {
            synchronized (e.class) {
                Integer num = efZ.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bbA().getInt(str3, 0));
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
                    u.bbA().putInt("ubc_counter" + str, valueOf.intValue());
                    efZ.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject k(String str, JSONObject jSONObject) {
        l baS;
        Integer valueOf;
        if (ega.contains(str) && (baS = baS()) != null && baS.aAC()) {
            synchronized (e.class) {
                Integer num = efZ.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bbA().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bbA().putInt("ubc_counter" + str, valueOf.intValue());
                    efZ.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
