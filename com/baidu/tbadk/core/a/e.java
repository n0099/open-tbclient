package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> eLk = new HashMap<>();

    public static int mQ(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (eLk.containsKey(str)) {
            return eLk.get(str).intValue();
        }
        eLk.put(str, 1);
        return 1;
    }

    public static void aI(int i, int i2) {
        eLk.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int bAE = personPrivateData.bAE();
            if (!eLk.containsKey(str)) {
                eLk.put(str, Integer.valueOf(bAE));
            }
        }
    }
}
