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
import com.baidu.tieba.gm0;
import com.baidu.tieba.hn0;
import com.baidu.tieba.i51;
import com.baidu.tieba.nj0;
import com.baidu.tieba.o31;
import com.baidu.tieba.ok0;
import com.baidu.tieba.pk0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.tk0;
import com.baidu.tieba.wi0;
import com.baidu.tieba.wm0;
import com.baidu.tieba.z11;
import com.baidu.tieba.zm0;
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
    public cl0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, cl0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl0 a;
        public final /* synthetic */ AdAppStateManager b;

        public a(AdAppStateManager adAppStateManager, cl0 cl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adAppStateManager, cl0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = adAppStateManager;
            this.a = cl0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.launch(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends wm0<zm0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdAppStateManager b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdAppStateManager adAppStateManager, Class cls) {
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
        @Override // com.baidu.tieba.wm0
        public void onEvent(@NonNull zm0 zm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zm0Var) == null) {
                this.b.mIsForeGround = zm0Var.a;
                if (zm0Var.a && this.b.mBlockingNotifyData != null) {
                    String a = rk0.a(this.b.mBlockingNotifyData.d);
                    if (a != null) {
                        wi0.b(a);
                        rk0.c(this.b.mBlockingNotifyData.d);
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
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final AdAppStateManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1342808003, "Lcom/baidu/nadcore/download/basic/AdAppStateManager$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1342808003, "Lcom/baidu/nadcore/download/basic/AdAppStateManager$c;");
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
        this.mDatas = new HashMap<>(16);
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
            if (i > 0 && !i51.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void launchAfterInstall(cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cl0Var) != null) || cl0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = cl0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(cl0Var);
    }

    public void register(@NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, cl0Var) != null) || TextUtils.isEmpty(cl0Var.d)) {
            return;
        }
        z11.e(this.mDatas, cl0Var.d, cl0Var);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addDataScheme("package");
            nj0.b().registerReceiver(this, intentFilter);
            registerBackForegroundEvent();
        }
    }

    public static AdAppStateManager instance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return c.a;
        }
        return (AdAppStateManager) invokeV.objValue;
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sm0.a().b(new Object(), new b(this, zm0.class));
        }
    }

    public void launch(cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cl0Var) == null) {
            this.mBlockingNotifyData = null;
            if (cl0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(cl0Var.d)) {
                String a2 = rk0.a(cl0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    wi0.b(a2);
                    rk0.c(cl0Var.d);
                    return;
                }
            }
            if ((!TextUtils.isEmpty(cl0Var.p.c) && wi0.b(cl0Var.p.c)) || !cl0Var.q.u) {
                return;
            }
            gm0.g(cl0Var.d);
            pk0.d(AdDownloadAction.OPEN, cl0Var);
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
        cl0 cl0Var = (cl0) z11.b(this.mDatas, str);
        if (cl0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            cl0Var.c = AdDownloadStatus.INSTALLED;
            cl0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = nj0.b().getPackageManager().getPackageInfo(cl0Var.d, 0);
                if (packageInfo != null) {
                    cl0Var.o = packageInfo.versionName;
                    cl0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            cl0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            pk0.b().f(AdDownloadAction.INSTALL_FINISH, cl0Var);
            cl0Var.q.p = 0L;
            boolean z = true;
            if (hn0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                o31.a(new a(this, cl0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(cl0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            pk0.b().f(AdDownloadAction.REMOVE, cl0Var);
            if (cl0Var.q.q > 0) {
                ok0.a().b(cl0Var);
            }
            cl0Var.q.p = -1L;
        }
        tk0.b().d();
    }
}
