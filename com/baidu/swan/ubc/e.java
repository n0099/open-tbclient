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
    private static volatile IRemoteUBCService duv;
    private static Map<String, Integer> duw = new HashMap();
    private static Set<String> dux = new HashSet();

    static {
        dux.add("606");
        dux.add("671");
        duw.put("606", -1);
        duw.put("671", -1);
    }

    public static final l aJn() {
        return com.baidu.swan.apps.ab.b.amb();
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
        if (com.baidu.swan.d.d.aKh()) {
            p.aJL().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.PY()) {
            str2 = cS(str, str2);
        }
        if (com.baidu.swan.d.d.aKh()) {
            p.aJL().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.PY()) {
            l(str, jSONObject);
        }
        if (com.baidu.swan.d.d.aKh()) {
            p.aJL().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow tT(String str) {
        return i(str, "", 0);
    }

    public static Flow i(String str, String str2, int i) {
        return p.aJL().i(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService aJo() throws RemoteException {
        if (duv == null) {
            synchronized (e.class) {
                if (duv == null) {
                    IBinder z = IPCServiceManager.z("open_log", true);
                    if (z == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (z != null) {
                        duv = IRemoteUBCService.Stub.asInterface(z);
                    }
                }
            }
        }
        return duv;
    }

    private static String cS(String str, String str2) {
        l aJn;
        Integer valueOf;
        if (dux.contains(str) && (aJn = aJn()) != null && aJn.ama()) {
            synchronized (e.class) {
                Integer num = duw.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aJW().getInt(str3, 0));
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
                    u.aJW().putInt("ubc_counter" + str, valueOf.intValue());
                    duw.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject l(String str, JSONObject jSONObject) {
        l aJn;
        Integer valueOf;
        if (dux.contains(str) && (aJn = aJn()) != null && aJn.ama()) {
            synchronized (e.class) {
                Integer num = duw.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.aJW().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.aJW().putInt("ubc_counter" + str, valueOf.intValue());
                    duw.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
