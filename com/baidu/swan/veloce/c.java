package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private static boolean esF = false;
    private static boolean esG = false;
    private static String esH = "";
    private static String esI = "";
    private static HashMap<String, List<VeloceIpcResult.a>> esJ = new HashMap<>();

    private static Bundle nK(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle nK;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                nK = null;
            } else {
                List<VeloceIpcResult.a> list = esJ.get(str);
                if (list == null) {
                    nK = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    esJ.remove(list);
                    nK = nK(0);
                }
            }
        }
        return nK;
    }
}
