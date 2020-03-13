package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> cLR = new HashMap<>();

    public static int js(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (cLR.containsKey(str)) {
            return cLR.get(str).intValue();
        }
        cLR.put(str, 1);
        return 1;
    }

    public static void aw(int i, int i2) {
        cLR.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aNP = personPrivateData.aNP();
            if (!cLR.containsKey(str)) {
                cLR.put(str, Integer.valueOf(aNP));
            }
        }
    }
}
