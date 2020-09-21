package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private static boolean dMV = false;
    private static boolean dMW = false;
    private static String dMX = "";
    private static String dMY = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dMZ = new HashMap<>();

    private static Bundle my(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle my;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                my = null;
            } else {
                List<VeloceIpcResult.a> list = dMZ.get(str);
                if (list == null) {
                    my = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dMZ.remove(list);
                    my = my(0);
                }
            }
        }
        return my;
    }
}
