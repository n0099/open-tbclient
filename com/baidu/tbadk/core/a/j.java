package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> Ti = new HashMap<>();

    public static int bB(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Ti.containsKey(str)) {
            return Ti.get(str).intValue();
        }
        Ti.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        Ti.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
