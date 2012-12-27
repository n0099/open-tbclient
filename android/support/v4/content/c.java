package android.support.v4.content;

import android.database.ContentObserver;
/* loaded from: classes.dex */
public final class c extends ContentObserver {
    final /* synthetic */ b a;

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.a.s();
    }
}
