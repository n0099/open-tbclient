package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes2.dex */
public abstract class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected static final String TAG = a.class.getSimpleName();
    double aEb = 1.0d;
    protected Set<Integer> aEc;

    public abstract boolean a(Bitmap bitmap, Rect rect);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Bitmap bitmap, Rect rect) {
        if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
            return false;
        }
        return rect.top < rect.bottom && rect.bottom <= bitmap.getHeight() && rect.left < rect.right && rect.right <= bitmap.getWidth();
    }

    public void cO(int i) {
        if (this.aEc == null) {
            this.aEc = new TreeSet();
        } else {
            this.aEc.clear();
        }
        if (DEBUG) {
            Log.d(TAG, "set color " + String.format("#%06X", Integer.valueOf(16777215 & i)));
        }
        this.aEc.add(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(double d) {
        this.aEb = d;
    }

    /* renamed from: com.baidu.swan.apps.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0192a {
        public static a fz(String str) {
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
                    return new d();
                case 1:
                    return new b();
                case 2:
                    return new e();
                default:
                    return new d();
            }
        }
    }
}
