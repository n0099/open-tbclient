package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> eMo = new HashMap<>();

    public static int os(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (eMo.containsKey(str)) {
            return eMo.get(str).intValue();
        }
        eMo.put(str, 1);
        return 1;
    }

    public static void aL(int i, int i2) {
        eMo.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int bEc = personPrivateData.bEc();
            if (!eMo.containsKey(str)) {
                eMo.put(str, Integer.valueOf(bEc));
            }
        }
    }
}
