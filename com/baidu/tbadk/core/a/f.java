package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Sw = new HashMap<>();

    public static int by(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Sw.containsKey(str)) {
            return Sw.get(str).intValue();
        }
        Sw.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Sw.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
