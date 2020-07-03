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
    private static boolean dvN = false;
    private static boolean dvO = false;
    private static String dvP = "";
    private static String dvQ = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dvR = new HashMap<>();

    public static boolean aKu() {
        if (ProcessUtils.isMainProcess() && dvO) {
            return dvN;
        }
        DelegateResult k = k("veloce_is_veloce", null);
        if (k != null && k.isOk()) {
            dvO = true;
            dvN = k.mResult.getBoolean("is_veloce", false);
        }
        return dvN;
    }

    public static String aKv() {
        if (TextUtils.isEmpty(dvP)) {
            aKw();
        }
        return dvP;
    }

    private static Bundle aKw() {
        DelegateResult k = k("veloce_get_host_info", null);
        if (k == null || !k.isOk()) {
            return null;
        }
        Bundle bundle = k.mResult;
        dvP = bundle.getString("host_package");
        dvQ = bundle.getString("host_version");
        return bundle;
    }

    private static Bundle jO(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle j(String str, Bundle bundle) {
        Bundle jO;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                jO = null;
            } else {
                List<VeloceIpcResult.a> list = dvR.get(str);
                if (list == null) {
                    jO = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dvR.remove(list);
                    jO = jO(0);
                }
            }
        }
        return jO;
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
