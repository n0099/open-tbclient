package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e {
    public static HashMap<String, Integer> dUL = new HashMap<>();

    public static int mL(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dUL.containsKey(str)) {
            return dUL.get(str).intValue();
        }
        dUL.put(str, 1);
        return 1;
    }

    public static void aM(int i, int i2) {
        dUL.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bqU = personPrivateData.bqU();
            if (!dUL.containsKey(str)) {
                dUL.put(str, Integer.valueOf(bqU));
            }
        }
    }
}
