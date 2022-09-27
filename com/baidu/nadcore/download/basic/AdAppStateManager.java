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
import com.baidu.tieba.a31;
import com.baidu.tieba.ak0;
import com.baidu.tieba.bm0;
import com.baidu.tieba.ck0;
import com.baidu.tieba.fm0;
import com.baidu.tieba.ii0;
import com.baidu.tieba.im0;
import com.baidu.tieba.lk0;
import com.baidu.tieba.pl0;
import com.baidu.tieba.xj0;
import com.baidu.tieba.yj0;
import com.baidu.tieba.yz0;
import com.baidu.tieba.zi0;
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
    public lk0 mBlockingNotifyData;
    public long mBlockingTime;
    public HashMap<String, lk0> mDatas;
    public boolean mIsForeGround;

    /* loaded from: classes2.dex */
    public class a extends fm0<im0> {
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
        @Override // com.baidu.tieba.fm0
        public void onEvent(@NonNull im0 im0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, im0Var) == null) {
                this.b.mIsForeGround = im0Var.a;
                if (!im0Var.a || this.b.mBlockingNotifyData == null) {
                    return;
                }
                String a = ak0.a(this.b.mBlockingNotifyData.d);
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
                ii0.b(a);
                ak0.c(this.b.mBlockingNotifyData.d);
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
            zi0.b().registerReceiver(this, intentFilter);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) ? i > 0 && !a31.a(System.currentTimeMillis(), this.mBlockingTime, i) : invokeI.booleanValue;
    }

    public void launch(lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lk0Var) == null) {
            this.mBlockingNotifyData = null;
            if (lk0Var == null) {
                return;
            }
            if (!TextUtils.isEmpty(lk0Var.d)) {
                String a2 = ak0.a(lk0Var.d);
                if (!TextUtils.isEmpty(a2)) {
                    ii0.b(a2);
                    ak0.c(lk0Var.d);
                    return;
                }
            }
            if ((TextUtils.isEmpty(lk0Var.p.c) || !ii0.b(lk0Var.p.c)) && lk0Var.q.u) {
                pl0.f(lk0Var.d);
                yj0.d(AdDownloadAction.OPEN, lk0Var);
            }
        }
    }

    public void launchAfterInstall(lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk0Var) == null) || lk0Var == null) {
            return;
        }
        if (!this.mIsForeGround) {
            this.mBlockingNotifyData = lk0Var;
            this.mBlockingTime = System.currentTimeMillis();
            return;
        }
        launch(lk0Var);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) || intent == null) {
            return;
        }
        Uri data = intent.getData();
        lk0 lk0Var = (lk0) yz0.b(this.mDatas, data != null ? data.getEncodedSchemeSpecificPart() : "");
        if (lk0Var == null) {
            return;
        }
        if (TextUtils.equals(PackageChangedReceiver.ACTION_INSTALL, intent.getAction())) {
            lk0Var.c = AdDownloadStatus.INSTALLED;
            lk0Var.q.q = System.currentTimeMillis();
            try {
                PackageInfo packageInfo = zi0.b().getPackageManager().getPackageInfo(lk0Var.d, 0);
                if (packageInfo != null) {
                    lk0Var.o = packageInfo.versionName;
                    lk0Var.n = packageInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            lk0Var.q.j = ClogBuilder.Area.APP_NOTIFICATION.type;
            yj0.b().f(AdDownloadAction.INSTALL_FINISH, lk0Var);
            lk0Var.q.p = 0L;
            launchAfterInstall(lk0Var);
        } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
            yj0.b().f(AdDownloadAction.REMOVE, lk0Var);
            if (lk0Var.q.q > 0) {
                xj0.a().b(lk0Var);
            }
            lk0Var.q.p = -1L;
        }
        ck0.b().d();
    }

    public void register(@NonNull lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, lk0Var) == null) || TextUtils.isEmpty(lk0Var.d)) {
            return;
        }
        yz0.e(this.mDatas, lk0Var.d, lk0Var);
    }

    public void registerBackForegroundEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            bm0.a().b(new Object(), new a(this, im0.class));
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
