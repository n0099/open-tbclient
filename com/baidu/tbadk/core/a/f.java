package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> TU = new HashMap<>();

    public static int bA(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (TU.containsKey(str)) {
            return TU.get(str).intValue();
        }
        TU.put(str, 1);
        return 1;
    }

    public static void u(int i, int i2) {
        TU.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
