package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> OJ = new HashMap<>();

    public static int bl(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (OJ.containsKey(str)) {
            return OJ.get(str).intValue();
        }
        OJ.put(str, 1);
        return 1;
    }

    public static void l(int i, int i2) {
        OJ.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
