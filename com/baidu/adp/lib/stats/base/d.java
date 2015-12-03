package com.baidu.adp.lib.stats.base;

import java.util.Comparator;
/* loaded from: classes.dex */
public class d implements Comparator<c> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c cVar, c cVar2) {
        long j = cVar.xc;
        long j2 = cVar2.xc;
        if (j > j2) {
            return 1;
        }
        if (j == j2) {
            return 0;
        }
        return -1;
    }
}
