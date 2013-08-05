package android.support.v4.view;

import android.os.Build;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    static final o f324a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f324a = new q();
        } else {
            f324a = new p();
        }
    }

    public static int a(int i, int i2) {
        return f324a.a(i, i2);
    }
}
