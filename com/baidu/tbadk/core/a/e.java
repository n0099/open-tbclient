package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> akR = new HashMap<>();

    public static int cl(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (akR.containsKey(str)) {
            return akR.get(str).intValue();
        }
        akR.put(str, 1);
        return 1;
    }

    public static void v(int i, int i2) {
        akR.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int Kw = personPrivateData.Kw();
            if (!akR.containsKey(str)) {
                akR.put(str, Integer.valueOf(Kw));
            }
        }
    }
}
