package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class j {
    public static HashMap<String, Integer> SO = new HashMap<>();

    public static int by(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (SO.containsKey(str)) {
            return SO.get(str).intValue();
        }
        SO.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        SO.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
