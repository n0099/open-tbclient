package com.baidu.nadcore.download.basic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.aj0;
import com.baidu.tieba.b31;
import com.baidu.tieba.bk0;
import com.baidu.tieba.cm0;
import com.baidu.tieba.dk0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.ji0;
import com.baidu.tieba.jm0;
import com.baidu.tieba.mk0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.yj0;
import com.baidu.tieba.zj0;
import com.baidu.tieba.zz0;
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
    public mk0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends gm0 {
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
        @Override // com.baidu.tieba.gm0
        public void onEvent(jm0 jm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jm0Var) == null) {
                this.b.mIsForeGround = jm0Var.a;
                if (jm0Var.a && this.b.mBlockingNotifyData != null) {
                    String a = bk0.a(this.b.mBlockingNotifyData.d);
                    if (a != null) {
                        ji0.b(a);
                        bk0.c(this.b.mBlockingNotifyData.d);
                        return;
                    }
                    boolean z = this.b.mBlockingNotifyData.q.s;
                    int i = this.b.mBlockingNotifyData.q.t;
                    if (z && this.b.isInternalValid(i)) {
                        AdAppStateManager adAppStateManager = this.b;
                        adAppStateManager.launchAfterInstall(adAppStateManager.mBlockingNotifyData);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
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
        this.mDatas = new HashMap(16);
        this.mBlockingNotifyData = null;
        this.mIsForeGround = true;
        init();
    }

    public /* synthetic */ AdAppStateManager(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInternalValid(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
            if (i > 0 && !b31.a(System.currentTimeMillis(), this.mBlockingTime, i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void launchAfterInstall(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mk0Var) != null) || mk0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = mk0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(mk0Var);
    }

    public void register(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, mk0Var) != null) || TextUtils.isEmpty(mk0Var.d)) {
            return;
        }
        zz0.e(this.mDatas, mk0Var.d, mk0Var);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addDataScheme("package");
            aj0.b().registerReceiver(this, intentFilter);
            registerBackForegroundEvent();
        }
    }

    public static AdAppStateManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b.a;
        }
        return (AdAppStateManager) invokeV.objValue;
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            cm0.a().b(new Object(), new a(this, jm0.class));
        }
    }

    public void launch(mk0 mk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mk0Var) == null) {
            this.mBlockingNotifyData = null;
            if (mk0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(mk0Var.d)) {
                String a2 = bk0.a(mk0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    ji0.b(a2);
                    bk0.c(mk0Var.d);
                    return;
                }
            }
            if ((!TextUtils.isEmpty(mk0Var.p.c) && ji0.b(mk0Var.p.c)) || !mk0Var.q.u) {
                return;
            }
            ql0.f(mk0Var.d);
            zj0.d(AdDownloadAction.OPEN, mk0Var);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) != null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data != null) {
            str = data.getEncodedSchemeSpecificPart();
        } else {
            str = "";
        }
        mk0 mk0Var = (mk0) zz0.b(this.mDatas, str);
        if (mk0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            mk0Var.c = AdDownloadStatus.INSTALLED;
            mk0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = aj0.b().getPackageManager().getPackageInfo(mk0Var.d, 0);
                if (packageInfo != null) {
                    mk0Var.o = packageInfo.versionName;
                    mk0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            mk0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            zj0.b().f(AdDownloadAction.INSTALL_FINISH, mk0Var);
            mk0Var.q.p = 0L;
            launchAfterInstall(mk0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            zj0.b().f(AdDownloadAction.REMOVE, mk0Var);
            if (mk0Var.q.q > 0) {
                yj0.a().b(mk0Var);
            }
            mk0Var.q.p = -1L;
        }
        dk0.b().d();
    }
}
