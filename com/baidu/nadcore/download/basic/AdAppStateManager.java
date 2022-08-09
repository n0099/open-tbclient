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
import com.repackage.ai0;
import com.repackage.bk0;
import com.repackage.ci0;
import com.repackage.dh0;
import com.repackage.ei0;
import com.repackage.fk0;
import com.repackage.ik0;
import com.repackage.mg0;
import com.repackage.oi0;
import com.repackage.qj0;
import com.repackage.v01;
import com.repackage.yx0;
import com.repackage.zh0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdAppStateManager";
    public transient /* synthetic */ FieldHolder $fh;
    public oi0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, oi0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends fk0<ik0> {
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
        @Override // com.repackage.fk0
        public void onEvent(@NonNull ik0 ik0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik0Var) == null) {
                this.b.mIsForeGround = ik0Var.a;
                if (!ik0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                String a = ci0.a(this.b.mBlockingNotifyData.d);
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
                mg0.b(a);
                ci0.c(this.b.mBlockingNotifyData.d);
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
            dh0.b().registerReceiver(this, intentFilter);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i > 0 && !v01.a(System.currentTimeMillis(), this.mBlockingTime, i) : invokeI.booleanValue;
    }

    public void launch(oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oi0Var) == null) {
            this.mBlockingNotifyData = null;
            if (oi0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(oi0Var.d)) {
                String a2 = ci0.a(oi0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    mg0.b(a2);
                    ci0.c(oi0Var.d);
                    return;
                }
            }
            if ((TextUtils.isEmpty(oi0Var.p.c) || !mg0.b(oi0Var.p.c)) && oi0Var.q.t) {
                qj0.f(oi0Var.d);
                ai0.d(AdDownloadAction.OPEN, oi0Var);
            }
        }
    }

    public void launchAfterInstall(oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oi0Var) == null) || oi0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = oi0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(oi0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        oi0 oi0Var = (oi0) yx0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (oi0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            oi0Var.c = AdDownloadStatus.INSTALLED;
            oi0Var.q.p = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = dh0.b().getPackageManager().getPackageInfo(oi0Var.d, 0);
                if (packageInfo != null) {
                    oi0Var.o = packageInfo.versionName;
                    oi0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            oi0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            ai0.b().f(AdDownloadAction.INSTALL_FINISH, oi0Var);
            oi0Var.q.o = 0L;
            launchAfterInstall(oi0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            ai0.b().f(AdDownloadAction.REMOVE, oi0Var);
            if (oi0Var.q.p > 0) {
                zh0.a().b(oi0Var);
            }
            oi0Var.q.o = -1L;
        }
        ei0.a().b();
    }

    public void register(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oi0Var) == null) || TextUtils.isEmpty(oi0Var.d)) {
            return;
        }
        yx0.e(this.mDatas, oi0Var.d, oi0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bk0.a().b(new Object(), new a(this, ik0.class));
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
