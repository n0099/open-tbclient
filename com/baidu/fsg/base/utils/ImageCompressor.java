package com.baidu.fsg.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes2.dex */
public class ImageCompressor {
    public static final int UNCONSTRAINED = -1;

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int ceil;
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        if (i2 == -1) {
            ceil = 1;
        } else {
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i2;
            Double.isNaN(d4);
            ceil = (int) Math.ceil(Math.sqrt((d2 * d3) / d4));
        }
        if (i == -1) {
            min = 128;
        } else {
            double d5 = i;
            Double.isNaN(d2);
            Double.isNaN(d5);
            double floor = Math.floor(d2 / d5);
            Double.isNaN(d3);
            Double.isNaN(d5);
            min = (int) Math.min(floor, Math.floor(d3 / d5));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int a2 = a(options, i, i2);
        if (a2 <= 8) {
            int i3 = 1;
            while (i3 < a2) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((a2 + 7) / 8) * 8;
    }

    public Bitmap decode(Context context, File file, int i) throws FileNotFoundException {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                options.inSampleSize = computeSampleSize(options, -1, ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2);
                options.inJustDecodeBounds = false;
                options.inDensity = i;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            }
        } catch (OutOfMemoryError unused) {
        }
        return null;
    }
}
