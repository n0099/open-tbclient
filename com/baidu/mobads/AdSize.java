package com.baidu.mobads;
/* loaded from: classes7.dex */
public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);
    

    /* renamed from: a  reason: collision with root package name */
    private int f2295a;

    public int getValue() {
        return this.f2295a;
    }

    AdSize(int i) {
        this.f2295a = i;
    }
}
