package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> ejb = new HashMap<>();

    public static int nt(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (ejb.containsKey(str)) {
            return ejb.get(str).intValue();
        }
        ejb.put(str, 1);
        return 1;
    }

    public static void aL(int i, int i2) {
        ejb.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int buz = personPrivateData.buz();
            if (!ejb.containsKey(str)) {
                ejb.put(str, Integer.valueOf(buz));
            }
        }
    }
}
