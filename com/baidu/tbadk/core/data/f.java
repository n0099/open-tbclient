package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Comparator<c> {
    final /* synthetic */ BannerListData Va;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(BannerListData bannerListData) {
        this.Va = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c cVar, c cVar2) {
        return (cVar != null ? com.baidu.adp.lib.h.b.g(cVar.Uz, 0) : 0) - (cVar2 != null ? com.baidu.adp.lib.h.b.g(cVar2.Uz, 0) : 0);
    }
}
