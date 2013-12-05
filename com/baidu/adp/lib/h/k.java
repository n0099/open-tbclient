package com.baidu.adp.lib.h;

import com.baidu.adp.lib.cache.t;
import java.util.Comparator;
/* loaded from: classes.dex */
class k implements Comparator<t<?>> {
    private k() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(t<?> tVar, t<?> tVar2) {
        if (tVar.c == tVar2.c) {
            return 0;
        }
        return tVar.c > tVar2.c ? -1 : 1;
    }
}
