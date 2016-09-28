package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> OA = new HashMap<>();

    public static int bE(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (OA.containsKey(str)) {
            return OA.get(str).intValue();
        }
        OA.put(str, 1);
        return 1;
    }

    public static void p(int i, int i2) {
        OA.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
