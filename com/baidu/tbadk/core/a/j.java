package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> OH = new HashMap<>();

    public static int bl(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (OH.containsKey(str)) {
            return OH.get(str).intValue();
        }
        OH.put(str, 1);
        return 1;
    }

    public static void l(int i, int i2) {
        OH.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
