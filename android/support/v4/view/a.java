package android.support.v4.view;

import android.os.Build;
/* loaded from: classes.dex */
public class a {
    private static final d b;
    private static final Object c;

    /* renamed from: a  reason: collision with root package name */
    final Object f85a = b.a(this);

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            b = new e();
        } else if (Build.VERSION.SDK_INT >= 14) {
            b = new b();
        } else {
            b = new g();
        }
        c = b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a() {
        return this.f85a;
    }
}
