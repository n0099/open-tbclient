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
    private static volatile IRemoteUBCService dpJ;
    private static Map<String, Integer> dpK = new HashMap();
    private static Set<String> dpL = new HashSet();

    static {
        dpL.add("606");
        dpL.add("671");
        dpK.put("606", -1);
        dpK.put("671", -1);
    }

    public static final l aIh() {
        return com.baidu.swan.apps.ab.b.akV();
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
        if (com.baidu.swan.d.d.aJb()) {
            p.aIF().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            str2 = cQ(str, str2);
        }
        if (com.baidu.swan.d.d.aJb()) {
            p.aIF().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
            l(str, jSONObject);
        }
        if (com.baidu.swan.d.d.aJb()) {
            p.aIF().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow tL(String str) {
        return i(str, "", 0);
    }

    public static Flow i(String str, String str2, int i) {
        return p.aIF().i(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aIi() throws RemoteException {
        if (dpJ == null) {
            synchronized (e.class) {
                if (dpJ == null) {
                    IBinder x = IPCServiceManager.x("open_log", true);
                    if (x == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (x != null) {
                        dpJ = IRemoteUBCService.Stub.asInterface(x);
                    }
                }
            }
        }
        return dpJ;
    }

    private static String cQ(String str, String str2) {
        l aIh;
        Integer valueOf;
        if (dpL.contains(str) && (aIh = aIh()) != null && aIh.akU()) {
            synchronized (e.class) {
                Integer num = dpK.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aIQ().getInt(str3, 0));
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
                    u.aIQ().putInt("ubc_counter" + str, valueOf.intValue());
                    dpK.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject l(String str, JSONObject jSONObject) {
        l aIh;
        Integer valueOf;
        if (dpL.contains(str) && (aIh = aIh()) != null && aIh.akU()) {
            synchronized (e.class) {
                Integer num = dpK.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aIQ().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.aIQ().putInt("ubc_counter" + str, valueOf.intValue());
                    dpK.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
