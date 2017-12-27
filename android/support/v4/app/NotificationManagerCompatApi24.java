package android.support.v4.app;

import android.app.NotificationManager;
/* loaded from: classes2.dex */
class NotificationManagerCompatApi24 {
    public static boolean areNotificationsEnabled(NotificationManager notificationManager) {
        return notificationManager.areNotificationsEnabled();
    }

    public static int getImportance(NotificationManager notificationManager) {
        return notificationManager.getImportance();
    }
}
