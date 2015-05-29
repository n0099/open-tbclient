package com.baidu.adp.plugin.util;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Comparator<Object> {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int P;
        if ((obj instanceof String) && (obj2 instanceof String)) {
            P = a.P((String) obj, (String) obj2);
            return P;
        }
        return 0;
    }
}
