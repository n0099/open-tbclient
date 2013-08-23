package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
class e extends b {
    @Override // android.support.v4.view.b, android.support.v4.view.g, android.support.v4.view.d
    public Object a(a aVar) {
        return k.a(new f(this, aVar));
    }

    @Override // android.support.v4.view.g, android.support.v4.view.d
    public android.support.v4.view.a.g a(Object obj, View view) {
        Object a2 = k.a(obj, view);
        if (a2 != null) {
            return new android.support.v4.view.a.g(a2);
        }
        return null;
    }

    @Override // android.support.v4.view.g, android.support.v4.view.d
    public boolean a(Object obj, View view, int i, Bundle bundle) {
        return k.a(obj, view, i, bundle);
    }
}
