package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    private static boolean dYW = false;
    private static boolean dYX = false;
    private static String dYY = "";
    private static String dYZ = "";
    private static HashMap<String, List<VeloceIpcResult.a>> dZa = new HashMap<>();

    private static Bundle mV(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle i(String str, Bundle bundle) {
        Bundle mV;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                mV = null;
            } else {
                List<VeloceIpcResult.a> list = dZa.get(str);
                if (list == null) {
                    mV = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    dZa.remove(list);
                    mV = mV(0);
                }
            }
        }
        return mV;
    }
}
