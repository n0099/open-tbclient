package android.support.v4.app;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ Fragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Fragment fragment) {
        this.a = fragment;
    }

    @Override // android.support.v4.app.s
    public View a(int i) {
        if (this.a.R == null) {
            throw new IllegalStateException("Fragment does not have a view");
        }
        return this.a.R.findViewById(i);
    }
}
