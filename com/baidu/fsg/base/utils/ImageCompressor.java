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

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
        if (i2 == -1) {
            min = 128;
        } else {
            double d4 = i2;
            min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? ceil : min;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int a2 = a(options, i2, i3);
        if (a2 <= 8) {
            int i4 = 1;
            while (i4 < a2) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((a2 + 7) / 8) * 8;
    }

    public Bitmap decode(Context context, File file, int i2) throws FileNotFoundException {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                options.inSampleSize = computeSampleSize(options, -1, ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2);
                options.inJustDecodeBounds = false;
                options.inDensity = i2;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            }
        } catch (OutOfMemoryError unused) {
        }
        return null;
    }
}
