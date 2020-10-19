package com.baidu.b;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Comparator<b> {
    final /* synthetic */ c adK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.adK = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        int i = bVar2.b - bVar.b;
        if (i == 0) {
            if (bVar.d && bVar2.d) {
                return 0;
            }
            if (bVar.d) {
                return -1;
            }
            if (bVar2.d) {
                return 1;
            }
            return i;
        }
        return i;
    }
}
