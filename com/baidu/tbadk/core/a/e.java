package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bDM = new HashMap<>();

    public static int gQ(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bDM.containsKey(str)) {
            return bDM.get(str).intValue();
        }
        bDM.put(str, 1);
        return 1;
    }

    public static void T(int i, int i2) {
        bDM.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int arw = personPrivateData.arw();
            if (!bDM.containsKey(str)) {
                bDM.put(str, Integer.valueOf(arw));
            }
        }
    }
}
