package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Comparator<b> {
    final /* synthetic */ BannerListData PK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BannerListData bannerListData) {
        this.PK = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        return (bVar != null ? com.baidu.adp.lib.h.b.g(bVar.adPosition, 0) : 0) - (bVar2 != null ? com.baidu.adp.lib.h.b.g(bVar2.adPosition, 0) : 0);
    }
}
