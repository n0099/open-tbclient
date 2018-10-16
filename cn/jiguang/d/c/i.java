package cn.jiguang.d.c;

import android.support.v7.widget.ActivityChooserView;
import java.util.HashMap;
/* loaded from: classes3.dex */
final class i {
    private static Integer[] lQ = new Integer[64];
    private String d;
    private String f;
    private boolean h;
    private int e = 3;
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private int g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    static {
        for (int i = 0; i < lQ.length; i++) {
            lQ[i] = Integer.valueOf(i);
        }
    }

    public i(String str, int i) {
        this.d = str;
    }

    private void d(int i) {
        if (i < 0 || i > this.g) {
            throw new IllegalArgumentException(this.d + " " + i + "is out of range");
        }
    }

    private static Integer n(int i) {
        return (i < 0 || i >= lQ.length) ? Integer.valueOf(i) : lQ[i];
    }

    public final void a(int i) {
        this.g = 3;
    }

    public final void a(int i, String str) {
        d(i);
        Integer n = n(i);
        if (this.e == 2) {
            str = str.toUpperCase();
        } else if (this.e == 3) {
            str = str.toLowerCase();
        }
        this.b.put(str, n);
        this.c.put(n, str);
    }

    public final void a(boolean z) {
        this.h = true;
    }

    public final String b(int i) {
        d(i);
        String str = (String) this.c.get(n(i));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i);
        return this.f != null ? this.f + num : num;
    }
}
