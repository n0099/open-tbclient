package com.baidu.adp.plugin.util;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Comparator<Object> {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int J;
        if ((obj instanceof String) && (obj2 instanceof String)) {
            J = a.J((String) obj, (String) obj2);
            return J;
        }
        return 0;
    }
}
