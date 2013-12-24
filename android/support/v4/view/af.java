package android.support.v4.view;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends DataSetObserver implements bp, bq {
    final /* synthetic */ PagerTitleStrip a;
    private int b;

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.a.a(i, f, false);
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        float f;
        if (this.b == 0) {
            this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
            f = this.a.g;
            this.a.a(this.a.a.getCurrentItem(), f >= 0.0f ? this.a.g : 0.0f, true);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        this.b = i;
    }

    @Override // android.support.v4.view.bp
    public void a(ae aeVar, ae aeVar2) {
        this.a.a(aeVar, aeVar2);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        float f;
        this.a.a(this.a.a.getCurrentItem(), this.a.a.getAdapter());
        f = this.a.g;
        this.a.a(this.a.a.getCurrentItem(), f >= 0.0f ? this.a.g : 0.0f, true);
    }
}
