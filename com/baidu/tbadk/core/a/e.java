package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bvL = new HashMap<>();

    public static int ga(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bvL.containsKey(str)) {
            return bvL.get(str).intValue();
        }
        bvL.put(str, 1);
        return 1;
    }

    public static void R(int i, int i2) {
        bvL.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int alo = personPrivateData.alo();
            if (!bvL.containsKey(str)) {
                bvL.put(str, Integer.valueOf(alo));
            }
        }
    }
}
