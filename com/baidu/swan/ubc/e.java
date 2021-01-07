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
    private static volatile IRemoteUBCService eAW;
    private static Map<String, Integer> eAX = new HashMap();
    private static Set<String> eAY = new HashSet();

    static {
        eAY.add("606");
        eAY.add("671");
        eAX.put("606", -1);
        eAX.put("671", -1);
    }

    public static final l bio() {
        return com.baidu.swan.apps.z.b.aGZ();
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
        if (com.baidu.swan.b.d.bjh()) {
            p.biL().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
            str2 = dC(str, str2);
        }
        if (com.baidu.swan.b.d.bjh()) {
            p.biL().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
            n(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bjh()) {
            p.biL().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow zv(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return p.biL().n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bip() throws RemoteException {
        if (eAW == null) {
            synchronized (e.class) {
                if (eAW == null) {
                    IBinder K = IPCServiceManager.K("open_log", true);
                    if (K == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (K != null) {
                        eAW = IRemoteUBCService.Stub.asInterface(K);
                    }
                }
            }
        }
        return eAW;
    }

    private static String dC(String str, String str2) {
        l bio;
        Integer valueOf;
        if (eAY.contains(str) && (bio = bio()) != null && bio.aGY()) {
            synchronized (e.class) {
                Integer num = eAX.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.biW().getInt(str3, 0));
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
                    u.biW().putInt("ubc_counter" + str, valueOf.intValue());
                    eAX.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject n(String str, JSONObject jSONObject) {
        l bio;
        Integer valueOf;
        if (eAY.contains(str) && (bio = bio()) != null && bio.aGY()) {
            synchronized (e.class) {
                Integer num = eAX.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.biW().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.biW().putInt("ubc_counter" + str, valueOf.intValue());
                    eAX.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
