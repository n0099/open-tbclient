package android.support.v4.view.a;

import android.os.Build;
import android.os.Bundle;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final h f326a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f326a = new i();
        } else {
            f326a = new k();
        }
    }

    public g() {
        this.b = f326a.a(this);
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
