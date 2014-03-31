package com.baidu.adp.lib.util;

import com.baidu.adp.lib.cache.t;
import java.util.Comparator;
/* loaded from: classes.dex */
final class l implements Comparator<t<?>> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(t<?> tVar, t<?> tVar2) {
        t<?> tVar3 = tVar;
        t<?> tVar4 = tVar2;
        if (tVar3.c == tVar4.c) {
            return 0;
        }
        return tVar3.c > tVar4.c ? -1 : 1;
    }

    private l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(byte b) {
        this();
    }
}
