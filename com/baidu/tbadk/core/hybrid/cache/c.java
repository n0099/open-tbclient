package com.baidu.tbadk.core.hybrid.cache;

import java.util.Comparator;
/* loaded from: classes.dex */
class c implements Comparator<CacheEntry> {
    final /* synthetic */ b acL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.acL = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(CacheEntry cacheEntry, CacheEntry cacheEntry2) {
        if (cacheEntry == null && cacheEntry2 == null) {
            return 0;
        }
        if (cacheEntry != null) {
            if (cacheEntry2 == null) {
                return -1;
            }
            if (cacheEntry.getWriteTime() == cacheEntry2.getWriteTime()) {
                return 0;
            }
            return cacheEntry.getWriteTime() - cacheEntry2.getWriteTime() >= 0 ? -1 : 1;
        }
        return 1;
    }
}
