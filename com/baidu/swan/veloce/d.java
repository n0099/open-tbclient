package com.baidu.swan.veloce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static boolean drb = false;
    private static boolean drc = false;
    private static String drd = "";
    private static String dre = "";
    private static HashMap<String, List<VeloceIpcResult.a>> drf = new HashMap<>();

    public static boolean aJo() {
        if (ProcessUtils.isMainProcess() && drc) {
            return drb;
        }
        DelegateResult k = k("veloce_is_veloce", null);
        if (k != null && k.isOk()) {
            drc = true;
            drb = k.mResult.getBoolean("is_veloce", false);
        }
        return drb;
    }

    public static String aJp() {
        if (TextUtils.isEmpty(drd)) {
            aJq();
        }
        return drd;
    }

    private static Bundle aJq() {
        DelegateResult k = k("veloce_get_host_info", null);
        if (k == null || !k.isOk()) {
            return null;
        }
        Bundle bundle = k.mResult;
        drd = bundle.getString("host_package");
        dre = bundle.getString("host_version");
        return bundle;
    }

    private static Bundle jD(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle j(String str, Bundle bundle) {
        Bundle jD;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                jD = null;
            } else {
                List<VeloceIpcResult.a> list = drf.get(str);
                if (list == null) {
                    jD = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    drf.remove(list);
                    jD = jD(0);
                }
            }
        }
        return jD;
    }

    public static DelegateResult k(@NonNull String str, @Nullable Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("data", bundle);
        return DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle2);
    }
}
