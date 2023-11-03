package com.baidu.android.pushservice;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class PushNotificationBuilder implements Serializable {
    public String mChannelId;
    public String mChannelName;
    public int mColor;
    public String mGroup;
    public Bitmap mLargeIcon;
    public String mLargeIconUrl;
    public int mNotificationBuilderId;
    public String mNotificationBuilderRes;
    public int mNotificationDefaults;
    public int mNotificationFlags;
    public String mNotificationText;
    public String mNotificationTitle;
    public String mNotificationsound;
    public int mStatusbarIcon;
    public String mSummary;
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

    public void setLargeIcon(Bitmap bitmap) {
        this.mLargeIcon = bitmap;
    }

    public void setLargeIconUrl(String str) {
        this.mLargeIconUrl = str;
    }

    public void setNotificationBuilderId(int i) {
        this.mNotificationBuilderId = i;
    }

    public void setNotificationBuilderRes(String str) {
        this.mNotificationBuilderRes = str;
    }

    public void setNotificationDefaults(int i) {
        this.mNotificationDefaults = i;
    }

    public void setNotificationFlags(int i) {
        this.mNotificationFlags = i;
    }

    public void setNotificationGroup(String str) {
        this.mGroup = str;
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

    public void setSummary(String str) {
        this.mSummary = str;
    }
}
