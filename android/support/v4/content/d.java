package android.support.v4.content;

import android.database.ContentObserver;
/* loaded from: classes.dex */
public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f301a;

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f301a.s();
    }
}
