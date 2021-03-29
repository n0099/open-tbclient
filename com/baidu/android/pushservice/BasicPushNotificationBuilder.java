package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
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
        objectOutputStream.writeInt(this.mColor);
    }

    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    @SuppressLint({"NewApi"})
    public Notification construct(Context context) {
        int i;
        Notification.Builder builder = new Notification.Builder(context);
        int i2 = this.mNotificationDefaults;
        if (i2 != 0) {
            builder.setDefaults(i2);
        }
        String str = this.mNotificationsound;
        if (str != null) {
            builder.setSound(Uri.parse(str));
        }
        long[] jArr = this.mVibratePattern;
        if (jArr != null) {
            builder.setVibrate(jArr);
        }
        int i3 = this.mStatusbarIcon;
        if (i3 == 0) {
            i3 = 0;
            if (context.getPackageName().equals("com.baidu.searchbox") || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                try {
                    i3 = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", "drawable", context.getPackageName());
                } catch (Throwable unused) {
                }
            }
            if (i3 == 0) {
                i3 = context.getApplicationInfo().icon;
            }
        }
        builder.setSmallIcon(i3);
        builder.setContentTitle(this.mNotificationTitle);
        builder.setContentText(this.mNotificationText);
        if (Build.VERSION.SDK_INT >= 21 && (i = this.mColor) != 0) {
            builder.setColor(i);
        }
        if (m.p(context)) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = "com.baidu.android.pushservice.push";
            }
            if (TextUtils.isEmpty(this.mChannelName)) {
                this.mChannelName = "云推送";
            }
            com.baidu.android.pushservice.j.h.a(context, this.mChannelId, this.mChannelName);
            builder.setChannelId(this.mChannelId);
        }
        Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (build != null) {
            int i4 = this.mNotificationFlags;
            if (i4 == 0) {
                i4 = build.flags | 16;
            }
            build.flags = i4;
        }
        return build;
    }
}
