package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.apollon.utils.DisplayUtils;
import java.io.File;
import java.io.FileNotFoundException;
/* loaded from: classes2.dex */
public class ImageProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3684a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final int f3685b;

    public ImageProcessor(Context context) {
        this.f3685b = ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2;
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int b2 = b(options, i, i2);
        if (b2 <= 8) {
            int i3 = 1;
            while (i3 < b2) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((b2 + 7) / 8) * 8;
    }

    public static int b(BitmapFactory.Options options, int i, int i2) {
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

    public Bitmap decode(File file, int i) throws FileNotFoundException {
        if (file != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = a(options, -1, this.f3685b);
                    options.inJustDecodeBounds = false;
                    options.inDensity = i;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return BitmapFactory.decodeFile(file.getPath(), options);
                }
            } catch (OutOfMemoryError unused) {
            }
            return null;
        }
        throw new FileNotFoundException("The file is null");
    }
}
