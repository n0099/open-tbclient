package android.support.transition;

import android.os.IBinder;
import android.support.annotation.NonNull;
import android.view.View;
/* loaded from: classes2.dex */
class WindowIdPort {
    private final IBinder mToken;

    private WindowIdPort(IBinder iBinder) {
        this.mToken = iBinder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WindowIdPort getWindowId(@NonNull View view2) {
        return new WindowIdPort(view2.getWindowToken());
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdPort) && ((WindowIdPort) obj).mToken.equals(this.mToken);
    }
}
