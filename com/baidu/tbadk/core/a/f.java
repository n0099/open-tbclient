package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Tb = new HashMap<>();

    public static int bD(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Tb.containsKey(str)) {
            return Tb.get(str).intValue();
        }
        Tb.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Tb.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
