package com.baidu.b.b;

import com.baidu.b.b.e;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements Comparator<e.c.a> {
    final /* synthetic */ e.c afa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e.c cVar) {
        this.afa = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(e.c.a aVar, e.c.a aVar2) {
        int i;
        int i2;
        i = aVar.f1585a;
        i2 = aVar2.f1585a;
        return i - i2;
    }
}
