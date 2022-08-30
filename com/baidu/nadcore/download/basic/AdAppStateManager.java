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
import com.baidu.tieba.ai0;
import com.baidu.tieba.bi0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.di0;
import com.baidu.tieba.eh0;
import com.baidu.tieba.fi0;
import com.baidu.tieba.gk0;
import com.baidu.tieba.jk0;
import com.baidu.tieba.ng0;
import com.baidu.tieba.pi0;
import com.baidu.tieba.rj0;
import com.baidu.tieba.w01;
import com.baidu.tieba.zx0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class AdAppStateManager extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdAppStateManager";
    public transient /* synthetic */ FieldHolder $fh;
    public pi0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, pi0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends gk0<jk0> {
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
        @Override // com.baidu.tieba.gk0
        public void onEvent(@NonNull jk0 jk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jk0Var) == null) {
                this.b.mIsForeGround = jk0Var.a;
                if (!jk0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                String a = di0.a(this.b.mBlockingNotifyData.d);
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
                ng0.b(a);
                di0.c(this.b.mBlockingNotifyData.d);
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
            eh0.b().registerReceiver(this, intentFilter);
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

    public void launch(pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pi0Var) == null) {
            this.mBlockingNotifyData = null;
            if (pi0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(pi0Var.d)) {
                String a2 = di0.a(pi0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    ng0.b(a2);
                    di0.c(pi0Var.d);
                    return;
                }
            }
            if ((TextUtils.isEmpty(pi0Var.p.c) || !ng0.b(pi0Var.p.c)) && pi0Var.q.t) {
                rj0.f(pi0Var.d);
                bi0.d(AdDownloadAction.OPEN, pi0Var);
            }
        }
    }

    public void launchAfterInstall(pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pi0Var) == null) || pi0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = pi0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(pi0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        pi0 pi0Var = (pi0) zx0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (pi0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            pi0Var.c = AdDownloadStatus.INSTALLED;
            pi0Var.q.p = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = eh0.b().getPackageManager().getPackageInfo(pi0Var.d, 0);
                if (packageInfo != null) {
                    pi0Var.o = packageInfo.versionName;
                    pi0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            pi0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            bi0.b().f(AdDownloadAction.INSTALL_FINISH, pi0Var);
            pi0Var.q.o = 0L;
            launchAfterInstall(pi0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            bi0.b().f(AdDownloadAction.REMOVE, pi0Var);
            if (pi0Var.q.p > 0) {
                ai0.a().b(pi0Var);
            }
            pi0Var.q.o = -1L;
        }
        fi0.a().b();
    }

    public void register(@NonNull pi0 pi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pi0Var) == null) || TextUtils.isEmpty(pi0Var.d)) {
            return;
        }
        zx0.e(this.mDatas, pi0Var.d, pi0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ck0.a().b(new Object(), new a(this, jk0.class));
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
