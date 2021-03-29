package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class PushNotificationBuilder implements Serializable {
    public String mChannelId;
    public String mChannelName;
    public int mColor;
    public int mNotificationDefaults;
    public int mNotificationFlags;
    public String mNotificationText;
    public String mNotificationTitle;
    public String mNotificationsound;
    public int mStatusbarIcon;
    public long[] mVibratePattern;

    public abstract Notification construct(Context context);

    public void setChannelId(String str) {
        this.mChannelId = str;
    }

    public void setChannelName(String str) {
        this.mChannelName = str;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setNotificationSound(String str) {
        this.mNotificationsound = str;
    }

    public void setNotificationText(String str) {
        this.mNotificationText = str;
    }

    public void setNotificationTitle(String str) {
        this.mNotificationTitle = str;
    }

    public void setStatusbarIcon(int i) {
        this.mStatusbarIcon = i;
    }
}
