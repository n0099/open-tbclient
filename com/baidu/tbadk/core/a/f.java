package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> aIA = new HashMap<>();

    public static int eB(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (aIA.containsKey(str)) {
            return aIA.get(str).intValue();
        }
        aIA.put(str, 1);
        return 1;
    }

    public static void at(int i, int i2) {
        aIA.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int JU = personPrivateData.JU();
            if (!aIA.containsKey(str)) {
                aIA.put(str, Integer.valueOf(JU));
            }
        }
    }
}
