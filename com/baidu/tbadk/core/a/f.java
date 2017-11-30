package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Uc = new HashMap<>();

    public static int bC(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Uc.containsKey(str)) {
            return Uc.get(str).intValue();
        }
        Uc.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Uc.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
