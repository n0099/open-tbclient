package android.support.v4.view.a;

import android.os.Build;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final c f315a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f315a = new d();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f315a = new b();
        } else {
            f315a = new e();
        }
    }

    public a(Object obj) {
        this.b = obj;
    }

    public Object a() {
        return this.b;
    }

    public void a(int i) {
        f315a.a(this.b, i);
    }

    public void a(boolean z) {
        f315a.a(this.b, z);
    }

    public void a(CharSequence charSequence) {
        f315a.a(this.b, charSequence);
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.b == null ? aVar.b == null : this.b.equals(aVar.b);
        }
        return false;
    }
}
