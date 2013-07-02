package android.support.v4.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class bs extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private bs(ViewPager viewPager) {
        this.a = viewPager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(ViewPager viewPager, bi biVar) {
        this(viewPager);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.a.b();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.b();
    }
}
