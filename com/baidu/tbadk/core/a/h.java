package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> TI = new HashMap<>();

    public static int br(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (TI.containsKey(str)) {
            return TI.get(str).intValue();
        }
        TI.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        TI.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
