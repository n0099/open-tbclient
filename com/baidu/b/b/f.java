package com.baidu.b.b;

import com.baidu.b.b.e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Comparator<e.c.a> {
    final /* synthetic */ e.c adq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e.c cVar) {
        this.adq = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(e.c.a aVar, e.c.a aVar2) {
        int i;
        int i2;
        i = aVar.f1253a;
        i2 = aVar2.f1253a;
        return i - i2;
    }
}
