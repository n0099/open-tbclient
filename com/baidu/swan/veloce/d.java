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
    private static boolean cFP = false;
    private static boolean cFQ = false;
    private static String cFR = "";
    private static String cFS = "";
    private static HashMap<String, List<VeloceIpcResult.a>> cFT = new HashMap<>();

    public static boolean awq() {
        if (ProcessUtils.isMainProcess() && cFQ) {
            return cFP;
        }
        DelegateResult h = h("veloce_is_veloce", null);
        if (h != null && h.isOk()) {
            cFQ = true;
            cFP = h.mResult.getBoolean("is_veloce", false);
        }
        return cFP;
    }

    public static String awr() {
        if (TextUtils.isEmpty(cFR)) {
            aws();
        }
        return cFR;
    }

    private static Bundle aws() {
        DelegateResult h = h("veloce_get_host_info", null);
        if (h == null || !h.isOk()) {
            return null;
        }
        Bundle bundle = h.mResult;
        cFR = bundle.getString("host_package");
        cFS = bundle.getString("host_version");
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
                List<VeloceIpcResult.a> list = cFT.get(str);
                if (list == null) {
                    jb = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.g(0, bundle));
                    }
                    cFT.remove(list);
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
