package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> eHD = new HashMap<>();

    public static int mM(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (eHD.containsKey(str)) {
            return eHD.get(str).intValue();
        }
        eHD.put(str, 1);
        return 1;
    }

    public static void aL(int i, int i2) {
        eHD.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int bAj = personPrivateData.bAj();
            if (!eHD.containsKey(str)) {
                eHD.put(str, Integer.valueOf(bAj));
            }
        }
    }
}
