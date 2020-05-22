package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> dzn = new HashMap<>();

    public static int jZ(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dzn.containsKey(str)) {
            return dzn.get(str).intValue();
        }
        dzn.put(str, 1);
        return 1;
    }

    public static void aC(int i, int i2) {
        dzn.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bcw = personPrivateData.bcw();
            if (!dzn.containsKey(str)) {
                dzn.put(str, Integer.valueOf(bcw));
            }
        }
    }
}
