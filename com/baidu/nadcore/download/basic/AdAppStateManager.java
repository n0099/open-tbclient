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
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di0;
import com.repackage.ei0;
import com.repackage.ek0;
import com.repackage.gi0;
import com.repackage.hh0;
import com.repackage.ii0;
import com.repackage.ik0;
import com.repackage.lk0;
import com.repackage.qg0;
import com.repackage.si0;
import com.repackage.w01;
import com.repackage.zx0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdAppStateManager";
    public transient /* synthetic */ FieldHolder $fh;
    public si0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, si0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends ik0<lk0> {
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
        @Override // com.repackage.ik0
        public void onEvent(@NonNull lk0 lk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk0Var) == null) {
                this.b.mIsForeGround = lk0Var.a;
                if (!lk0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                String a = gi0.a(this.b.mBlockingNotifyData.d);
                if (a == null) {
                    boolean z = this.b.mBlockingNotifyData.q.r;
                    int i = this.b.mBlockingNotifyData.q.s;
                    if (z && this.b.isInternalValid(i)) {
                        AdAppStateManager adAppStateManager = this.b;
                        adAppStateManager.launchAfterInstall(adAppStateManager.mBlockingNotifyData);
                        return;
                    }
                    return;
                }
                qg0.b(a);
                gi0.c(this.b.mBlockingNotifyData.d);
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
            hh0.b().registerReceiver(this, intentFilter);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i > 0 && !w01.a(System.currentTimeMillis(), this.mBlockingTime, i) : invokeI.booleanValue;
    }

    private void launch(si0 si0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, si0Var) == null) {
            ei0.c(si0Var);
            this.mBlockingNotifyData = null;
        }
    }

    public void launchAfterInstall(si0 si0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, si0Var) == null) || si0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = si0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(si0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        si0 si0Var = (si0) zx0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (si0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            si0Var.c = AdDownloadStatus.INSTALLED;
            si0Var.q.p = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = hh0.b().getPackageManager().getPackageInfo(si0Var.d, 0);
                if (packageInfo != null) {
                    si0Var.o = packageInfo.versionName;
                    si0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            si0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            ei0.b().e(AdDownloadAction.INSTALL_FINISH, si0Var);
            si0Var.q.o = 0L;
            launchAfterInstall(si0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ei0.b().e(AdDownloadAction.REMOVE, si0Var);
            if (si0Var.q.p > 0) {
                di0.a().b(si0Var);
            }
            si0Var.q.o = -1L;
        }
        ii0.a().b();
    }

    public void register(@NonNull si0 si0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, si0Var) == null) || TextUtils.isEmpty(si0Var.d)) {
            return;
        }
        zx0.e(this.mDatas, si0Var.d, si0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ek0.a().b(new Object(), new a(this, lk0.class));
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
