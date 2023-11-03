package com.baidu.android.pushservice.x;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.PushNotificationBuilder;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes.dex */
public class k extends PushNotificationBuilder {
    public static boolean a;

    public final g a(Context context, int i, String str) {
        return new d().a(context, i, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification construct(Context context) {
        String str;
        int i;
        g a2 = a(context, this.mNotificationBuilderId, this.mNotificationBuilderRes);
        Notification.Builder builder = new Notification.Builder(context);
        if (a2 != null) {
            a2.d(this.mNotificationTitle);
            a2.a(this.mNotificationText);
            a2.b(this.mLargeIconUrl);
            a2.c(this.mSummary);
        }
        int i2 = this.mNotificationDefaults;
        if (i2 != 0) {
            builder.setDefaults(i2);
        }
        String str2 = this.mNotificationsound;
        if (str2 != null) {
            builder.setSound(Uri.parse(str2));
        }
        Bitmap bitmap = this.mLargeIcon;
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
        }
        long[] jArr = this.mVibratePattern;
        if (jArr != null) {
            builder.setVibrate(jArr);
        }
        int i3 = this.mStatusbarIcon;
        if (i3 == 0) {
            if (context.getPackageName().equals("com.baidu.searchbox") || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                try {
                    i3 = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", ResourceManager.DRAWABLE, context.getPackageName());
                } catch (Throwable unused) {
                }
                if (i3 == 0) {
                    i3 = context.getApplicationInfo().icon;
                }
            }
            i3 = 0;
            if (i3 == 0) {
            }
        }
        builder.setSmallIcon(i3);
        builder.setContentTitle(this.mNotificationTitle);
        builder.setContentText(this.mNotificationText);
        if (Build.VERSION.SDK_INT >= 21 && (i = this.mColor) != 0) {
            builder.setColor(i);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2 != null) {
                str = a2.b();
            } else {
                com.baidu.android.pushservice.a0.h.a(context, "com.baidu.android.pushservice.push", "云推送");
                str = this.mChannelId;
            }
            builder.setChannelId(str);
        }
        if (Build.VERSION.SDK_INT < 26 || a2 == null) {
            a = true;
        } else {
            RemoteViews c = a2.c();
            if (c != null) {
                if (a2.e()) {
                    builder.setCustomBigContentView(c);
                    builder.setContentTitle(a2.d);
                    builder.setContentText(a2.e);
                } else {
                    builder.setCustomContentView(c);
                }
                a = false;
            } else {
                a = true;
            }
            RemoteViews d = a2.d();
            if (d != null) {
                builder.setCustomHeadsUpContentView(d);
            }
        }
        if (!TextUtils.isEmpty(this.mGroup) && Build.VERSION.SDK_INT >= 24) {
            builder.setGroup(this.mGroup);
        }
        Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (build != null) {
            int i4 = this.mNotificationFlags;
            if (i4 != 0) {
                build.flags = i4;
            } else {
                build.flags = 16 | build.flags;
            }
        }
        return build;
    }
}
