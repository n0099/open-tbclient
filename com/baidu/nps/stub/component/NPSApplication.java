package com.baidu.nps.stub.component;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.main.manager.NPSManager;
import com.baidu.nps.runtime.resources.ResourcesHookUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public class NPSApplication extends Application {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutInflater mInflater;
    public Application mOriginalApplication;
    public String mPackageName;

    public NPSApplication(Application application, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOriginalApplication = application;
        this.mPackageName = str;
        attachBaseContext(application.getBaseContext());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public boolean bindIsolatedService(Intent intent, int i, String str, Executor executor, ServiceConnection serviceConnection) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{intent, Integer.valueOf(i), str, executor, serviceConnection})) == null) ? this.mOriginalApplication.bindIsolatedService(intent, i, str, executor, serviceConnection) : invokeCommon.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, intent, serviceConnection, i)) == null) ? this.mOriginalApplication.bindService(intent, serviceConnection, i) : invokeLLI.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mOriginalApplication.checkCallingOrSelfPermission(str) : invokeL.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, uri, i)) == null) ? this.mOriginalApplication.checkCallingOrSelfUriPermission(uri, i) : invokeLI.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.mOriginalApplication.checkCallingPermission(str) : invokeL.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingUriPermission(Uri uri, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, uri, i)) == null) ? this.mOriginalApplication.checkCallingUriPermission(uri, i) : invokeLI.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkPermission(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, str, i, i2)) == null) ? this.mOriginalApplication.checkPermission(str, i, i2) : invokeLII.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(23)
    public int checkSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.mOriginalApplication.checkSelfPermission(str) : invokeL.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048585, this, uri, i, i2, i3)) == null) ? this.mOriginalApplication.checkUriPermission(uri, i, i2, i3) : invokeLIII.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void clearWallpaper() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mOriginalApplication.clearWallpaper();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, configuration)) == null) ? this.mOriginalApplication.createConfigurationContext(configuration) : (Context) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Context createContextForSplit(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? this.mOriginalApplication.createContextForSplit(str) : (Context) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public Context createDeviceProtectedStorageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mOriginalApplication.createDeviceProtectedStorageContext() : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createDisplayContext(Display display) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, display)) == null) ? this.mOriginalApplication.createDisplayContext(display) : (Context) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String str, int i) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, str, i)) == null) ? this.mOriginalApplication.createPackageContext(str, i) : (Context) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mOriginalApplication.databaseList() : (String[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? this.mOriginalApplication.deleteDatabase(str) : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) ? this.mOriginalApplication.deleteFile(str) : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            this.mOriginalApplication.enforceCallingOrSelfPermission(str, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048597, this, uri, i, str) == null) {
            this.mOriginalApplication.enforceCallingOrSelfUriPermission(uri, i, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            this.mOriginalApplication.enforceCallingPermission(str, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, uri, i, str) == null) {
            this.mOriginalApplication.enforceCallingUriPermission(uri, i, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforcePermission(String str, int i, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2}) == null) {
            this.mOriginalApplication.enforcePermission(str, i, i2, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            this.mOriginalApplication.enforceUriPermission(uri, i, i2, i3, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mOriginalApplication.fileList() : (String[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mOriginalApplication.getApplicationContext() : (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mOriginalApplication.getApplicationInfo() : (ApplicationInfo) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? getResources().getAssets() : (AssetManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ResourcesHookUtil.ensureResourcesReadyForNPS(this.mOriginalApplication.getBaseContext().getResources());
            return this.mOriginalApplication.getBaseContext();
        }
        return (Context) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mOriginalApplication.getCacheDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? NPSManager.getInstance().getBundle(this.mPackageName).getClassloader() : (ClassLoader) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File getCodeCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mOriginalApplication.getCodeCacheDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mOriginalApplication.getContentResolver() : (ContentResolver) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public File getDataDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mOriginalApplication.getDataDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) ? this.mOriginalApplication.getDatabasePath(str) : (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048614, this, str, i)) == null) ? this.mOriginalApplication.getDir(str, i) : (File) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mOriginalApplication.getExternalCacheDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mOriginalApplication.getExternalCacheDirs() : (File[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) ? this.mOriginalApplication.getExternalFilesDir(str) : (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, str)) == null) ? this.mOriginalApplication.getExternalFilesDirs(str) : (File[]) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File[] getExternalMediaDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mOriginalApplication.getExternalMediaDirs() : (File[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) ? this.mOriginalApplication.getFileStreamPath(str) : (File) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mOriginalApplication.getFilesDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(28)
    public Executor getMainExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mOriginalApplication.getMainExecutor() : (Executor) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.mOriginalApplication.getMainLooper() : (Looper) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(21)
    public File getNoBackupFilesDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mOriginalApplication.getNoBackupFilesDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mOriginalApplication.getObbDir() : (File) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mOriginalApplication.getObbDirs() : (File[]) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public String getOpPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mOriginalApplication.getOpPackageName() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mOriginalApplication.getPackageCodePath() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mOriginalApplication.getPackageManager() : (PackageManager) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mOriginalApplication.getPackageName() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mOriginalApplication.getPackageResourcePath() : (String) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? NPSManager.getInstance().getBundle(this.mPackageName).getResources(this.mOriginalApplication.getResources()) : (Resources) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048633, this, str, i)) == null) ? this.mOriginalApplication.getSharedPreferences(str, i) : (SharedPreferences) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if ("layout_inflater".equals(str)) {
                if (this.mInflater == null) {
                    this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
                }
                return this.mInflater;
            }
            return this.mOriginalApplication.getSystemService(str);
        }
        return invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(23)
    public String getSystemServiceName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, cls)) == null) ? this.mOriginalApplication.getSystemServiceName(cls) : (String) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            ResourcesHookUtil.ensureResourcesReadyForNPS(this.mOriginalApplication.getBaseContext().getResources());
            return this.mOriginalApplication.getTheme();
        }
        return (Resources.Theme) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable getWallpaper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mOriginalApplication.getWallpaper() : (Drawable) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mOriginalApplication.getWallpaperDesiredMinimumHeight() : invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mOriginalApplication.getWallpaperDesiredMinimumWidth() : invokeV.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void grantUriPermission(String str, Uri uri, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048640, this, str, uri, i) == null) {
            this.mOriginalApplication.grantUriPermission(str, uri, i);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public boolean isDeviceProtectedStorage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mOriginalApplication.isDeviceProtectedStorage() : invokeV.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean isRestricted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mOriginalApplication.isRestricted() : invokeV.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(24)
    public boolean moveDatabaseFrom(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048643, this, context, str)) == null) ? this.mOriginalApplication.moveDatabaseFrom(context, str) : invokeLL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) ? this.mOriginalApplication.openFileInput(str) : (FileInputStream) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048645, this, str, i)) == null) ? this.mOriginalApplication.openFileOutput(str, i) : (FileOutputStream) invokeLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048646, this, str, i, cursorFactory)) == null) ? this.mOriginalApplication.openOrCreateDatabase(str, i, cursorFactory) : (SQLiteDatabase) invokeLIL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable peekWallpaper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mOriginalApplication.peekWallpaper() : (Drawable) invokeV.objValue;
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, activityLifecycleCallbacks) == null) {
            this.mOriginalApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, componentCallbacks) == null) {
            this.mOriginalApplication.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, onProvideAssistDataListener) == null) {
            this.mOriginalApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048652, this, broadcastReceiver, intentFilter)) == null) ? this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter) : (Intent) invokeLL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void revokeUriPermission(Uri uri, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048656, this, uri, i) == null) {
            this.mOriginalApplication.revokeUriPermission(uri, i);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, intent) == null) {
            this.mOriginalApplication.sendBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, intent, str) == null) {
            this.mOriginalApplication.sendOrderedBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.mOriginalApplication.setTheme(i);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, bitmap) == null) {
            this.mOriginalApplication.setWallpaper(bitmap);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, intentArr) == null) {
            this.mOriginalApplication.startActivities(intentArr);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, intent) == null) {
            this.mOriginalApplication.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public ComponentName startForegroundService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048669, this, intent)) == null) ? this.mOriginalApplication.startForegroundService(intent) : (ComponentName) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048670, this, componentName, str, bundle)) == null) ? this.mOriginalApplication.startInstrumentation(componentName, str, bundle) : invokeLLL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            this.mOriginalApplication.startIntentSender(intentSender, intent, i, i2, i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, intent)) == null) ? this.mOriginalApplication.startService(intent) : (ComponentName) invokeL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, intent)) == null) ? this.mOriginalApplication.stopService(intent) : invokeL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, serviceConnection) == null) {
            this.mOriginalApplication.unbindService(serviceConnection);
        }
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, activityLifecycleCallbacks) == null) {
            this.mOriginalApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, componentCallbacks) == null) {
            this.mOriginalApplication.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, onProvideAssistDataListener) == null) {
            this.mOriginalApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, broadcastReceiver) == null) {
            this.mOriginalApplication.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public void updateServiceGroup(ServiceConnection serviceConnection, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048680, this, serviceConnection, i, i2) == null) {
            this.mOriginalApplication.updateServiceGroup(serviceConnection, i, i2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(29)
    public boolean bindService(Intent intent, int i, Executor executor, ServiceConnection serviceConnection) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i, executor, serviceConnection)) == null) ? this.mOriginalApplication.bindService(intent, i, executor, serviceConnection) : invokeLILL.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{uri, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) ? this.mOriginalApplication.checkUriPermission(uri, str, str2, i, i2, i3) : invokeCommon.intValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{uri, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) {
            this.mOriginalApplication.enforceUriPermission(uri, str, str2, i, i2, i3, str3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048647, this, str, i, cursorFactory, databaseErrorHandler)) == null) ? this.mOriginalApplication.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler) : (SQLiteDatabase) invokeLILL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048653, this, broadcastReceiver, intentFilter, i)) == null) ? this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, i) : (Intent) invokeLLI.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public void revokeUriPermission(String str, Uri uri, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048657, this, str, uri, i) == null) {
            this.mOriginalApplication.revokeUriPermission(str, uri, i);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048659, this, intent, str) == null) {
            this.mOriginalApplication.sendBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{intent, str, broadcastReceiver, handler, Integer.valueOf(i), str2, bundle}) == null) {
            this.mOriginalApplication.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i, str2, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, inputStream) == null) {
            this.mOriginalApplication.setWallpaper(inputStream);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048666, this, intentArr, bundle) == null) {
            this.mOriginalApplication.startActivities(intentArr, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, intent, bundle) == null) {
            this.mOriginalApplication.startActivity(intent, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048654, this, broadcastReceiver, intentFilter, str, handler)) == null) ? this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, str, handler) : (Intent) invokeLLLL.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048672, this, new Object[]{intentSender, intent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            this.mOriginalApplication.startIntentSender(intentSender, intent, i, i2, i3, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    @TargetApi(26)
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{broadcastReceiver, intentFilter, str, handler, Integer.valueOf(i)})) == null) ? this.mOriginalApplication.registerReceiver(broadcastReceiver, intentFilter, str, handler, i) : (Intent) invokeCommon.objValue;
    }
}
