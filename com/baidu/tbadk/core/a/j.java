package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> NK = new HashMap<>();

    public static int bE(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (NK.containsKey(str)) {
            return NK.get(str).intValue();
        }
        NK.put(str, 1);
        return 1;
    }

    public static void q(int i, int i2) {
        NK.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
