package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bCO = new HashMap<>();

    public static int gM(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bCO.containsKey(str)) {
            return bCO.get(str).intValue();
        }
        bCO.put(str, 1);
        return 1;
    }

    public static void Q(int i, int i2) {
        bCO.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aqr = personPrivateData.aqr();
            if (!bCO.containsKey(str)) {
                bCO.put(str, Integer.valueOf(aqr));
            }
        }
    }
}
