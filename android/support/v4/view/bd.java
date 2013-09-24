package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class bd {

    /* renamed from: a  reason: collision with root package name */
    static final bg f323a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f323a = new bf();
        } else {
            f323a = new be();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return f323a.a(viewConfiguration);
    }
}
