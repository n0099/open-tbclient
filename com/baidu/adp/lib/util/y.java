package com.baidu.adp.lib.util;

import java.util.Comparator;
/* loaded from: classes.dex */
class y implements Comparator<com.baidu.adp.lib.cache.v<?>> {
    private y() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(y yVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.adp.lib.cache.v<?> vVar, com.baidu.adp.lib.cache.v<?> vVar2) {
        if (vVar.hR == vVar2.hR) {
            return 0;
        }
        return vVar.hR > vVar2.hR ? -1 : 1;
    }
}
