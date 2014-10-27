package com.baidu.adp.lib.util;

import java.util.Comparator;
/* loaded from: classes.dex */
class t implements Comparator<com.baidu.adp.lib.cache.v<?>> {
    private t() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(t tVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.adp.lib.cache.v<?> vVar, com.baidu.adp.lib.cache.v<?> vVar2) {
        if (vVar.fN == vVar2.fN) {
            return 0;
        }
        return vVar.fN > vVar2.fN ? -1 : 1;
    }
}
