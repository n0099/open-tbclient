package com.baidu.adp.framework.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private static String[] JD = new String[0];

    public static Set<String> kX() {
        HashSet hashSet = new HashSet();
        try {
            if (JD.length > 0) {
                for (String str : JD) {
                    hashSet.add(str);
                }
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
        return hashSet;
    }
}
