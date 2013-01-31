package android.support.v4.view;

import android.database.DataSetObserver;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private ak(ViewPager viewPager) {
        this.a = viewPager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(ViewPager viewPager, ad adVar) {
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
