package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> UA = new HashMap<>();

    public static int bn(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (UA.containsKey(str)) {
            return UA.get(str).intValue();
        }
        UA.put(str, 1);
        return 1;
    }

    public static void v(int i, int i2) {
        UA.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
