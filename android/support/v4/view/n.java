package android.support.v4.view;

import android.os.Build;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    static final o f332a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f332a = new q();
        } else {
            f332a = new p();
        }
    }

    public static int a(int i, int i2) {
        return f332a.a(i, i2);
    }
}
