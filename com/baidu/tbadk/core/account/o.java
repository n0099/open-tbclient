package com.baidu.tbadk.core.account;

import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static HashMap<String, Integer> zc = new HashMap<>();

    public static int aL(int i) {
        String str = String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + i;
        if (zc.containsKey(str)) {
            return zc.get(str).intValue();
        }
        zc.put(str, 1);
        return 1;
    }

    public static void k(int i, int i2) {
        zc.put(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
