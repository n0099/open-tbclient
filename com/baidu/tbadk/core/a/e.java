package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> aoV = new HashMap<>();

    public static int cz(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (aoV.containsKey(str)) {
            return aoV.get(str).intValue();
        }
        aoV.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        aoV.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int LQ = personPrivateData.LQ();
            if (!aoV.containsKey(str)) {
                aoV.put(str, Integer.valueOf(LQ));
            }
        }
    }
}
