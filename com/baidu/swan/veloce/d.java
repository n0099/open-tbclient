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
    private static boolean dfd = false;
    private static boolean dfe = false;
    private static String dff = "";
    private static String dfg = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dfh = new HashMap<>();

    public static boolean aEG() {
        if (ProcessUtils.isMainProcess() && dfe) {
            return dfd;
        }
        DelegateResult h = h("veloce_is_veloce", null);
        if (h != null && h.isOk()) {
            dfe = true;
            dfd = h.mResult.getBoolean("is_veloce", false);
        }
        return dfd;
    }

    public static String aEH() {
        if (TextUtils.isEmpty(dff)) {
            aEI();
        }
        return dff;
    }

    private static Bundle aEI() {
        DelegateResult h = h("veloce_get_host_info", null);
        if (h == null || !h.isOk()) {
            return null;
        }
        Bundle bundle = h.mResult;
        dff = bundle.getString("host_package");
        dfg = bundle.getString("host_version");
        return bundle;
    }

    private static Bundle ji(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle g(String str, Bundle bundle) {
        Bundle ji;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                ji = null;
            } else {
                List<VeloceIpcResult.a> list = dfh.get(str);
                if (list == null) {
                    ji = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dfh.remove(list);
                    ji = ji(0);
                }
            }
        }
        return ji;
    }

    public static DelegateResult h(@NonNull String str, @Nullable Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle("data", bundle);
        return DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle2);
    }
}
