package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> afh = new HashMap<>();

    public static int bL(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (afh.containsKey(str)) {
            return afh.get(str).intValue();
        }
        afh.put(str, 1);
        return 1;
    }

    public static void v(int i, int i2) {
        afh.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int Il = personPrivateData.Il();
            if (!afh.containsKey(str)) {
                afh.put(str, Integer.valueOf(Il));
            }
        }
    }
}
