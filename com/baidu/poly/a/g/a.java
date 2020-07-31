package com.baidu.poly.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileDescriptor;
/* loaded from: classes9.dex */
public class a {
    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return options.inSampleSize <= 1 ? BitmapFactory.decodeFileDescriptor(fileDescriptor) : BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }
}
