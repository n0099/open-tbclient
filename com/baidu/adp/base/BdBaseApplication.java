package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n9;
import com.baidu.tieba.t9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class BdBaseApplication extends Application {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    public static BdBaseApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastGcTime;
    public Context mContext;
    public boolean mHasCheckedNewUserStatus;
    public boolean mIsDebugMode;
    public boolean mIsNewUser;
    public boolean mIsPluginResourceOpen;
    public boolean mIsSmallFlow;
    public ConcurrentHashMap mResHashMap;
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
        this.mResHashMap = new ConcurrentHashMap();
        this.lastGcTime = 0L;
        sApp = this;
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
            long timeInMillis6 = calendar.getTimeInMillis();
            if ((timeInMillis <= j && j <= timeInMillis2) || ((timeInMillis3 <= j && j <= timeInMillis4) || (timeInMillis5 <= j && j <= timeInMillis6))) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public static BdBaseApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sApp;
        }
        return (BdBaseApplication) invokeV.objValue;
    }

    public boolean checkInterrupt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return checkInterrupt(System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public Application getApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (Application) this.mContext.getApplicationContext();
        }
        return (Application) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AssetManager assets = getResources().getAssets();
            if (assets != null) {
                return assets;
            }
            return super.getAssets();
        }
        return (AssetManager) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public boolean getIsPluginResourcOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mIsPluginResourceOpen;
        }
        return invokeV.booleanValue;
    }

    public ConcurrentHashMap getResHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mResHashMap;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Resources resources = t9.a().getResources();
            if (resources != null && this.mIsPluginResourceOpen) {
                return resources;
            }
            return super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIsDebugMode;
        }
        return invokeV.booleanValue;
    }

    public boolean isSmallFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mIsSmallFlow && (System.currentTimeMillis() - this.mStartSmallFlowTime) / 1000 > this.mSmallFlowInterval) {
                return false;
            }
            return this.mIsSmallFlow;
        }
        return invokeV.booleanValue;
    }

    public void onAppMemoryLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            n9.g().q();
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    public void setIsSmallFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mIsSmallFlow = z;
        }
    }

    public void setSmallFlowInterval(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.mSmallFlowInterval = j;
        }
    }

    public void setStartSmallFlowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.mStartSmallFlowTime = j;
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
            if ((timeInMillis <= currentTimeMillis && currentTimeMillis <= timeInMillis2) || ((timeInMillis3 <= currentTimeMillis && currentTimeMillis <= timeInMillis4) || (timeInMillis5 <= currentTimeMillis && currentTimeMillis <= timeInMillis6))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
