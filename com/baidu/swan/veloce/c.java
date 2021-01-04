package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private static boolean eCp = false;
    private static boolean eCq = false;
    private static String eCr = "";
    private static String eCs = "";
    private static HashMap<String, List<VeloceIpcResult.a>> eCt = new HashMap<>();

    private static Bundle nT(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle nT;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                nT = null;
            } else {
                List<VeloceIpcResult.a> list = eCt.get(str);
                if (list == null) {
                    nT = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    eCt.remove(list);
                    nT = nT(0);
                }
            }
        }
        return nT;
    }
}
