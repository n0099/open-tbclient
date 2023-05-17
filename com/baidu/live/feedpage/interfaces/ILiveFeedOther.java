package com.baidu.live.feedpage.interfaces;
/* loaded from: classes3.dex */
public interface ILiveFeedOther {

    /* loaded from: classes3.dex */
    public interface LiveFeedStatusListener {
        void onEmpty();

        void onError();

        void onLoadSuccess();

        void onLoading();
    }

    void addLiveFeedStatusListener(LiveFeedStatusListener liveFeedStatusListener);

    boolean canSlideDown();

    boolean canSlideUp();

    boolean hasMore();

    void setIsHKTopBar(boolean z);
}
