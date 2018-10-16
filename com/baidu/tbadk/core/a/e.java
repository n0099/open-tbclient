package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> ake = new HashMap<>();

    public static int bW(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (ake.containsKey(str)) {
            return ake.get(str).intValue();
        }
        ake.put(str, 1);
        return 1;
    }

    public static void v(int i, int i2) {
        ake.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int Kk = personPrivateData.Kk();
            if (!ake.containsKey(str)) {
                ake.put(str, Integer.valueOf(Kk));
            }
        }
    }
}
