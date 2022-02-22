package com.baidu.adp.plugin.pluginBase;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import c.a.d.j.f.c;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* loaded from: classes10.dex */
public abstract class PluginBaseService extends PluginContextWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int START_CONTINUATION_MASK = 15;
    public static final int START_FLAG_REDELIVERY = 1;
    public static final int START_FLAG_RETRY = 2;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_STICKY = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Service mService;
    public c mServiceProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginBaseService() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mService = null;
        this.mServiceProxy = null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, intent, serviceConnection, i2)) == null) ? this.mServiceProxy.proxyBindService(intent, serviceConnection, i2) : invokeLLI.booleanValue;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fileDescriptor, printWriter, strArr) == null) {
            this.mServiceProxy.proxyDump(fileDescriptor, printWriter, strArr);
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mServiceProxy.proxyFinalize();
            super.finalize();
        }
    }

    public final Application getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? PluginCenter.getInstance().getPlugin(getPluginPackageName()).getApplication() : (Application) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = c.a.d.j.j.f.c.j().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Service service = this.mService;
                return service.getFileStreamPath(pluginPackageName + str);
            }
            return this.mService.getFileStreamPath(str);
        }
        return (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mServiceProxy.proxyGetPackageManager() : (PackageManager) invokeV.objValue;
    }

    public Service getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mService : (Service) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = c.a.d.j.j.f.c.j().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                c cVar = this.mServiceProxy;
                return cVar.proxyGetSharedPreferences(pluginPackageName + str, i2);
            }
            return this.mServiceProxy.proxyGetSharedPreferences(str, i2);
        }
        return (SharedPreferences) invokeLI.objValue;
    }

    public abstract IBinder onBind(Intent intent);

    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, configuration) == null) {
            this.mServiceProxy.proxyOnConfigurationChanged(configuration);
        }
    }

    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mServiceProxy.proxyOnDestroy();
        }
    }

    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mServiceProxy.proxyOnLowMemory();
        }
    }

    public void onRebind(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, intent) == null) {
            this.mServiceProxy.proxyOnRebind(intent);
        }
    }

    public void onStart(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, intent, i2) == null) {
            this.mServiceProxy.proxyOnStart(intent, i2);
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, intent, i2, i3)) == null) ? this.mServiceProxy.proxyOnStartCommand(intent, i2, i3) : invokeLII.intValue;
    }

    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, intent)) == null) ? this.mServiceProxy.proxyOnUnbind(intent) : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = c.a.d.j.j.f.c.j().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Service service = this.mService;
                return service.openFileInput(pluginPackageName + str);
            }
            return this.mService.openFileInput(str);
        }
        return (FileInputStream) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i2) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, str, i2)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = c.a.d.j.j.f.c.j().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Service service = this.mService;
                return service.openFileOutput(pluginPackageName + str, i2);
            }
            return this.mService.openFileOutput(str, i2);
        }
        return (FileOutputStream) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048595, this, str, i2, cursorFactory)) == null) {
            String pluginPackageName = getPluginPackageName();
            PluginSetting h2 = c.a.d.j.j.f.c.j().h(pluginPackageName);
            if (h2 != null && h2.isThird) {
                Service service = this.mService;
                return service.openOrCreateDatabase(pluginPackageName + str, i2, cursorFactory);
            }
            return this.mService.openOrCreateDatabase(str, i2, cursorFactory);
        }
        return (SQLiteDatabase) invokeLIL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
            super.sendBroadcast(intent);
        }
    }

    public void setServiceProxy(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) {
            this.mService = cVar.getService();
            this.mServiceProxy = cVar;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, intent) == null) {
            if (intent != null) {
                intent.addFlags(268435456);
            }
            this.mServiceProxy.proxyStartActivity(intent);
        }
    }

    public final void startForeground(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, notification) == null) {
            this.mService.startForeground(i2, notification);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, intent)) == null) ? this.mServiceProxy.proxyStartService(intent) : (ComponentName) invokeL.objValue;
    }

    public final void stopSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mService.stopSelf();
        }
    }

    public final boolean stopSelfResult(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) ? this.mService.stopSelfResult(i2) : invokeI.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, intent)) == null) ? this.mServiceProxy.proxyStopService(intent) : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, intent, str) == null) {
            super.sendBroadcast(intent, str);
        }
    }

    public final void stopSelf(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.mService.stopSelf(i2);
        }
    }
}
