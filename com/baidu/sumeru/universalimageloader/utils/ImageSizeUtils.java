package com.baidu.sumeru.universalimageloader.utils;

import android.opengl.GLES10;
import com.baidu.sumeru.universalimageloader.core.assist.ImageSize;
import com.baidu.sumeru.universalimageloader.core.assist.ViewScaleType;
import com.baidu.sumeru.universalimageloader.core.imageaware.ImageAware;
/* loaded from: classes5.dex */
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
                    min = 1;
                    while (true) {
                        if (width / 2 < width2 && height / 2 < height2) {
                            break;
                        } else {
                            width /= 2;
                            height /= 2;
                            min *= 2;
                        }
                    }
                }
                break;
            case CROP:
                if (z) {
                    min = 1;
                    while (width / 2 >= width2 && height / 2 >= height2) {
                        width /= 2;
                        height /= 2;
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
        int width = imageSize.getWidth();
        int height = imageSize.getHeight();
        int width2 = imageSize2.getWidth();
        int height2 = imageSize2.getHeight();
        float f = width / width2;
        float f2 = height / height2;
        if ((viewScaleType == ViewScaleType.FIT_INSIDE && f >= f2) || (viewScaleType == ViewScaleType.CROP && f < f2)) {
            i = (int) (height / f);
        } else {
            width2 = (int) (width / f2);
            i = height2;
        }
        if ((z || width2 >= width || i >= height) && (!z || width2 == width || i == height)) {
            return 1.0f;
        }
        return width2 / width;
    }
}
