package com.baidu.tbadk.core.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static HashMap<String, Integer> Db = new HashMap<>();

    public static int bm(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Db.containsKey(str)) {
            return Db.get(str).intValue();
        }
        Db.put(str, 1);
        return 1;
    }

    public static void n(int i, int i2) {
        Db.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
