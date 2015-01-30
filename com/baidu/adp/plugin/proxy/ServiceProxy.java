package com.baidu.adp.plugin.proxy;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.a.b;
import com.baidu.adp.plugin.pluginBase.g;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ServiceProxy extends Service implements b {
    private g mEntity = null;

    public void loadTargetService(Intent intent) {
        if (this.mEntity != null) {
            String stringExtra = intent.getStringExtra("intent_extra_package_name");
            if (!PluginCenter.gW().aR(stringExtra)) {
                super.stopSelf();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                this.mEntity = (g) PluginCenter.gW().aS(stringExtra).gL().loadClass(intent.getStringExtra("intent_extra_service")).asSubclass(g.class).newInstance();
                this.mEntity.a(this);
                this.mEntity.setPluginPackageName(stringExtra);
                this.mEntity.onCreate();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (intent != null) {
            loadTargetService(intent);
            if (this.mEntity != null) {
                return this.mEntity.bindService(intent, serviceConnection, i);
            }
            return false;
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        return this.mEntity != null ? this.mEntity.getPackageManager() : super.getPackageManager();
    }

    @Override // com.baidu.adp.plugin.a.b
    public Service getService() {
        return this;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mEntity != null) {
            return this.mEntity.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.mEntity != null) {
            this.mEntity.onConfigurationChanged(configuration);
        } else {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.mEntity != null) {
            this.mEntity.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        if (this.mEntity != null) {
            this.mEntity.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent == null) {
            stopSelf();
        } else if (this.mEntity != null) {
            this.mEntity.onStart(intent, i);
        } else {
            super.onStart(intent, i);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
        loadTargetService(intent);
        if (this.mEntity != null) {
            return this.mEntity.onStartCommand(intent, i, i2);
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.mEntity != null ? this.mEntity.onUnbind(intent) : super.onUnbind(intent);
    }

    @Override // com.baidu.adp.plugin.a.b
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i) {
        com.baidu.adp.plugin.b aS = PluginCenter.gW().aS(this.mEntity.getPackageName());
        if (aS != null && aS.C(intent)) {
            return super.bindService(intent, serviceConnection, i);
        }
        return false;
    }

    public void proxyDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyFinalize() {
        super.finalize();
    }

    @Override // com.baidu.adp.plugin.a.b
    public PackageManager proxyGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyOnDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    public void proxyOnRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyOnStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // com.baidu.adp.plugin.a.b
    public int proxyOnStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.baidu.adp.plugin.a.b
    public boolean proxyOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // com.baidu.adp.plugin.a.b
    public void proxyStartActivity(Intent intent) {
        com.baidu.adp.plugin.b aS = PluginCenter.gW().aS(this.mEntity.getPackageName());
        if (aS != null && aS.D(intent)) {
            super.startActivity(intent);
        }
    }

    @Override // com.baidu.adp.plugin.a.b
    public ComponentName proxyStartService(Intent intent) {
        com.baidu.adp.plugin.b aS = PluginCenter.gW().aS(this.mEntity.getPackageName());
        if (aS != null && aS.D(intent)) {
            return super.startService(intent);
        }
        return null;
    }

    @Override // com.baidu.adp.plugin.a.b
    public boolean proxyStopService(Intent intent) {
        com.baidu.adp.plugin.b aS = PluginCenter.gW().aS(this.mEntity.getPackageName());
        if (aS != null && aS.D(intent)) {
            return super.stopService(intent);
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (this.mEntity != null) {
            this.mEntity.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mEntity != null ? this.mEntity.startService(intent) : super.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return this.mEntity != null ? this.mEntity.stopService(intent) : super.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mEntity != null ? this.mEntity.getResources() : super.getResources();
    }

    @Override // com.baidu.adp.plugin.a.b
    public SharedPreferences proxyGetSharedPreferences(String str, int i) {
        return super.getSharedPreferences(str, i);
    }
}
