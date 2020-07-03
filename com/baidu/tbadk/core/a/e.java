package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> dFG = new HashMap<>();

    public static int km(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dFG.containsKey(str)) {
            return dFG.get(str).intValue();
        }
        dFG.put(str, 1);
        return 1;
    }

    public static void aE(int i, int i2) {
        dFG.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bez = personPrivateData.bez();
            if (!dFG.containsKey(str)) {
                dFG.put(str, Integer.valueOf(bez));
            }
        }
    }
}
