package com.baidu.location.b;

import com.baidu.location.b.d;
import java.util.Comparator;
/* loaded from: classes15.dex */
class e implements Comparator<d.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f2614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f2614a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(d.c cVar, d.c cVar2) {
        if (cVar.f2611b > cVar2.f2611b) {
            return -1;
        }
        return cVar.f2611b == cVar2.f2611b ? 0 : 1;
    }
}
