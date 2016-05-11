package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> Ml = new HashMap<>();

    public static int bo(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Ml.containsKey(str)) {
            return Ml.get(str).intValue();
        }
        Ml.put(str, 1);
        return 1;
    }

    public static void n(int i, int i2) {
        Ml.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
