package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private static boolean dBD = false;
    private static boolean dBE = false;
    private static String dBF = "";
    private static String dBG = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dBH = new HashMap<>();

    private static Bundle kh(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle j(String str, Bundle bundle) {
        Bundle kh;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                kh = null;
            } else {
                List<VeloceIpcResult.a> list = dBH.get(str);
                if (list == null) {
                    kh = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dBH.remove(list);
                    kh = kh(0);
                }
            }
        }
        return kh;
    }
}
