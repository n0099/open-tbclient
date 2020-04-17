package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> dlj = new HashMap<>();

    public static int jz(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dlj.containsKey(str)) {
            return dlj.get(str).intValue();
        }
        dlj.put(str, 1);
        return 1;
    }

    public static void az(int i, int i2) {
        dlj.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int aWp = personPrivateData.aWp();
            if (!dlj.containsKey(str)) {
                dlj.put(str, Integer.valueOf(aWp));
            }
        }
    }
}
