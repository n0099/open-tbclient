package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> cHM = new HashMap<>();

    public static int ja(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (cHM.containsKey(str)) {
            return cHM.get(str).intValue();
        }
        cHM.put(str, 1);
        return 1;
    }

    public static void aw(int i, int i2) {
        cHM.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aLq = personPrivateData.aLq();
            if (!cHM.containsKey(str)) {
                cHM.put(str, Integer.valueOf(aLq));
            }
        }
    }
}
