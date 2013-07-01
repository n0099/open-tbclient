package android.support.v4.view;

import android.database.DataSetObserver;
/* loaded from: classes.dex */
class bs extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f94a;

    private bs(ViewPager viewPager) {
        this.f94a = viewPager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bs(ViewPager viewPager, bi biVar) {
        this(viewPager);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f94a.b();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f94a.b();
    }
}
