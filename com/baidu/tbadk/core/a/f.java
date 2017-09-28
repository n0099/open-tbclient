package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Tn = new HashMap<>();

    public static int bE(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Tn.containsKey(str)) {
            return Tn.get(str).intValue();
        }
        Tn.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Tn.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
