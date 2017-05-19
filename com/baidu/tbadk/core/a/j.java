package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> SB = new HashMap<>();

    public static int by(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (SB.containsKey(str)) {
            return SB.get(str).intValue();
        }
        SB.put(str, 1);
        return 1;
    }

    public static void u(int i, int i2) {
        SB.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
