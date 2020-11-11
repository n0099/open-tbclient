package com.baidu.tbadk.core.a;

import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static HashMap<String, Integer> exs = new HashMap<>();

    public static int nO(int i) {
        String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i;
        if (exs.containsKey(str)) {
            return exs.get(str).intValue();
        }
        exs.put(str, 1);
        return 1;
    }

    public static void aM(int i, int i2) {
        exs.put(TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + i, Integer.valueOf(i2));
    }

    public static void a(PersonPrivateData personPrivateData) {
        if (personPrivateData != null) {
            String str = TbadkCoreApplication.getCurrentAccount() + UgcConstant.AT_RULE_TAG + 2;
            int byR = personPrivateData.byR();
            if (!exs.containsKey(str)) {
                exs.put(str, Integer.valueOf(byR));
            }
        }
    }
}
