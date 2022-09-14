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
import com.baidu.tieba.cl0;
import com.baidu.tieba.kj0;
import com.baidu.tieba.lj0;
import com.baidu.tieba.lz0;
import com.baidu.tieba.mi0;
import com.baidu.tieba.n21;
import com.baidu.tieba.nj0;
import com.baidu.tieba.ol0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.vl0;
import com.baidu.tieba.yj0;
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
    public yj0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, yj0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends sl0<vl0> {
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
        @Override // com.baidu.tieba.sl0
        public void onEvent(@NonNull vl0 vl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vl0Var) == null) {
                this.b.mIsForeGround = vl0Var.a;
                if (!vl0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                String a = nj0.a(this.b.mBlockingNotifyData.d);
                if (a == null) {
                    boolean z = this.b.mBlockingNotifyData.q.s;
                    int i = this.b.mBlockingNotifyData.q.t;
                    if (z && this.b.isInternalValid(i)) {
                        AdAppStateManager adAppStateManager = this.b;
                        adAppStateManager.launchAfterInstall(adAppStateManager.mBlockingNotifyData);
                        return;
                    }
                    return;
                }
                vh0.b(a);
                nj0.c(this.b.mBlockingNotifyData.d);
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
            mi0.b().registerReceiver(this, intentFilter);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i > 0 && !n21.a(System.currentTimeMillis(), this.mBlockingTime, i) : invokeI.booleanValue;
    }

    public void launch(yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yj0Var) == null) {
            this.mBlockingNotifyData = null;
            if (yj0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(yj0Var.d)) {
                String a2 = nj0.a(yj0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    vh0.b(a2);
                    nj0.c(yj0Var.d);
                    return;
                }
            }
            if ((TextUtils.isEmpty(yj0Var.p.c) || !vh0.b(yj0Var.p.c)) && yj0Var.q.u) {
                cl0.f(yj0Var.d);
                lj0.d(AdDownloadAction.OPEN, yj0Var);
            }
        }
    }

    public void launchAfterInstall(yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yj0Var) == null) || yj0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = yj0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(yj0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        yj0 yj0Var = (yj0) lz0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (yj0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            yj0Var.c = AdDownloadStatus.INSTALLED;
            yj0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = mi0.b().getPackageManager().getPackageInfo(yj0Var.d, 0);
                if (packageInfo != null) {
                    yj0Var.o = packageInfo.versionName;
                    yj0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            yj0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            lj0.b().f(AdDownloadAction.INSTALL_FINISH, yj0Var);
            yj0Var.q.p = 0L;
            launchAfterInstall(yj0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            lj0.b().f(AdDownloadAction.REMOVE, yj0Var);
            if (yj0Var.q.q > 0) {
                kj0.a().b(yj0Var);
            }
            yj0Var.q.p = -1L;
        }
        pj0.b().d();
    }

    public void register(@NonNull yj0 yj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, yj0Var) == null) || TextUtils.isEmpty(yj0Var.d)) {
            return;
        }
        lz0.e(this.mDatas, yj0Var.d, yj0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ol0.a().b(new Object(), new a(this, vl0.class));
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
