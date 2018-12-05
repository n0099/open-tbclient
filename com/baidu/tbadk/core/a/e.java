package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> aot = new HashMap<>();

    public static int cz(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (aot.containsKey(str)) {
            return aot.get(str).intValue();
        }
        aot.put(str, 1);
        return 1;
    }

    public static void w(int i, int i2) {
        aot.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int LA = personPrivateData.LA();
            if (!aot.containsKey(str)) {
                aot.put(str, Integer.valueOf(LA));
            }
        }
    }
}
