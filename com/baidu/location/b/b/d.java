package com.baidu.location.b.b;

import com.baidu.location.b.b.c;
import java.util.Comparator;
/* loaded from: classes.dex */
class d implements Comparator<c.a> {
    final /* synthetic */ c aAG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aAG = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c.a aVar, c.a aVar2) {
        int i = aVar2.b - aVar.b;
        if (i == 0) {
            if (aVar.d && aVar2.d) {
                return 0;
            }
            if (aVar.d) {
                return -1;
            }
            if (aVar2.d) {
                return 1;
            }
            return i;
        }
        return i;
    }
}
