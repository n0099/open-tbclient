package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> TW = new HashMap<>();

    public static int br(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (TW.containsKey(str)) {
            return TW.get(str).intValue();
        }
        TW.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        TW.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
