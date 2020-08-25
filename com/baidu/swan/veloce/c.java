package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    private static boolean dKO = false;
    private static boolean dKP = false;
    private static String dKQ = "";
    private static String dKR = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dKS = new HashMap<>();

    private static Bundle mn(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle mn;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                mn = null;
            } else {
                List<VeloceIpcResult.a> list = dKS.get(str);
                if (list == null) {
                    mn = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dKS.remove(list);
                    mn = mn(0);
                }
            }
        }
        return mn;
    }
}
