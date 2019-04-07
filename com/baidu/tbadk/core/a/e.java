package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bvK = new HashMap<>();

    public static int ga(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bvK.containsKey(str)) {
            return bvK.get(str).intValue();
        }
        bvK.put(str, 1);
        return 1;
    }

    public static void R(int i, int i2) {
        bvK.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int alo = personPrivateData.alo();
            if (!bvK.containsKey(str)) {
                bvK.put(str, Integer.valueOf(alo));
            }
        }
    }
}
