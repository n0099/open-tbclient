package android.support.v4.widget;

import android.database.ContentObserver;
/* loaded from: classes.dex */
class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CursorAdapter f350a;

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.f350a.b();
    }
}
