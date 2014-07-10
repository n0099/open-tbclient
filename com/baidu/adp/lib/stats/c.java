package com.baidu.adp.lib.stats;

import java.util.Comparator;
/* loaded from: classes.dex */
class c implements Comparator {
    final /* synthetic */ BdNormalStatBase a;

    private c(BdNormalStatBase bdNormalStatBase) {
        this.a = bdNormalStatBase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(BdNormalStatBase bdNormalStatBase, c cVar) {
        this(bdNormalStatBase);
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        long j = ((q) obj).c;
        long j2 = ((q) obj2).c;
        if (j > j2) {
            return 1;
        }
        if (j == j2) {
            return 0;
        }
        return -1;
    }
}
