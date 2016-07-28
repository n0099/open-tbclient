package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> Mj = new HashMap<>();

    public static int br(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Mj.containsKey(str)) {
            return Mj.get(str).intValue();
        }
        Mj.put(str, 1);
        return 1;
    }

    public static void n(int i, int i2) {
        Mj.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
