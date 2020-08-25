package com.baidu.adp.framework.a;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private static String[] IJ = new String[0];

    public static Set<String> lw() {
        HashSet hashSet = new HashSet();
        try {
            if (IJ.length > 0) {
                for (String str : IJ) {
                    hashSet.add(str);
                }
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
        return hashSet;
    }
}
