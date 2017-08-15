package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> TW = new HashMap<>();

    public static int bA(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (TW.containsKey(str)) {
            return TW.get(str).intValue();
        }
        TW.put(str, 1);
        return 1;
    }

    public static void u(int i, int i2) {
        TW.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
