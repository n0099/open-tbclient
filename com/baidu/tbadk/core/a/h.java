package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> Ua = new HashMap<>();

    public static int bu(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (Ua.containsKey(str)) {
            return Ua.get(str).intValue();
        }
        Ua.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        Ua.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
