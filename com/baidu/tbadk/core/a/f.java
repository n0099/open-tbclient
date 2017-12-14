package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> TW = new HashMap<>();

    public static int bC(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (TW.containsKey(str)) {
            return TW.get(str).intValue();
        }
        TW.put(str, 1);
        return 1;
    }

    public static void u(int i, int i2) {
        TW.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int CB = personPrivateData.CB();
            if (!TW.containsKey(str)) {
                TW.put(str, Integer.valueOf(CB));
            }
        }
    }
}
