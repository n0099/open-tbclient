package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class BasicPushNotificationBuilder extends PushNotificationBuilder {
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mStatusbarIcon = objectInputStream.readInt();
        this.mNotificationFlags = objectInputStream.readInt();
        this.mNotificationDefaults = objectInputStream.readInt();
        if (objectInputStream.readBoolean()) {
            this.mNotificationsound = (String) objectInputStream.readObject();
        }
        int readInt = objectInputStream.readInt();
        this.mVibratePattern = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            this.mVibratePattern[i] = objectInputStream.readLong();
        }
        this.mNotificationTitle = (String) objectInputStream.readObject();
        this.mNotificationText = (String) objectInputStream.readObject();
        this.mChannelId = (String) objectInputStream.readObject();
        this.mChannelName = (String) objectInputStream.readObject();
        this.mLargeIcon = (Bitmap) objectInputStream.readObject();
        this.mColor = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.mStatusbarIcon);
        objectOutputStream.writeInt(this.mNotificationFlags);
        objectOutputStream.writeInt(this.mNotificationDefaults);
        int i = 0;
        if (this.mNotificationsound != null) {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(this.mNotificationsound);
        } else {
            objectOutputStream.writeBoolean(false);
        }
        long[] jArr = this.mVibratePattern;
        if (jArr != null) {
            objectOutputStream.writeInt(jArr.length);
            while (true) {
                long[] jArr2 = this.mVibratePattern;
                if (i >= jArr2.length) {
                    break;
                }
                objectOutputStream.writeLong(jArr2[i]);
                i++;
            }
        } else {
            objectOutputStream.writeInt(0);
        }
        objectOutputStream.writeObject(this.mNotificationTitle);
        objectOutputStream.writeObject(this.mNotificationText);
        objectOutputStream.writeObject(this.mChannelId);
        objectOutputStream.writeObject(this.mChannelName);
        objectOutputStream.writeObject(this.mLargeIcon);
        objectOutputStream.writeInt(this.mColor);
    }

    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    @SuppressLint({"NewApi"})
    public Notification construct(Context context) {
        int i;
        String str;
        int i2;
        Notification.Builder builder = new Notification.Builder(context);
        int i3 = this.mNotificationDefaults;
        if (i3 != 0) {
            builder.setDefaults(i3);
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
        int i4 = this.mStatusbarIcon;
        if (i4 == 0) {
            i4 = 0;
            if (context.getPackageName().equals("com.baidu.searchbox") || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                try {
                    i4 = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", ResourceManager.DRAWABLE, context.getPackageName());
                } catch (Throwable unused) {
                }
            }
            if (i4 == 0) {
                i4 = context.getApplicationInfo().icon;
            }
        }
        builder.setSmallIcon(i4);
        if (!TextUtils.isEmpty(this.mGroup) && Build.VERSION.SDK_INT >= 24) {
            builder.setGroup(this.mGroup);
        }
        builder.setContentTitle(this.mNotificationTitle);
        builder.setContentText(this.mNotificationText);
        if (Build.VERSION.SDK_INT >= 21 && (i2 = this.mColor) != 0) {
            builder.setColor(i2);
        }
        if (Utility.E(context)) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = "com.baidu.android.pushservice.push";
            }
            if (TextUtils.isEmpty(this.mChannelName)) {
                this.mChannelName = "云推送";
            }
            String str3 = "com.baidu.android.pushservice.push.importance_low";
            if (this.mChannelId.equals("com.baidu.android.pushservice.push.importance_low")) {
                i = 1;
                str = "云推送静默";
            } else {
                str3 = "com.baidu.android.pushservice.push.importance_HIGH";
                if (this.mChannelId.equals("com.baidu.android.pushservice.push.importance_HIGH")) {
                    i = 4;
                    str = "云通知";
                } else {
                    com.baidu.android.pushservice.a0.h.a(context, this.mChannelId, this.mChannelName);
                    builder.setChannelId(this.mChannelId);
                }
            }
            com.baidu.android.pushservice.a0.h.a(context, str3, str, i);
            builder.setChannelId(this.mChannelId);
        }
        Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (build != null) {
            int i5 = this.mNotificationFlags;
            if (i5 == 0) {
                i5 = build.flags | 16;
            }
            build.flags = i5;
        }
        return build;
    }
}
