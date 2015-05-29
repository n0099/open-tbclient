package com.baidu.adp.lib.util;

import java.util.Comparator;
/* loaded from: classes.dex */
class ab implements Comparator<com.baidu.adp.lib.cache.v<?>> {
    private ab() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(ab abVar) {
        this();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.adp.lib.cache.v<?> vVar, com.baidu.adp.lib.cache.v<?> vVar2) {
        if (vVar.tz == vVar2.tz) {
            return 0;
        }
        return vVar.tz > vVar2.tz ? -1 : 1;
    }
}
