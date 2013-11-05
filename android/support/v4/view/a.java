package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
public class a {
    private static final d b;
    private static final Object c;

    /* renamed from: a  reason: collision with root package name */
    final Object f324a = b.a(this);

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
        return this.f324a;
    }

    public void a(View view, int i) {
        b.a(c, view, i);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        b.d(c, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        b.c(c, view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        b.b(c, view, accessibilityEvent);
    }

    public void a(View view, android.support.v4.view.a.a aVar) {
        b.a(c, view, aVar);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return b.a(c, viewGroup, view, accessibilityEvent);
    }

    public android.support.v4.view.a.g a(View view) {
        return b.a(c, view);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return b.a(c, view, i, bundle);
    }
}
