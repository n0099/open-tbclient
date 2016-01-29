package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> TZ = new HashMap<>();

    public static int bC(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (TZ.containsKey(str)) {
            return TZ.get(str).intValue();
        }
        TZ.put(str, 1);
        return 1;
    }

    public static void r(int i, int i2) {
        TZ.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
