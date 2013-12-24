package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
class f implements m {
    final /* synthetic */ a a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    @Override // android.support.v4.view.m
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.b(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void a(View view, Object obj) {
        this.a.a(view, new android.support.v4.view.a.a(obj));
    }

    @Override // android.support.v4.view.m
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(viewGroup, view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void a(View view, int i) {
        this.a.a(view, i);
    }

    @Override // android.support.v4.view.m
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.a(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public Object a(View view) {
        android.support.v4.view.a.g a = this.a.a(view);
        if (a != null) {
            return a.a();
        }
        return null;
    }

    @Override // android.support.v4.view.m
    public boolean a(View view, int i, Bundle bundle) {
        return this.a.a(view, i, bundle);
    }
}
