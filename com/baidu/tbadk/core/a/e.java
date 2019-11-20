package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> bVk = new HashMap<>();

    public static int hp(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (bVk.containsKey(str)) {
            return bVk.get(str).intValue();
        }
        bVk.put(str, 1);
        return 1;
    }

    public static void X(int i, int i2) {
        bVk.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int atw = personPrivateData.atw();
            if (!bVk.containsKey(str)) {
                bVk.put(str, Integer.valueOf(atw));
            }
        }
    }
}
