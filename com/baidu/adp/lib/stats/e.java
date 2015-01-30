package com.baidu.adp.lib.stats;

import java.util.Comparator;
/* loaded from: classes.dex */
class e implements Comparator<s> {
    final /* synthetic */ BdNormalStatBase lJ;

    private e(BdNormalStatBase bdNormalStatBase) {
        this.lJ = bdNormalStatBase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(BdNormalStatBase bdNormalStatBase, e eVar) {
        this(bdNormalStatBase);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(s sVar, s sVar2) {
        long j = sVar.mE;
        long j2 = sVar2.mE;
        if (j > j2) {
            return 1;
        }
        if (j == j2) {
            return 0;
        }
        return -1;
    }
}
