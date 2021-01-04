package com.baidu.ar.track2d;
/* loaded from: classes6.dex */
public interface ITrack2DState {

    /* loaded from: classes6.dex */
    public enum DistanceState {
        NORMAL,
        TOO_FAR,
        TOO_NEAR,
        UNKNOWN
    }

    DistanceState distanceState();

    boolean isModelAppear();

    boolean isShowImmediately();

    boolean isTrackFound();
}
