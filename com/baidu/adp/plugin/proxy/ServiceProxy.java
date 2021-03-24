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
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import d.b.b.h.f.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ServiceProxy extends Service implements c {
    public PluginBaseService mEntity = null;

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        if (intent != null) {
            loadTargetService(intent);
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.bindService(intent, serviceConnection, i);
            }
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.getPackageManager();
        }
        return super.getPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.getResources();
        }
        return super.getResources();
    }

    @Override // d.b.b.h.f.c
    public Service getService() {
        return this;
    }

    public void loadTargetService(Intent intent) {
        if (this.mEntity == null) {
            String stringExtra = intent.getStringExtra(Plugin.INTENT_EXTRA_PACKAGE_NAME);
            if (!PluginCenter.getInstance().isLoaded(stringExtra)) {
                super.stopSelf();
                BdLog.e("plugin not loaded. pluginname is " + stringExtra);
                return;
            }
            try {
                PluginBaseService pluginBaseService = (PluginBaseService) PluginCenter.getInstance().getPlugin(stringExtra).getDexClassLoader().loadClass(intent.getStringExtra(Plugin.INTENT_EXTRA_SERVICE)).asSubclass(PluginBaseService.class).newInstance();
                this.mEntity = pluginBaseService;
                pluginBaseService.setServiceProxy(this);
                this.mEntity.setPluginPackageName(stringExtra);
                this.mEntity.onCreate();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            stopSelf();
            return null;
        }
        loadTargetService(intent);
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            pluginBaseService.onConfigurationChanged(configuration);
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
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            pluginBaseService.onDestroy();
        } else {
            super.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            pluginBaseService.onLowMemory();
        } else {
            super.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent == null) {
            stopSelf();
            return;
        }
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            pluginBaseService.onStart(intent, i);
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
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.onStartCommand(intent, i, i2);
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.onUnbind(intent);
        }
        return super.onUnbind(intent);
    }

    @Override // d.b.b.h.f.c
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
        if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
            return super.bindService(intent, serviceConnection, i);
        }
        return false;
    }

    @Override // d.b.b.h.f.c
    public void proxyDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    @Override // d.b.b.h.f.c
    public void proxyFinalize() throws Throwable {
        super.finalize();
    }

    @Override // d.b.b.h.f.c
    public PackageManager proxyGetPackageManager() {
        return super.getPackageManager();
    }

    @Override // d.b.b.h.f.c
    public SharedPreferences proxyGetSharedPreferences(String str, int i) {
        return super.getSharedPreferences(str, i);
    }

    @Override // d.b.b.h.f.c
    public void proxyOnConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // d.b.b.h.f.c
    public void proxyOnDestroy() {
        super.onDestroy();
    }

    @Override // d.b.b.h.f.c
    public void proxyOnLowMemory() {
        super.onLowMemory();
    }

    @Override // d.b.b.h.f.c
    public void proxyOnRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // d.b.b.h.f.c
    public void proxyOnStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // d.b.b.h.f.c
    public int proxyOnStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // d.b.b.h.f.c
    public boolean proxyOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override // d.b.b.h.f.c
    public void proxyStartActivity(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
        if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
            if (intent != null) {
                intent.addFlags(268435456);
            }
            super.startActivity(intent);
        }
    }

    @Override // d.b.b.h.f.c
    public ComponentName proxyStartService(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
        if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
            return super.startService(intent);
        }
        return null;
    }

    @Override // d.b.b.h.f.c
    public boolean proxyStopService(Intent intent) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
        if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
            return super.stopService(intent);
        }
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.addFlags(268435456);
        }
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            pluginBaseService.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.startService(intent);
        }
        return super.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        PluginBaseService pluginBaseService = this.mEntity;
        if (pluginBaseService != null) {
            return pluginBaseService.stopService(intent);
        }
        return super.stopService(intent);
    }
}
