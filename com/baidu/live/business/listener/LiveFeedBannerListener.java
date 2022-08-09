package com.baidu.live.business.listener;

import com.baidu.live.business.model.data.LiveBannerEntity;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/live/business/listener/LiveFeedBannerListener;", "Lkotlin/Any;", "Lcom/baidu/live/business/model/data/LiveBannerEntity;", AdvanceSetting.NETWORK_TYPE, "", "onBannerShow", "(Lcom/baidu/live/business/model/data/LiveBannerEntity;)V", "itemEntity", "onClickBanner", "lib-live-feed-page_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface LiveFeedBannerListener {
    void onBannerShow(LiveBannerEntity liveBannerEntity);

    void onClickBanner(LiveBannerEntity liveBannerEntity);
}
