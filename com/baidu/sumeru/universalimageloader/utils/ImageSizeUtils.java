package com.baidu.sumeru.universalimageloader.utils;

import android.opengl.GLES10;
import com.baidu.sumeru.universalimageloader.core.assist.ImageSize;
import com.baidu.sumeru.universalimageloader.core.assist.ViewScaleType;
import com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware;
/* loaded from: classes11.dex */
public final class ImageSizeUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static ImageSize maxBitmapSize;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], 2048);
        maxBitmapSize = new ImageSize(max, max);
    }

    private ImageSizeUtils() {
    }

    public static ImageSize defineTargetSizeForView(ImageAware imageAware, ImageSize imageSize) {
        int width = imageAware.getWidth();
        if (width <= 0) {
            width = imageSize.getWidth();
        }
        int height = imageAware.getHeight();
        if (height <= 0) {
            height = imageSize.getHeight();
        }
        return new ImageSize(width, height);
    }

    public static int computeImageSampleSize(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int min;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        int i = width / width2;
        int i2 = height / height2;
        switch (viewScaleType) {
            case FIT_INSIDE:
                if (!z) {
                    min = Math.max(i, i2);
                    break;
                } else {
                    int i3 = width;
                    int i4 = height;
                    min = 1;
                    while (true) {
                        if (i3 / 2 < width2 && i4 / 2 < height2) {
                            break;
                        } else {
                            i3 /= 2;
                            i4 /= 2;
                            min *= 2;
                        }
                    }
                }
                break;
            case CROP:
                if (z) {
                    int i5 = width;
                    int i6 = height;
                    min = 1;
                    while (i5 / 2 >= width2 && i6 / 2 >= height2) {
                        i5 /= 2;
                        i6 /= 2;
                        min *= 2;
                    }
                } else {
                    min = Math.min(i, i2);
                    break;
                }
                break;
            default:
                min = 1;
                break;
        }
        if (min < 1) {
            return 1;
        }
        return min;
    }

    public static int computeMinImageSampleSize(ImageSize imageSize) {
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        return Math.max((int) Math.ceil(width / maxBitmapSize.getWidth()), (int) Math.ceil(height / maxBitmapSize.getHeight()));
    }

    public static float computeImageScale(ImageSize imageSize, ImageSize imageSize2, ViewScaleType viewScaleType, boolean z) {
        int i;
        int i2;
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = width / width2;
        float f2 = height / height2;
        if ((viewScaleType == ViewScaleType.FIT_INSIDE && f >= f2) || (viewScaleType == ViewScaleType.CROP && f < f2)) {
            i = width2;
            i2 = (int) (height / f);
        } else {
            i = (int) (width / f2);
            i2 = height2;
        }
        if ((z || i >= width || i2 >= height) && (!z || i == width || i2 == height)) {
            return 1.0f;
        }
        return i / width;
    }
}
