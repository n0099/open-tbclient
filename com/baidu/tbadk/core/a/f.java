package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Tu = new HashMap<>();

    public static int bB(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Tu.containsKey(str)) {
            return Tu.get(str).intValue();
        }
        Tu.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        Tu.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }
}
