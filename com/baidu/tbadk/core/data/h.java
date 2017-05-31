package com.baidu.tbadk.core.data;

import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Comparator<AdvertAppInfo> {
    final /* synthetic */ BannerListData TM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BannerListData bannerListData) {
        this.TM = bannerListData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(AdvertAppInfo advertAppInfo, AdvertAppInfo advertAppInfo2) {
        return (advertAppInfo != null ? com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, 0) : 0) - (advertAppInfo2 != null ? com.baidu.adp.lib.g.b.g(advertAppInfo2.adPosition, 0) : 0);
    }
}
