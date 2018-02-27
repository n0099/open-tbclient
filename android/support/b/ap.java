package android.support.b;

import android.os.IBinder;
import android.view.View;
/* loaded from: classes2.dex */
class ap {
    private final IBinder wa;

    private ap(IBinder iBinder) {
        this.wa = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ap R(View view) {
        return new ap(view.getWindowToken());
    }

    public boolean equals(Object obj) {
        return (obj instanceof ap) && ((ap) obj).wa.equals(this.wa);
    }
}
