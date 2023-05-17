package com.baidu.swan.apps.media.image;

import android.graphics.PointF;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class ImageViewState implements Serializable {
    public float centerX;
    public float centerY;
    public int orientation;
    public float scale;

    public ImageViewState(float f, PointF pointF, int i) {
        this.scale = f;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
