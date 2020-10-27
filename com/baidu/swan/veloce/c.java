package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    private static boolean eht = false;
    private static boolean ehu = false;
    private static String ehv = "";
    private static String ehw = "";
    private static HashMap<String, List<VeloceIpcResult.a>> ehx = new HashMap<>();

    private static Bundle ng(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle ng;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                ng = null;
            } else {
                List<VeloceIpcResult.a> list = ehx.get(str);
                if (list == null) {
                    ng = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    ehx.remove(list);
                    ng = ng(0);
                }
            }
        }
        return ng;
    }
}
