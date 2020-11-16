package com.baidu.ar.track2d;

import android.graphics.Bitmap;
/* loaded from: classes12.dex */
public interface ITrack2D {
    Bitmap getTargetBitmap();

    void haltTrack();

    void resumeTrack();

    void setStateChangedListener(ITrack2DStateChangedListener iTrack2DStateChangedListener);
}
