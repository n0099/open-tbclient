package com.baidu.ar.track2d;
/* loaded from: classes11.dex */
public interface ITrack2DState {

    /* loaded from: classes11.dex */
    public enum a {
        NORMAL,
        TOO_FAR,
        TOO_NEAR,
        UNKNOWN
    }

    a distanceState();

    boolean isModelAppear();

    boolean isShowImmediately();

    boolean isTrackFound();
}
