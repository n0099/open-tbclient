package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> Rv = new HashMap<>();

    public static int bB(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Rv.containsKey(str)) {
            return Rv.get(str).intValue();
        }
        Rv.put(str, 1);
        return 1;
    }

    public static void n(int i, int i2) {
        Rv.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
