package com.baidu.b.b;

import java.util.Comparator;
/* loaded from: classes15.dex */
final class b implements Comparator<a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(a aVar, a aVar2) {
        long b2 = aVar.b() - aVar2.b();
        return b2 != 0 ? b2 > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
    }
}
