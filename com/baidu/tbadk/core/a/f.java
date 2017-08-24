package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> TX = new HashMap<>();

    public static int bA(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (TX.containsKey(str)) {
            return TX.get(str).intValue();
        }
        TX.put(str, 1);
        return 1;
    }

    public static void u(int i, int i2) {
        TX.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
