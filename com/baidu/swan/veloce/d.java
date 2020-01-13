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
/* loaded from: classes10.dex */
public class d {
    private static boolean cBR = false;
    private static boolean cBS = false;
    private static String cBT = "";
    private static String cBU = "";
    private static HashMap<String, List<VeloceIpcResult.a>> cBV = new HashMap<>();

    public static boolean auc() {
        if (ProcessUtils.isMainProcess() && cBS) {
            return cBR;
        }
        DelegateResult h = h("veloce_is_veloce", null);
        if (h != null && h.isOk()) {
            cBS = true;
            cBR = h.mResult.getBoolean("is_veloce", false);
        }
        return cBR;
    }

    public static String aud() {
        if (TextUtils.isEmpty(cBT)) {
            aue();
        }
        return cBT;
    }

    private static Bundle aue() {
        DelegateResult h = h("veloce_get_host_info", null);
        if (h == null || !h.isOk()) {
            return null;
        }
        Bundle bundle = h.mResult;
        cBT = bundle.getString("host_package");
        cBU = bundle.getString("host_version");
        return bundle;
    }

    private static Bundle iK(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle g(String str, Bundle bundle) {
        Bundle iK;
        synchronized (d.class) {
            if (TextUtils.isEmpty(str)) {
                iK = null;
            } else {
                List<VeloceIpcResult.a> list = cBV.get(str);
                if (list == null) {
                    iK = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.g(0, bundle));
                    }
                    cBV.remove(list);
                    iK = iK(0);
                }
            }
        }
        return iK;
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
