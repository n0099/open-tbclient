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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.h.f.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class ServiceProxy extends Service implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginBaseService mEntity;

    public ServiceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEntity = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, intent, serviceConnection, i2)) == null) {
            if (intent != null) {
                loadTargetService(intent);
                PluginBaseService pluginBaseService = this.mEntity;
                if (pluginBaseService != null) {
                    return pluginBaseService.bindService(intent, serviceConnection, i2);
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.getPackageManager();
            }
            return super.getPackageManager();
        }
        return (PackageManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.getResources();
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    @Override // d.a.c.h.f.c
    public Service getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (Service) invokeV.objValue;
    }

    public void loadTargetService(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, intent) == null) && this.mEntity == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
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
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                pluginBaseService.onConfigurationChanged(configuration);
            } else {
                super.onConfigurationChanged(configuration);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                pluginBaseService.onDestroy();
            } else {
                super.onDestroy();
            }
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                pluginBaseService.onLowMemory();
            } else {
                super.onLowMemory();
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, intent, i2) == null) {
            if (intent == null) {
                stopSelf();
                return;
            }
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                pluginBaseService.onStart(intent, i2);
            } else {
                super.onStart(intent, i2);
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, intent, i2, i3)) == null) {
            if (intent == null) {
                stopSelf();
                return super.onStartCommand(intent, i2, i3);
            }
            loadTargetService(intent);
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.onStartCommand(intent, i2, i3);
            }
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, intent)) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.onUnbind(intent);
            }
            return super.onUnbind(intent);
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.c.h.f.c
    public boolean proxyBindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, intent, serviceConnection, i2)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
            if (plugin2 != null && plugin2.remapStartServiceIntent(intent)) {
                return super.bindService(intent, serviceConnection, i2);
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // d.a.c.h.f.c
    public void proxyDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, fileDescriptor, printWriter, strArr) == null) {
            super.dump(fileDescriptor, printWriter, strArr);
        }
    }

    @Override // d.a.c.h.f.c
    public void proxyFinalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.finalize();
        }
    }

    @Override // d.a.c.h.f.c
    public PackageManager proxyGetPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? super.getPackageManager() : (PackageManager) invokeV.objValue;
    }

    @Override // d.a.c.h.f.c
    public SharedPreferences proxyGetSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) ? super.getSharedPreferences(str, i2) : (SharedPreferences) invokeLI.objValue;
    }

    @Override // d.a.c.h.f.c
    public void proxyOnConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // d.a.c.h.f.c
    public void proxyOnDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
        }
    }

    @Override // d.a.c.h.f.c
    public void proxyOnLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLowMemory();
        }
    }

    @Override // d.a.c.h.f.c
    public void proxyOnRebind(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            super.onRebind(intent);
        }
    }

    @Override // d.a.c.h.f.c
    public void proxyOnStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, intent, i2) == null) {
            super.onStart(intent, i2);
        }
    }

    @Override // d.a.c.h.f.c
    public int proxyOnStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048599, this, intent, i2, i3)) == null) ? super.onStartCommand(intent, i2, i3) : invokeLII.intValue;
    }

    @Override // d.a.c.h.f.c
    public boolean proxyOnUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, intent)) == null) ? super.onUnbind(intent) : invokeL.booleanValue;
    }

    @Override // d.a.c.h.f.c
    public void proxyStartActivity(Intent intent) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, intent) == null) && (plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName())) != null && plugin2.remapStartActivityIntent(intent)) {
            if (intent != null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            super.startActivity(intent);
        }
    }

    @Override // d.a.c.h.f.c
    public ComponentName proxyStartService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, intent)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
            if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
                return super.startService(intent);
            }
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // d.a.c.h.f.c
    public boolean proxyStopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, intent)) == null) {
            Plugin plugin2 = PluginCenter.getInstance().getPlugin(this.mEntity.getPackageName());
            if (plugin2 != null && plugin2.remapStartActivityIntent(intent)) {
                return super.stopService(intent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, intent) == null) {
            if (intent != null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                pluginBaseService.startActivity(intent);
            } else {
                super.startActivity(intent);
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, intent)) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.startService(intent);
            }
            return super.startService(intent);
        }
        return (ComponentName) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, intent)) == null) {
            PluginBaseService pluginBaseService = this.mEntity;
            if (pluginBaseService != null) {
                return pluginBaseService.stopService(intent);
            }
            return super.stopService(intent);
        }
        return invokeL.booleanValue;
    }
}
