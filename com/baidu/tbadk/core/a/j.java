package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> Pg = new HashMap<>();

    public static int bi(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Pg.containsKey(str)) {
            return Pg.get(str).intValue();
        }
        Pg.put(str, 1);
        return 1;
    }

    public static void l(int i, int i2) {
        Pg.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
