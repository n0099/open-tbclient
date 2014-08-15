package com.baidu.adp.lib.util;

import com.baidu.adp.lib.cache.v;
import java.util.Comparator;
/* loaded from: classes.dex */
class p implements Comparator<v<?>> {
    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(p pVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(v<?> vVar, v<?> vVar2) {
        if (vVar.c == vVar2.c) {
            return 0;
        }
        return vVar.c > vVar2.c ? -1 : 1;
    }
}
