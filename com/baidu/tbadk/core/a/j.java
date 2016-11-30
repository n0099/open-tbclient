package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> OD = new HashMap<>();

    public static int bE(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (OD.containsKey(str)) {
            return OD.get(str).intValue();
        }
        OD.put(str, 1);
        return 1;
    }

    public static void p(int i, int i2) {
        OD.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
