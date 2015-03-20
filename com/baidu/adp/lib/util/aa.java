package com.baidu.adp.lib.util;

import java.util.Comparator;
/* loaded from: classes.dex */
class aa implements Comparator<com.baidu.adp.lib.cache.v<?>> {
    private aa() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(aa aaVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.adp.lib.cache.v<?> vVar, com.baidu.adp.lib.cache.v<?> vVar2) {
        if (vVar.tn == vVar2.tn) {
            return 0;
        }
        return vVar.tn > vVar2.tn ? -1 : 1;
    }
}
