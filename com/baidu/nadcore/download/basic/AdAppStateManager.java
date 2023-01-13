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
import com.baidu.tieba.ck0;
import com.baidu.tieba.dk0;
import com.baidu.tieba.ej0;
import com.baidu.tieba.f21;
import com.baidu.tieba.fk0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.hk0;
import com.baidu.tieba.km0;
import com.baidu.tieba.ni0;
import com.baidu.tieba.nm0;
import com.baidu.tieba.qk0;
import com.baidu.tieba.ul0;
import com.baidu.tieba.v01;
import com.baidu.tieba.vm0;
import com.baidu.tieba.y31;
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
    public qk0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, qk0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qk0 a;
        public final /* synthetic */ AdAppStateManager b;

        public a(AdAppStateManager adAppStateManager, qk0 qk0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adAppStateManager, qk0Var};
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
            this.a = qk0Var;
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
    public class b extends km0<nm0> {
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
        @Override // com.baidu.tieba.km0
        public void onEvent(@NonNull nm0 nm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm0Var) == null) {
                this.b.mIsForeGround = nm0Var.a;
                if (nm0Var.a && this.b.mBlockingNotifyData != null) {
                    String a = fk0.a(this.b.mBlockingNotifyData.d);
                    if (a != null) {
                        ni0.b(a);
                        fk0.c(this.b.mBlockingNotifyData.d);
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
            if (i > 0 && !y31.c(System.currentTimeMillis(), this.mBlockingTime, i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void launchAfterInstall(qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qk0Var) != null) || qk0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = qk0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(qk0Var);
    }

    public void register(@NonNull qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, qk0Var) != null) || TextUtils.isEmpty(qk0Var.d)) {
            return;
        }
        v01.e(this.mDatas, qk0Var.d, qk0Var);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addDataScheme("package");
            ej0.b().registerReceiver(this, intentFilter);
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
            gm0.a().b(new Object(), new b(this, nm0.class));
        }
    }

    public void launch(qk0 qk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qk0Var) == null) {
            this.mBlockingNotifyData = null;
            if (qk0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(qk0Var.d)) {
                String a2 = fk0.a(qk0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    ni0.b(a2);
                    fk0.c(qk0Var.d);
                    return;
                }
            }
            if ((!TextUtils.isEmpty(qk0Var.p.c) && ni0.b(qk0Var.p.c)) || !qk0Var.q.u) {
                return;
            }
            ul0.g(qk0Var.d);
            dk0.d(AdDownloadAction.OPEN, qk0Var);
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
        qk0 qk0Var = (qk0) v01.b(this.mDatas, str);
        if (qk0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            qk0Var.c = AdDownloadStatus.INSTALLED;
            qk0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = ej0.b().getPackageManager().getPackageInfo(qk0Var.d, 0);
                if (packageInfo != null) {
                    qk0Var.o = packageInfo.versionName;
                    qk0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            qk0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            dk0.b().f(AdDownloadAction.INSTALL_FINISH, qk0Var);
            qk0Var.q.p = 0L;
            boolean z = true;
            if (vm0.b().a().a("nad_uad_launch_immediate", 0) != 1) {
                z = false;
            }
            if (z) {
                f21.a(new a(this, qk0Var), "nad_uad_launch_immediate", 0, 1500L);
            } else {
                launchAfterInstall(qk0Var);
            }
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            dk0.b().f(AdDownloadAction.REMOVE, qk0Var);
            if (qk0Var.q.q > 0) {
                ck0.a().b(qk0Var);
            }
            qk0Var.q.p = -1L;
        }
        hk0.b().d();
    }
}
