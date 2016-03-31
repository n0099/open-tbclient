package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Comparator<c> {
    final /* synthetic */ BannerListData SJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BannerListData bannerListData) {
        this.SJ = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(c cVar, c cVar2) {
        return (cVar != null ? com.baidu.adp.lib.h.b.g(cVar.Sf, 0) : 0) - (cVar2 != null ? com.baidu.adp.lib.h.b.g(cVar2.Sf, 0) : 0);
    }
}
