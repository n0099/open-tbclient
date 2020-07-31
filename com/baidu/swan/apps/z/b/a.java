package com.baidu.swan.apps.z.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public abstract class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final String TAG = a.class.getSimpleName();
    double cwB = 1.0d;
    protected Set<Integer> cwC;

    public abstract boolean a(Bitmap bitmap, Rect rect);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Bitmap bitmap, Rect rect) {
        if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
            return false;
        }
        return rect.top < rect.bottom && rect.bottom <= bitmap.getHeight() && rect.left < rect.right && rect.right <= bitmap.getWidth();
    }

    public void gu(int i) {
        if (this.cwC == null) {
            this.cwC = new TreeSet();
        } else {
            this.cwC.clear();
        }
        if (DEBUG) {
            Log.d(TAG, "set color " + String.format("#%06X", Integer.valueOf(16777215 & i)));
        }
        this.cwC.add(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(double d) {
        this.cwB = d;
    }

    /* renamed from: com.baidu.swan.apps.z.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0416a {
        public static a mK(String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case -2129978548:
                    if (str.equals("simple_parser")) {
                        c = 0;
                        break;
                    }
                    break;
                case -585839565:
                    if (str.equals("solid_parser")) {
                        c = 2;
                        break;
                    }
                    break;
                case 544848403:
                    if (str.equals("hsv_parser")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new c();
                case 1:
                    return new b();
                case 2:
                    return new d();
                default:
                    return new c();
            }
        }
    }
}
