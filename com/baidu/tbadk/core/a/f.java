package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> SZ = new HashMap<>();

    public static int bA(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (SZ.containsKey(str)) {
            return SZ.get(str).intValue();
        }
        SZ.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        SZ.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
