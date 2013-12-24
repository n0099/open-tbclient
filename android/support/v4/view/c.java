package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
class c implements j {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    @Override // android.support.v4.view.j
    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.b(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.j
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.d(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.j
    public void a(View view, Object obj) {
        this.a.a(view, new android.support.v4.view.a.a(obj));
    }

    @Override // android.support.v4.view.j
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.j
    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(viewGroup, view, accessibilityEvent);
    }

    @Override // android.support.v4.view.j
    public void a(View view, int i) {
        this.a.a(view, i);
    }

    @Override // android.support.v4.view.j
    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.a(view, accessibilityEvent);
    }
}
