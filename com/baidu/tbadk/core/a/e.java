package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> dUP = new HashMap<>();

    public static int mL(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dUP.containsKey(str)) {
            return dUP.get(str).intValue();
        }
        dUP.put(str, 1);
        return 1;
    }

    public static void aM(int i, int i2) {
        dUP.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bqV = personPrivateData.bqV();
            if (!dUP.containsKey(str)) {
                dUP.put(str, Integer.valueOf(bqV));
            }
        }
    }
}
