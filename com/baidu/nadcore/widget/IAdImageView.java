package com.baidu.nadcore.widget;

import android.widget.ImageView;
/* loaded from: classes3.dex */
public interface IAdImageView {
    public static final ImageView.ScaleType[] l0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* loaded from: classes3.dex */
    public enum ImageScaleType {
        NONE(-1),
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        public final int nativeInt;

        ImageScaleType(int i) {
            this.nativeInt = i;
        }
    }
}
