package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> eJJ = new HashMap<>();

    public static int mP(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (eJJ.containsKey(str)) {
            return eJJ.get(str).intValue();
        }
        eJJ.put(str, 1);
        return 1;
    }

    public static void aI(int i, int i2) {
        eJJ.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int bAB = personPrivateData.bAB();
            if (!eJJ.containsKey(str)) {
                eJJ.put(str, Integer.valueOf(bAB));
            }
        }
    }
}
