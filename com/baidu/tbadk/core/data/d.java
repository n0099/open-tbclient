package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Comparator<b> {
    final /* synthetic */ BannerListData Vp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BannerListData bannerListData) {
        this.Vp = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(b bVar, b bVar2) {
        return (bVar != null ? com.baidu.adp.lib.h.b.g(bVar.UT, 0) : 0) - (bVar2 != null ? com.baidu.adp.lib.h.b.g(bVar2.UT, 0) : 0);
    }
}
