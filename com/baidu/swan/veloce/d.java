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
/* loaded from: classes9.dex */
public class d {
    private static boolean cBG = false;
    private static boolean cBH = false;
    private static String cBI = "";
    private static String cBJ = "";
    private static HashMap<String, List<VeloceIpcResult.a>> cBK = new HashMap<>();

    public static boolean atJ() {
        if (ProcessUtils.isMainProcess() && cBH) {
            return cBG;
        }
        DelegateResult h = h("veloce_is_veloce", null);
        if (h != null && h.isOk()) {
            cBH = true;
            cBG = h.mResult.getBoolean("is_veloce", false);
        }
        return cBG;
    }

    public static String atK() {
        if (TextUtils.isEmpty(cBI)) {
            atL();
        }
        return cBI;
    }

    private static Bundle atL() {
        DelegateResult h = h("veloce_get_host_info", null);
        if (h == null || !h.isOk()) {
            return null;
        }
        Bundle bundle = h.mResult;
        cBI = bundle.getString("host_package");
        cBJ = bundle.getString("host_version");
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
                List<VeloceIpcResult.a> list = cBK.get(str);
                if (list == null) {
                    iK = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.g(0, bundle));
                    }
                    cBK.remove(list);
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
