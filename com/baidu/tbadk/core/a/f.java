package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> aJI = new HashMap<>();

    public static int eB(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (aJI.containsKey(str)) {
            return aJI.get(str).intValue();
        }
        aJI.put(str, 1);
        return 1;
    }

    public static void at(int i, int i2) {
        aJI.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int KA = personPrivateData.KA();
            if (!aJI.containsKey(str)) {
                aJI.put(str, Integer.valueOf(KA));
            }
        }
    }
}
