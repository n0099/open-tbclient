package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> aIx = new HashMap<>();

    public static int eB(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (aIx.containsKey(str)) {
            return aIx.get(str).intValue();
        }
        aIx.put(str, 1);
        return 1;
    }

    public static void at(int i, int i2) {
        aIx.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int JS = personPrivateData.JS();
            if (!aIx.containsKey(str)) {
                aIx.put(str, Integer.valueOf(JS));
            }
        }
    }
}
