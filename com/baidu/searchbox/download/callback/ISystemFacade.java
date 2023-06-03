package com.baidu.searchbox.download.callback;

import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
/* loaded from: classes3.dex */
public interface ISystemFacade {
    void cancelAllNotifications();

    void cancelNotification(long j);

    long currentTimeMillis();

    Integer getActiveNetworkType();

    Long getMaxBytesOverMobile();

    Long getRecommendedMaxBytesOverMobile();

    boolean isNetworkRoaming();

    void postNotification(long j, Notification notification);

    void sendBroadcast(Intent intent);

    void startThread(Thread thread);

    boolean userOwnsPackage(int i, String str) throws PackageManager.NameNotFoundException;
}
