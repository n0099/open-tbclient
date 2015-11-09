package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Comparator<b> {
    final /* synthetic */ BannerListData Uy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BannerListData bannerListData) {
        this.Uy = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        return (bVar != null ? com.baidu.adp.lib.g.b.g(bVar.Uc, 0) : 0) - (bVar2 != null ? com.baidu.adp.lib.g.b.g(bVar2.Uc, 0) : 0);
    }
}
