package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private static boolean eBk = false;
    private static boolean eBl = false;
    private static String eBm = "";
    private static String eBn = "";
    private static HashMap<String, List<VeloceIpcResult.a>> eBo = new HashMap<>();

    private static Bundle mr(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle j(String str, Bundle bundle) {
        Bundle mr;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                mr = null;
            } else {
                List<VeloceIpcResult.a> list = eBo.get(str);
                if (list == null) {
                    mr = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    eBo.remove(list);
                    mr = mr(0);
                }
            }
        }
        return mr;
    }
}
