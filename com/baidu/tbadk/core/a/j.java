package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> Oz = new HashMap<>();

    public static int bF(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Oz.containsKey(str)) {
            return Oz.get(str).intValue();
        }
        Oz.put(str, 1);
        return 1;
    }

    public static void p(int i, int i2) {
        Oz.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
