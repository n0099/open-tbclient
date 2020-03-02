package com.baidu.tbadk.core.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> cLQ = new HashMap<>();

    public static int js(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
        if (cLQ.containsKey(str)) {
            return cLQ.get(str).intValue();
        }
        cLQ.put(str, 1);
        return 1;
    }

    public static void aw(int i, int i2) {
        cLQ.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@2";
            int aNO = personPrivateData.aNO();
            if (!cLQ.containsKey(str)) {
                cLQ.put(str, Integer.valueOf(aNO));
            }
        }
    }
}
