package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> erA = new HashMap<>();

    public static int nE(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (erA.containsKey(str)) {
            return erA.get(str).intValue();
        }
        erA.put(str, 1);
        return 1;
    }

    public static void aM(int i, int i2) {
        erA.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bws = personPrivateData.bws();
            if (!erA.containsKey(str)) {
                erA.put(str, Integer.valueOf(bws));
            }
        }
    }
}
