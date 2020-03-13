package com.baidu.swan.apps.ac.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
class c extends a {
    private static final String TAG = c.class.getSimpleName();

    @Override // com.baidu.swan.apps.ac.b.a
    public boolean a(Bitmap bitmap, Rect rect) {
        boolean z;
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int pixel = bitmap.getPixel(rect.left + 1, rect.top + 1);
        boolean z2 = pixel == -1 || pixel == -657931;
        if (!z2 && this.bGd != null) {
            for (Integer num : this.bGd) {
                if (num.intValue() == pixel) {
                    z = true;
                    break;
                }
            }
        }
        z = z2;
        if (!z) {
            return false;
        }
        int i = rect.left;
        while (true) {
            i++;
            if (i < rect.right - 1) {
                int i2 = rect.top;
                while (true) {
                    i2++;
                    if (i2 < rect.bottom - 1) {
                        if (pixel != bitmap.getPixel(i, i2)) {
                            if (com.baidu.swan.apps.b.DEBUG) {
                                Log.d(TAG, "非白屏, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + ")");
                            }
                            return false;
                        }
                    }
                }
            } else {
                if (DEBUG) {
                    Log.d(TAG, "白屏, 图片大小 " + rect.width() + " x " + rect.height());
                }
                return true;
            }
        }
    }
}
