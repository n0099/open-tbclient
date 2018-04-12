package android.support.v4.app;

import android.app.Service;
/* loaded from: classes2.dex */
class ServiceCompatApi24 {
    ServiceCompatApi24() {
    }

    public static void stopForeground(Service service, int i) {
        service.stopForeground(i);
    }
}
