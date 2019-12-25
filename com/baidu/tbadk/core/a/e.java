package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> cHA = new HashMap<>();

    public static int ja(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (cHA.containsKey(str)) {
            return cHA.get(str).intValue();
        }
        cHA.put(str, 1);
        return 1;
    }

    public static void as(int i, int i2) {
        cHA.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aKX = personPrivateData.aKX();
            if (!cHA.containsKey(str)) {
                cHA.put(str, Integer.valueOf(aKX));
            }
        }
    }
}
