package android.support.v4.widget;

import android.database.ContentObserver;
/* loaded from: classes.dex */
class a extends ContentObserver {
    final /* synthetic */ CursorAdapter a;

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.a.b();
    }
}
