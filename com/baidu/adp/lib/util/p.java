package com.baidu.adp.lib.util;

import com.baidu.adp.lib.cache.u;
import java.util.Comparator;
/* loaded from: classes.dex */
class p implements Comparator<u<?>> {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(p pVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u<?> uVar, u<?> uVar2) {
        if (uVar.c == uVar2.c) {
            return 0;
        }
        return uVar.c > uVar2.c ? -1 : 1;
    }
}
