package com.baidu.tbadk.core.dialog;

import com.baidu.tieba.u;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> a = new HashMap<>(2);

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DefaultIcon[] valuesCustom() {
            DefaultIcon[] valuesCustom = values();
            int length = valuesCustom.length;
            DefaultIcon[] defaultIconArr = new DefaultIcon[length];
            System.arraycopy(valuesCustom, 0, defaultIconArr, 0, length);
            return defaultIconArr;
        }
    }

    static {
        a.put(DefaultIcon.SUCCESS, Integer.valueOf(u.icon_unite_pass));
        a.put(DefaultIcon.FAILURE, Integer.valueOf(u.icon_unite_lose));
    }
}
