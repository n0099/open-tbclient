package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> acG = new HashMap<>();

    public static int bC(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (acG.containsKey(str)) {
            return acG.get(str).intValue();
        }
        acG.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        acG.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int GV = personPrivateData.GV();
            if (!acG.containsKey(str)) {
                acG.put(str, Integer.valueOf(GV));
            }
        }
    }
}
