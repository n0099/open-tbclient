package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class NotificationCompatJellybean {
    private Notification.Builder b;

    public NotificationCompatJellybean(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4) {
        this.b = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(pendingIntent2, (notification.flags & 128) != 0).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
    }

    public void addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.b.addAction(i, charSequence, pendingIntent);
    }

    public void addBigTextStyle(CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(this.b).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public void addBigPictureStyle(CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(this.b).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public void addInboxStyle(CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(this.b).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator<CharSequence> it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    public Notification build() {
        return this.b.build();
    }
}
