package com.baidu.nadcore.download.basic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.al0;
import com.repackage.dj0;
import com.repackage.ej0;
import com.repackage.el0;
import com.repackage.hj0;
import com.repackage.hl0;
import com.repackage.ki0;
import com.repackage.r11;
import com.repackage.rj0;
import com.repackage.vy0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdAppStateManager";
    public transient /* synthetic */ FieldHolder $fh;
    public rj0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, rj0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends el0<hl0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdAppStateManager b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdAppStateManager adAppStateManager, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adAppStateManager, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adAppStateManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.el0
        public void onEvent(@NonNull hl0 hl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hl0Var) == null) {
                this.b.mIsForeGround = hl0Var.a;
                if (!hl0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                boolean z = this.b.mBlockingNotifyData.q.p;
                int i = this.b.mBlockingNotifyData.q.q;
                if (z && this.b.isInternalValid(i)) {
                    AdAppStateManager adAppStateManager = this.b;
                    adAppStateManager.launchAfterInstall(adAppStateManager.mBlockingNotifyData);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final AdAppStateManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1342808034, "Lcom/baidu/nadcore/download/basic/AdAppStateManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1342808034, "Lcom/baidu/nadcore/download/basic/AdAppStateManager$b;");
                    return;
                }
            }
            a = new AdAppStateManager(null);
        }
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addDataScheme("package");
            ki0.b().registerReceiver(this, intentFilter);
            registerBackForegroundEvent();
        }
    }

    public static AdAppStateManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b.a : (AdAppStateManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i > 0 && !r11.a(System.currentTimeMillis(), this.mBlockingTime, i) : invokeI.booleanValue;
    }

    private void launch(rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, rj0Var) == null) {
            ej0.c(rj0Var);
            this.mBlockingNotifyData = null;
        }
    }

    public void launchAfterInstall(rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rj0Var) == null) || rj0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = rj0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(rj0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        rj0 rj0Var = (rj0) vy0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (rj0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            rj0Var.c = AdDownloadStatus.INSTALLED;
            rj0Var.q.o = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = ki0.b().getPackageManager().getPackageInfo(rj0Var.d, 0);
                if (packageInfo != null) {
                    rj0Var.o = packageInfo.versionName;
                    rj0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ej0.b().e(AdDownloadAction.INSTALL_FINISH, rj0Var);
            rj0Var.q.n = 0L;
            launchAfterInstall(rj0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ej0.b().e(AdDownloadAction.REMOVE, rj0Var);
            if (rj0Var.q.o > 0) {
                dj0.a().b(rj0Var);
            }
            rj0Var.q.n = -1L;
        }
        hj0.a().b();
    }

    public void register(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj0Var) == null) || TextUtils.isEmpty(rj0Var.d)) {
            return;
        }
        vy0.e(this.mDatas, rj0Var.d, rj0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            al0.a().b(new Object(), new a(this, hl0.class));
        }
    }

    public AdAppStateManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDatas = new HashMap<>(16);
        this.mBlockingNotifyData = null;
        this.mIsForeGround = true;
        init();
    }
}
