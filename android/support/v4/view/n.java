package android.support.v4.view;

import android.os.Build;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    static final o f99a;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f99a = new q();
        } else {
            f99a = new p();
        }
    }

    public static int a(int i, int i2) {
        return f99a.a(i, i2);
    }
}
