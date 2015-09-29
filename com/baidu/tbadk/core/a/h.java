package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    public static HashMap<String, Integer> TH = new HashMap<>();

    public static int br(int i) {
        String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i;
        if (TH.containsKey(str)) {
            return TH.get(str).intValue();
        }
        TH.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        TH.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
