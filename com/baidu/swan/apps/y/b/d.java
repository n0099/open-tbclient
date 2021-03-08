package com.baidu.swan.apps.y.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
/* loaded from: classes8.dex */
public class d extends a {
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
        r0 = r0 + 1;
     */
    @Override // com.baidu.swan.apps.y.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Bitmap bitmap, Rect rect) {
        if (DEBUG) {
            Log.d("SolidErrorPageParser", "SolidErrorPageParser: start error page parse");
        }
        if (bitmap == null) {
            return false;
        }
        if (!b(bitmap, rect)) {
            rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        int i = rect.left + 1;
        int i2 = 0;
        while (i < rect.right - 1) {
            int i3 = rect.top;
            while (true) {
                i3++;
                if (i3 < rect.bottom - 1) {
                    int pixel = bitmap.getPixel(i, i3);
                    if (i2 == 0) {
                        i2 = pixel;
                    }
                    if (i2 != pixel && pixel != 0) {
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.d("SolidErrorPageParser", "非纯色, 图片大小 " + bitmap.getWidth() + " x " + bitmap.getHeight() + "; rect + " + rect.toShortString() + "; (" + i + "," + i3 + ")");
                            return false;
                        }
                        return false;
                    }
                }
            }
        }
        if (DEBUG) {
            Log.d("SolidErrorPageParser", "color = " + i2 + "图片大小 " + rect.width() + " x " + rect.height());
        }
        return true;
    }
}
