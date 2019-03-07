package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bvF = new HashMap<>();

    public static int gb(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bvF.containsKey(str)) {
            return bvF.get(str).intValue();
        }
        bvF.put(str, 1);
        return 1;
    }

    public static void R(int i, int i2) {
        bvF.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int als = personPrivateData.als();
            if (!bvF.containsKey(str)) {
                bvF.put(str, Integer.valueOf(als));
            }
        }
    }
}
