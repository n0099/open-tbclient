package com.baidu.adp.plugin.a;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
/* loaded from: classes.dex */
public interface b {
    Service getService();

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i);

    void proxyFinalize();

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetSharedPreferences(String str, int i);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnDestroy();

    void proxyOnLowMemory();

    void proxyOnStart(Intent intent, int i);

    int proxyOnStartCommand(Intent intent, int i, int i2);

    boolean proxyOnUnbind(Intent intent);

    void proxyStartActivity(Intent intent);

    ComponentName proxyStartService(Intent intent);

    boolean proxyStopService(Intent intent);
}
