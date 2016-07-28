package com.baidu.adp.plugin.a;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public interface c {
    Service getService();

    boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i);

    void proxyDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void proxyFinalize() throws Throwable;

    PackageManager proxyGetPackageManager();

    SharedPreferences proxyGetSharedPreferences(String str, int i);

    void proxyOnConfigurationChanged(Configuration configuration);

    void proxyOnDestroy();

    void proxyOnLowMemory();

    void proxyOnRebind(Intent intent);

    void proxyOnStart(Intent intent, int i);

    int proxyOnStartCommand(Intent intent, int i, int i2);

    boolean proxyOnUnbind(Intent intent);

    void proxyStartActivity(Intent intent);

    ComponentName proxyStartService(Intent intent);

    boolean proxyStopService(Intent intent);
}
