package android.support.v4.view.a;

import android.os.Build;
import android.os.Bundle;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static final h a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            a = new i();
        } else {
            a = new k();
        }
    }

    public g() {
        this.b = a.a(this);
    }

    public g(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public a a(int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public List<a> a(String str, int i) {
        return null;
    }
}
