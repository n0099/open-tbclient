package com.baidu.mobads;
/* loaded from: classes4.dex */
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
    private int f2341a;

    public int getValue() {
        return this.f2341a;
    }

    AdSize(int i) {
        this.f2341a = i;
    }
}
