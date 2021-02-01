package com.baidu.swan.veloce;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.veloce.VeloceIpcResult;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    private static boolean ezJ = false;
    private static boolean ezK = false;
    private static String ezL = "";
    private static String ezM = "";
    private static HashMap<String, List<VeloceIpcResult.a>> ezN = new HashMap<>();

    private static Bundle mq(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("result_code", i);
        return bundle;
    }

    public static synchronized Bundle j(String str, Bundle bundle) {
        Bundle mq;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str)) {
                mq = null;
            } else {
                List<VeloceIpcResult.a> list = ezN.get(str);
                if (list == null) {
                    mq = null;
                } else {
                    for (VeloceIpcResult.a aVar : list) {
                        aVar.a(VeloceIpcResult.f(0, bundle));
                    }
                    ezN.remove(list);
                    mq = mq(0);
                }
            }
        }
        return mq;
    }
}
