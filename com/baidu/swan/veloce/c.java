package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes17.dex */
public class c {
    private static boolean elD = false;
    private static boolean elE = false;
    private static String elF = "";
    private static String elG = "";
    private static HashMap<String, List<VeloceIpcResult.a>> elH = new HashMap<>();

    private static Bundle nm(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle nm;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                nm = null;
            } else {
                List<VeloceIpcResult.a> list = elH.get(str);
                if (list == null) {
                    nm = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    elH.remove(list);
                    nm = nm(0);
                }
            }
        }
        return nm;
    }
}
