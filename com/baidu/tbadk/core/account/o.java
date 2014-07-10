package com.baidu.tbadk.core.account;

import com.baidu.tbadk.TbadkApplication;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static HashMap<String, Integer> a = new HashMap<>();

    public static int a(int i) {
        String str = String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + i;
        if (a.containsKey(str)) {
            return a.get(str).intValue();
        }
        a.put(str, 1);
        return 1;
    }

    public static void a(int i, int i2) {
        a.put(String.valueOf(TbadkApplication.getCurrentAccount()) + "@" + i, Integer.valueOf(i2));
    }
}
