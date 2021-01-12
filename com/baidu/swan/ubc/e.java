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
/* loaded from: classes6.dex */
public class e {
    private static volatile IRemoteUBCService ewh;
    private static Map<String, Integer> ewi = new HashMap();
    private static Set<String> ewj = new HashSet();

    static {
        ewj.add("606");
        ewj.add("671");
        ewi.put("606", -1);
        ewi.put("671", -1);
    }

    public static final l beu() {
        return com.baidu.swan.apps.z.b.aDf();
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
        if (com.baidu.swan.b.d.bfn()) {
            p.beR().onEvent(str, map, i);
        }
    }

    public static void onEvent(String str, String str2, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            str2 = dB(str, str2);
        }
        if (com.baidu.swan.b.d.bfn()) {
            p.beR().onEvent(str, str2, i);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
            n(str, jSONObject);
        }
        if (com.baidu.swan.b.d.bfn()) {
            p.beR().onEvent(str, jSONObject, i);
        }
    }

    public static final Flow yk(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return p.beR().n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bev() throws RemoteException {
        if (ewh == null) {
            synchronized (e.class) {
                if (ewh == null) {
                    IBinder K = IPCServiceManager.K("open_log", true);
                    if (K == null) {
                        throw new RemoteException("Ceres get remote service empty !");
                    }
                    if (K != null) {
                        ewh = IRemoteUBCService.Stub.asInterface(K);
                    }
                }
            }
        }
        return ewh;
    }

    private static String dB(String str, String str2) {
        l beu;
        Integer valueOf;
        if (ewj.contains(str) && (beu = beu()) != null && beu.aDe()) {
            synchronized (e.class) {
                Integer num = ewi.get(str);
                if (num == null) {
                    num = -1;
                }
                String str3 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfc().getInt(str3, 0));
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
                    u.bfc().putInt("ubc_counter" + str, valueOf.intValue());
                    ewi.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return str2;
    }

    private static JSONObject n(String str, JSONObject jSONObject) {
        l beu;
        Integer valueOf;
        if (ewj.contains(str) && (beu = beu()) != null && beu.aDe()) {
            synchronized (e.class) {
                Integer num = ewi.get(str);
                if (num == null) {
                    num = -1;
                }
                String str2 = "ubc_counter" + str;
                if (num.intValue() == -1) {
                    num = Integer.valueOf(u.bfc().getInt(str2, 0));
                }
                try {
                    if (num.intValue() + 1 >= Integer.MAX_VALUE) {
                        valueOf = 0;
                    } else {
                        valueOf = Integer.valueOf(num.intValue() + 1);
                    }
                    jSONObject.put("counter", valueOf);
                    u.bfc().putInt("ubc_counter" + str, valueOf.intValue());
                    ewi.put(str, valueOf);
                } catch (JSONException e) {
                }
            }
        }
        return jSONObject;
    }
}
