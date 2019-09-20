package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bEk = new HashMap<>();

    public static int gR(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bEk.containsKey(str)) {
            return bEk.get(str).intValue();
        }
        bEk.put(str, 1);
        return 1;
    }

    public static void T(int i, int i2) {
        bEk.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int arK = personPrivateData.arK();
            if (!bEk.containsKey(str)) {
                bEk.put(str, Integer.valueOf(arK));
            }
        }
    }
}
