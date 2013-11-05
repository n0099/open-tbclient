package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
class f implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f339a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, a aVar) {
        this.b = eVar;
        this.f339a = aVar;
    }

    @Override // android.support.v4.view.m
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f339a.b(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f339a.d(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void a(View view, Object obj) {
        this.f339a.a(view, new android.support.v4.view.a.a(obj));
    }

    @Override // android.support.v4.view.m
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f339a.c(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f339a.a(viewGroup, view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public void a(View view, int i) {
        this.f339a.a(view, i);
    }

    @Override // android.support.v4.view.m
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.f339a.a(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.m
    public Object a(View view) {
        android.support.v4.view.a.g a2 = this.f339a.a(view);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    @Override // android.support.v4.view.m
    public boolean a(View view, int i, Bundle bundle) {
        return this.f339a.a(view, i, bundle);
    }
}
