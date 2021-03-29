package com.baidu.mobads;
/* loaded from: classes2.dex */
public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    RewardVideo(14),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);
    

    /* renamed from: a  reason: collision with root package name */
    public int f8101a;

    AdSize(int i) {
        this.f8101a = i;
    }

    public int getValue() {
        return this.f8101a;
    }
}
