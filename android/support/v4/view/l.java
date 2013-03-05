package android.support.v4.view;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends DataSetObserver implements ai, aj {
    final /* synthetic */ PagerTitleStrip a;
    private int b;

    @Override // android.support.v4.view.aj
    public void a(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.a.a(i, f);
    }

    @Override // android.support.v4.view.aj
    public void a(int i) {
        if (this.b == 0) {
            this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
        }
    }

    @Override // android.support.v4.view.aj
    public void b(int i) {
        this.b = i;
    }

    @Override // android.support.v4.view.ai
    public void a(k kVar, k kVar2) {
        this.a.a(kVar, kVar2);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
    }
}
