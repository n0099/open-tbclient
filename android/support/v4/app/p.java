package android.support.v4.app;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.f297a = nVar;
    }

    @Override // android.support.v4.app.s
    public View a(int i) {
        return this.f297a.findViewById(i);
    }
}
