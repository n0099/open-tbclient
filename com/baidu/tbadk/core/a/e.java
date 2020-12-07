package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> eCK = new HashMap<>();

    public static int oi(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (eCK.containsKey(str)) {
            return eCK.get(str).intValue();
        }
        eCK.put(str, 1);
        return 1;
    }

    public static void aO(int i, int i2) {
        eCK.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int bBH = personPrivateData.bBH();
            if (!eCK.containsKey(str)) {
                eCK.put(str, Integer.valueOf(bBH));
            }
        }
    }
}
