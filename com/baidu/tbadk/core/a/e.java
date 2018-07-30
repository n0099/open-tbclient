package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> acF = new HashMap<>();

    public static int bC(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (acF.containsKey(str)) {
            return acF.get(str).intValue();
        }
        acF.put(str, 1);
        return 1;
    }

    public static void t(int i, int i2) {
        acF.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int GV = personPrivateData.GV();
            if (!acF.containsKey(str)) {
                acF.put(str, Integer.valueOf(GV));
            }
        }
    }
}
