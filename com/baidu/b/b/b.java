package com.baidu.b.b;

import java.util.Comparator;
/* loaded from: classes20.dex */
final class b implements Comparator<a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(a aVar, a aVar2) {
        long b = aVar.b() - aVar2.b();
        return b != 0 ? b > 0 ? -1 : 1 : aVar.a().compareTo(aVar2.a());
    }
}
