package android.support.v7.app;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
/* loaded from: classes2.dex */
class i {
    public static void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, int[] iArr, Object obj) {
        Notification.MediaStyle mediaStyle = new Notification.MediaStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        if (iArr != null) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
        if (obj != null) {
            mediaStyle.setMediaSession((MediaSession.Token) obj);
        }
    }
}
