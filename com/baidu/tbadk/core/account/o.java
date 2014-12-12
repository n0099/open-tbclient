package com.baidu.tbadk.core.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static HashMap<String, Integer> Dc = new HashMap<>();

    public static int bh(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Dc.containsKey(str)) {
            return Dc.get(str).intValue();
        }
        Dc.put(str, 1);
        return 1;
    }

    public static void n(int i, int i2) {
        Dc.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
