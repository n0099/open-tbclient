package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    private static boolean enl = false;
    private static boolean enm = false;
    private static String enn = "";
    private static String eno = "";
    private static HashMap<String, List<VeloceIpcResult.a>> enp = new HashMap<>();

    private static Bundle nq(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle nq;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                nq = null;
            } else {
                List<VeloceIpcResult.a> list = enp.get(str);
                if (list == null) {
                    nq = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    enp.remove(list);
                    nq = nq(0);
                }
            }
        }
        return nq;
    }
}
