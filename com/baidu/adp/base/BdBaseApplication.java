package com.baidu.adp.base;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.b;
import c.a.e.a.h;
import c.a.e.e.p.d;
import c.a.e.g.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.nps.NPSHookManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.initer.TitanIniter;
import com.baidu.titan.sdk.loader.LoaderManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class BdBaseApplication extends Application {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RESOURCE_LOAD_MAX_TRY_COUNT = 3;
    public static BdBaseApplication instance;
    public static BdBaseApplication sApp;
    public transient /* synthetic */ FieldHolder $fh;
    public long lastGcTime;
    public Handler mAppInitHandler;
    public Application mContext;
    public boolean mHasCheckedNewUserStatus;
    public boolean mIsDebugMode;
    public boolean mIsNewUser;
    public boolean mIsPluginResourceOpen;
    public boolean mIsSmallFlow;
    public long mSmallFlowInterval;
    public long mStartSmallFlowTime;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdBaseApplication f36229a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdBaseApplication bdBaseApplication, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdBaseApplication, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36229a = bdBaseApplication;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                this.f36229a.handleInitMessage(message);
            }
        }
    }

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsDebugMode = false;
        this.mContext = null;
        this.mIsPluginResourceOpen = true;
        this.lastGcTime = 0L;
        sApp = this;
    }

    public static BdBaseApplication getInst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sApp : (BdBaseApplication) invokeV.objValue;
    }

    private void initBdBaseApp(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, application) == null) {
            this.mContext = application;
            initWorkMode();
            initBitmapHelper();
        }
    }

    private void initBitmapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            d.d().f(this.mContext);
        }
    }

    private void initPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            c.a.e.h.i.a.d().e();
        }
    }

    private void initWorkMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if ((this.mContext.getApplicationInfo().flags & 2) == 0) {
                this.mIsDebugMode = false;
            } else {
                this.mIsDebugMode = true;
            }
        }
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
            NPSHookManager.init(this);
            c.d().h(this);
            TitanIniter.init(this);
            LoaderManager.getInstance().load();
        }
    }

    public boolean checkInLater30Min() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 21, 0, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 21, 30, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 21, 50, 0);
            long timeInMillis3 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 22, 20, 0);
            long timeInMillis4 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 20, 30, 0);
            long timeInMillis5 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 21, 0, 0);
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
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            return this.mIsNewUser;
        }
        return invokeV.booleanValue;
    }

    public int getActivityStackMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? b.f().d() : invokeV.intValue;
    }

    public Application getApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext : (Application) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AssetManager assets = getResources().getAssets();
            return assets != null ? assets : super.getAssets();
        }
        return (AssetManager) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public boolean getIsPluginResourcOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mIsPluginResourceOpen : invokeV.booleanValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Resources b2 = h.a().b();
            return (b2 == null || !this.mIsPluginResourceOpen) ? super.getResources() : b2;
        }
        return (Resources) invokeV.objValue;
    }

    public long getSmallFlowInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSmallFlowInterval : invokeV.longValue;
    }

    public long getStartSmallFlowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mStartSmallFlowTime : invokeV.longValue;
    }

    public void handleInitMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, message) == null) {
        }
    }

    public boolean isDebugMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsDebugMode : invokeV.booleanValue;
    }

    public boolean isSmallFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!this.mIsSmallFlow || (System.currentTimeMillis() - this.mStartSmallFlowTime) / 1000 <= this.mSmallFlowInterval) {
                return this.mIsSmallFlow;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onAppMemoryLow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b.f().q();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastGcTime > 30000) {
                this.lastGcTime = currentTimeMillis;
                System.gc();
            }
        }
    }

    public void onCreate(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, application) == null) {
            this.mAppInitHandler = new a(this, Looper.getMainLooper());
            h.a().d(super.getResources());
            initBdBaseApp(application);
            super.onCreate();
        }
    }

    public void setActivityStackMaxSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            b.f().r(i2);
        }
    }

    public void setDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.mIsDebugMode = z;
        }
    }

    public void setIsPluginResourceOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mIsPluginResourceOpen = true;
        }
    }

    public void setIsSmallFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsSmallFlow = z;
        }
    }

    public void setSmallFlowInterval(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j2) == null) {
            this.mSmallFlowInterval = j2;
        }
    }

    public void setStartSmallFlowTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            this.mStartSmallFlowTime = j2;
        }
    }

    private boolean checkInterrupt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 19, 20, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 21, 0, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 20, 10, 0);
            long timeInMillis3 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 21, 50, 0);
            long timeInMillis4 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 20, 0, 0);
            long timeInMillis5 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 20, 30, 0);
            return (timeInMillis <= j2 && j2 <= timeInMillis2) || (timeInMillis3 <= j2 && j2 <= timeInMillis4) || (timeInMillis5 <= j2 && j2 <= calendar.getTimeInMillis());
        }
        return invokeJ.booleanValue;
    }
}
