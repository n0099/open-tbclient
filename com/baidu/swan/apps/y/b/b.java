package com.baidu.swan.apps.y.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
/* loaded from: classes8.dex */
public class b extends a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(double d) {
        this.dmw = d;
    }

    @Override // com.baidu.swan.apps.y.b.a
    public boolean a(Bitmap bitmap, Rect rect) {
        int i;
        if (DEBUG) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int width = rect.width() - 2;
        int height = rect.height() - 2;
        int i2 = width / 3;
        int i3 = height / i2;
        int ceil = (int) Math.ceil(i3 * 3 * this.dmw);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < 3) {
                int i7 = (i6 * i2) + 1 + rect.left;
                int i8 = i6 == 2 ? width + 1 : ((i6 + 1) * i2) + rect.left;
                int i9 = 0;
                while (i9 < i3) {
                    if (a(bitmap, i7, (i9 * i2) + 1 + rect.top, i8, i9 == i3 + (-1) ? height + 1 : ((i9 + 1) * i2) + rect.top)) {
                        i = i4 + 1;
                        if (i >= ceil) {
                            return true;
                        }
                    } else {
                        i = i4;
                    }
                    i9++;
                    i4 = i;
                }
                i5 = i6 + 1;
            } else {
                return false;
            }
        }
    }

    public double c(Bitmap bitmap, Rect rect) {
        if (DEBUG) {
            Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return 0.0d;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int width = rect.width() - 2;
        int height = rect.height() - 2;
        int i = width / 3;
        int i2 = height / i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < 3) {
                int i6 = (i5 * i) + 1 + rect.left;
                int i7 = i5 == 2 ? width + 1 : ((i5 + 1) * i) + rect.left;
                int i8 = 0;
                while (i8 < i2) {
                    int i9 = a(bitmap, i6, ((i8 * i) + 1) + rect.top, i7, i8 == i2 + (-1) ? height + 1 : ((i8 + 1) * i) + rect.top) ? i3 + 1 : i3;
                    i8++;
                    i3 = i9;
                }
                i4 = i5 + 1;
            } else {
                return i3 / (i2 * 3);
            }
        }
    }

    private boolean a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < i || i2 < 0 || i4 < i2) {
            return false;
        }
        int pixel = bitmap.getPixel(i, i2);
        while (i <= i3) {
            for (int i5 = i2; i5 <= i4; i5++) {
                if (pixel != bitmap.getPixel(i, i5)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}
