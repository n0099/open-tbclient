package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static HashMap<String, Integer> acZ = new HashMap<>();

    public static int bB(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (acZ.containsKey(str)) {
            return acZ.get(str).intValue();
        }
        acZ.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        acZ.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int GH = personPrivateData.GH();
            if (!acZ.containsKey(str)) {
                acZ.put(str, Integer.valueOf(GH));
            }
        }
    }
}
