package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
/* loaded from: classes2.dex */
class l {
    public static void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence) {
        new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder()).bigText(charSequence);
    }
}
