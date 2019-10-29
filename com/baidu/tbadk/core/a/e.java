package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bWb = new HashMap<>();

    public static int hq(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bWb.containsKey(str)) {
            return bWb.get(str).intValue();
        }
        bWb.put(str, 1);
        return 1;
    }

    public static void Z(int i, int i2) {
        bWb.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aty = personPrivateData.aty();
            if (!bWb.containsKey(str)) {
                bWb.put(str, Integer.valueOf(aty));
            }
        }
    }
}
