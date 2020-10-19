package com.baidu.adp.lib.stats.base;

import java.util.Comparator;
/* loaded from: classes.dex */
public class e implements Comparator<d> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d dVar, d dVar2) {
        long j = dVar.Oy;
        long j2 = dVar2.Oy;
        if (j > j2) {
            return 1;
        }
        if (j == j2) {
            return 0;
        }
        return -1;
    }
}
