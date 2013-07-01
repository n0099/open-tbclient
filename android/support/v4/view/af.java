package android.support.v4.view;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends DataSetObserver implements bp, bq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PagerTitleStrip f86a;
    private int b;

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.f86a.a(i, f, false);
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        float f;
        if (this.b == 0) {
            this.f86a.a(this.f86a.f82a.getCurrentItem(), this.f86a.f82a.getAdapter());
            f = this.f86a.g;
            this.f86a.a(this.f86a.f82a.getCurrentItem(), f >= 0.0f ? this.f86a.g : 0.0f, true);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        this.b = i;
    }

    @Override // android.support.v4.view.bp
    public void a(ae aeVar, ae aeVar2) {
        this.f86a.a(aeVar, aeVar2);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        float f;
        this.f86a.a(this.f86a.f82a.getCurrentItem(), this.f86a.f82a.getAdapter());
        f = this.f86a.g;
        this.f86a.a(this.f86a.f82a.getCurrentItem(), f >= 0.0f ? this.f86a.g : 0.0f, true);
    }
}
