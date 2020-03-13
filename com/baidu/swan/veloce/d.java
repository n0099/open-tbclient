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
    private static boolean cFR = false;
    private static boolean cFS = false;
    private static String cFT = "";
    private static String cFU = "";
    private static HashMap<String, List<VeloceIpcResult.a>> cFV = new HashMap<>();

    public static boolean aws() {
        if (ProcessUtils.isMainProcess() && cFS) {
            return cFR;
        }
        DelegateResult h = h("veloce_is_veloce", null);
        if (h != null && h.isOk()) {
            cFS = true;
            cFR = h.mResult.getBoolean("is_veloce", false);
        }
        return cFR;
    }

    public static String awt() {
        if (TextUtils.isEmpty(cFT)) {
            awu();
        }
        return cFT;
    }

    private static Bundle awu() {
        DelegateResult h = h("veloce_get_host_info", null);
        if (h == null || !h.isOk()) {
            return null;
        }
        Bundle bundle = h.mResult;
        cFT = bundle.getString("host_package");
        cFU = bundle.getString("host_version");
        return bundle;
    }

    private static Bundle jb(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle g(String str, Bundle bundle) {
        Bundle jb;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                jb = null;
            } else {
                List<VeloceIpcResult.a> list = cFV.get(str);
                if (list == null) {
                    jb = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.g(0, bundle));
                    }
                    cFV.remove(list);
                    jb = jb(0);
                }
            }
        }
        return jb;
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
