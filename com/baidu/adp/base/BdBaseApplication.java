package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f9;
import com.repackage.z8;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class BdBaseApplication extends Application {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    public static BdBaseApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastGcTime;
    public Handler mAppInitHandler;
    public Context mContext;
    public boolean mHasCheckedNewUserStatus;
    public boolean mIsDebugMode;
    public boolean mIsNewUser;
    public boolean mIsPluginResourceOpen;
    public boolean mIsSmallFlow;
    public ConcurrentHashMap<String, String> mResHashMap;
    public long mSmallFlowInterval;
    public long mStartSmallFlowTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1948514388, "Lcom/baidu/adp/base/BdBaseApplication;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1948514388, "Lcom/baidu/adp/base/BdBaseApplication;");
        }
    }

    public BdBaseApplication() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsDebugMode = false;
        this.mContext = null;
        this.mIsPluginResourceOpen = true;
        this.mResHashMap = new ConcurrentHashMap<>();
        this.lastGcTime = 0L;
        sApp = this;
    }

    public static BdBaseApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sApp : (BdBaseApplication) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public boolean checkInLater30Min() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, 5, 7, 21, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(2019, 5, 7, 21, 30, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            calendar.set(2019, 5, 15, 21, 50, 0);
            long timeInMillis3 = calendar.getTimeInMillis();
            calendar.set(2019, 5, 15, 22, 20, 0);
            long timeInMillis4 = calendar.getTimeInMillis();
            calendar.set(2019, 4, 27, 20, 30, 0);
            long timeInMillis5 = calendar.getTimeInMillis();
            calendar.set(2019, 4, 27, 21, 0, 0);
            long timeInMillis6 = calendar.getTimeInMillis();
            long currentTimeMillis = System.currentTimeMillis();
            return (timeInMillis <= currentTimeMillis && currentTimeMillis <= timeInMillis2) || (timeInMillis3 <= currentTimeMillis && currentTimeMillis <= timeInMillis4) || (timeInMillis5 <= currentTimeMillis && currentTimeMillis <= timeInMillis6);
        }
        return invokeV.booleanValue;
    }

    public boolean checkInterrupt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? checkInterrupt(System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public boolean checkNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mHasCheckedNewUserStatus) {
                return this.mIsNewUser;
            }
            try {
                this.mIsNewUser = checkInterrupt(getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0).firstInstallTime);
                this.mHasCheckedNewUserStatus = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return this.mIsNewUser;
        }
        return invokeV.booleanValue;
    }

    public Application getApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (Application) this.mContext.getApplicationContext() : (Application) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AssetManager assets = getResources().getAssets();
            return assets != null ? assets : super.getAssets();
        }
        return (AssetManager) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public boolean getIsPluginResourcOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsPluginResourceOpen : invokeV.booleanValue;
    }

    public ConcurrentHashMap<String, String> getResHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mResHashMap : (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Resources resources = f9.a().getResources();
            return (resources == null || !this.mIsPluginResourceOpen) ? super.getResources() : resources;
        }
        return (Resources) invokeV.objValue;
    }

    public void handleInitMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, message) == null) {
        }
    }

    public boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIsDebugMode : invokeV.booleanValue;
    }

    public boolean isSmallFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!this.mIsSmallFlow || (System.currentTimeMillis() - this.mStartSmallFlowTime) / 1000 <= this.mSmallFlowInterval) {
                return this.mIsSmallFlow;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onAppMemoryLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            z8.g().q();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastGcTime > 30000) {
                this.lastGcTime = currentTimeMillis;
                System.gc();
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onCreate();
        }
    }

    public void setIsSmallFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mIsSmallFlow = z;
        }
    }

    public void setSmallFlowInterval(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.mSmallFlowInterval = j;
        }
    }

    public void setStartSmallFlowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.mStartSmallFlowTime = j;
        }
    }

    private boolean checkInterrupt(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2019, 5, 7, 19, 20, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(2019, 5, 7, 21, 0, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            calendar.set(2019, 5, 15, 20, 10, 0);
            long timeInMillis3 = calendar.getTimeInMillis();
            calendar.set(2019, 5, 15, 21, 50, 0);
            long timeInMillis4 = calendar.getTimeInMillis();
            calendar.set(2019, 4, 27, 20, 0, 0);
            long timeInMillis5 = calendar.getTimeInMillis();
            calendar.set(2019, 4, 27, 20, 30, 0);
            return (timeInMillis <= j && j <= timeInMillis2) || (timeInMillis3 <= j && j <= timeInMillis4) || (timeInMillis5 <= j && j <= calendar.getTimeInMillis());
        }
        return invokeJ.booleanValue;
    }
}
