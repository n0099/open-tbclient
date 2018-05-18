package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> Va = new HashMap<>();

    public static int bz(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (Va.containsKey(str)) {
            return Va.get(str).intValue();
        }
        Va.put(str, 1);
        return 1;
    }

    public static void s(int i, int i2) {
        Va.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int De = personPrivateData.De();
            if (!Va.containsKey(str)) {
                Va.put(str, Integer.valueOf(De));
            }
        }
    }
}
