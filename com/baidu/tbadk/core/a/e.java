package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> adb = new HashMap<>();

    public static int bA(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (adb.containsKey(str)) {
            return adb.get(str).intValue();
        }
        adb.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        adb.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int GZ = personPrivateData.GZ();
            if (!adb.containsKey(str)) {
                adb.put(str, Integer.valueOf(GZ));
            }
        }
    }
}
