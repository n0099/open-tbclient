package com.baidu.swan.apps.aa.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class d extends a {
    private static final String TAG = d.class.getSimpleName();

    @Override // com.baidu.swan.apps.aa.b.a
    public boolean a(Bitmap bitmap, Rect rect) {
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int i = 0;
        for (int i2 = rect.left + 1; i2 < rect.right - 1; i2++) {
            int i3 = rect.top + 1;
            while (i3 < rect.bottom - 1) {
                int pixel = bitmap.getPixel(i2, i3);
                int i4 = i == 0 ? pixel : i;
                if (i4 == pixel || pixel == 0) {
                    i3++;
                    i = i4;
                } else if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d(TAG, "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i2 + Constants.ACCEPT_TIME_SEPARATOR_SP + i3 + ")");
                    return false;
                } else {
                    return false;
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "color = " + i + "图片大小 " + rect.width() + " x " + rect.height());
        }
        return true;
    }
}
