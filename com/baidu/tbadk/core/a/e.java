package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> dLD = new HashMap<>();

    public static int kF(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (dLD.containsKey(str)) {
            return dLD.get(str).intValue();
        }
        dLD.put(str, 1);
        return 1;
    }

    public static void aF(int i, int i2) {
        dLD.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bii = personPrivateData.bii();
            if (!dLD.containsKey(str)) {
                dLD.put(str, Integer.valueOf(bii));
            }
        }
    }
}
