package android.support.v4.app;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Fragment f295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Fragment fragment) {
        this.f295a = fragment;
    }

    @Override // android.support.v4.app.s
    public View a(int i) {
        if (this.f295a.R == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.f295a.R.findViewById(i);
    }
}
