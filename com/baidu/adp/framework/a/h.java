package com.baidu.adp.framework.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private static String[] Kd = new String[0];

    public static Set<String> lB() {
        HashSet hashSet = new HashSet();
        try {
            if (Kd.length > 0) {
                for (String str : Kd) {
                    hashSet.add(str);
                }
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
        return hashSet;
    }
}
