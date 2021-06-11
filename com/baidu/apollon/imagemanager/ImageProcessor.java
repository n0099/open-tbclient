package com.baidu.apollon.imagemanager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.apollon.utils.DisplayUtils;
import java.io.File;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
public class ImageProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3790a = -1;

    /* renamed from: b  reason: collision with root package name */
    public final int f3791b;

    public ImageProcessor(Context context) {
        this.f3791b = ((DisplayUtils.getDisplayWidth(context) * DisplayUtils.getDisplayHeight(context)) * 3) / 2;
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        if (b2 <= 8) {
            int i4 = 1;
            while (i4 < b2) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((b2 + 7) / 8) * 8;
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
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

    public Bitmap decode(File file, int i2) throws FileNotFoundException {
        if (file != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = a(options, -1, this.f3791b);
                    options.inJustDecodeBounds = false;
                    options.inDensity = i2;
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
