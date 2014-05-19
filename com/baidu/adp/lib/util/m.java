package com.baidu.adp.lib.util;

import com.baidu.adp.lib.cache.t;
import java.util.Comparator;
/* loaded from: classes.dex */
class m implements Comparator<t<?>> {
    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(m mVar) {
        this();
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
