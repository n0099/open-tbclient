package com.baidu.swan.apps.y.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes8.dex */
public abstract class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    double cEv = 1.0d;
    protected Set<Integer> cEw;

    public abstract boolean a(Bitmap bitmap, Rect rect);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(Bitmap bitmap, Rect rect) {
        if (bitmap == null || rect == null || rect.top < 0 || rect.bottom < 0 || rect.left < 0 || rect.right < 0) {
            return false;
        }
        return rect.top < rect.bottom && rect.bottom <= bitmap.getHeight() && rect.left < rect.right && rect.right <= bitmap.getWidth();
    }

    public void iA(int i) {
        if (this.cEw == null) {
            this.cEw = new TreeSet();
        } else {
            this.cEw.clear();
        }
        if (DEBUG) {
            Log.d("ErrorPageParser", "set color " + String.format("#%06X", Integer.valueOf(16777215 & i)));
        }
        this.cEw.add(Integer.valueOf(i));
    }

    /* renamed from: com.baidu.swan.apps.y.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0461a {
        public static a oJ(String str) {
            return b(str, 0.5d);
        }

        public static a b(String str, double d) {
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
                    return new b(d);
                case 2:
                    return new d();
                default:
                    return new c();
            }
        }
    }
}
