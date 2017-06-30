package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> Sj = new HashMap<>();

    public static int bz(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Sj.containsKey(str)) {
            return Sj.get(str).intValue();
        }
        Sj.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Sj.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
