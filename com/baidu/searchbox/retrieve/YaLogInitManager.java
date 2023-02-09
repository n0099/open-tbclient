package com.baidu.searchbox.retrieve;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager;
import com.baidu.searchbox.common.runtime.AppRuntimeInit;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.retrieve.connect.FetchConnManager;
import com.baidu.tieba.dk1;
import com.baidu.tieba.hk1;
import com.baidu.tieba.pz9;
import com.baidu.tieba.v80;
import com.baidu.tieba.z10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.service.VoyagerIPCManager;
import com.baidu.yalog.LoggerManager;
/* loaded from: classes3.dex */
public class YaLogInitManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int OPEN_TYPE = 1;
    public static volatile YaLogInitManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Application mApp;

    public YaLogInitManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static YaLogInitManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mInstance == null) {
                synchronized (YaLogInitManager.class) {
                    if (mInstance == null) {
                        mInstance = new YaLogInitManager();
                    }
                }
            }
            return mInstance;
        }
        return (YaLogInitManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initConnect(boolean z, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TRACKBALL, this, z, str) == null) && z && this.mApp != null && !TextUtils.isEmpty(str)) {
            CloudControlBlCPManager.getInstance().registerConnectStateListener(this.mApp);
            FetchConnManager.getInstance().init();
            v80.a(this.mApp, str, z10.a().getDeviceId(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryTask(boolean z) {
        pz9 pz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65541, this, z) == null) && z && (pz9Var = (pz9) ServiceManager.getService(pz9.a)) != null) {
            pz9Var.retry();
        }
    }

    public void initYaLogBaseContext(Application application) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application) == null) && application != null) {
            AppRuntimeInit.onApplicationattachBaseContext(application);
            hk1.b(application);
            if (dk1.g()) {
                VoyagerIPCManager.b();
            }
            this.mApp = application;
        }
    }

    public void initYaLog(boolean z, boolean z2, boolean z3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str}) != null) || !dk1.g()) {
            return;
        }
        if (z) {
            CloudControlManager.getInstance().requestCloudControl("0");
        }
        ExecutorUtilsExt.postOnElastic(new Runnable(this, z2, str, z3) { // from class: com.baidu.searchbox.retrieve.YaLogInitManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ YaLogInitManager this$0;
            public final /* synthetic */ String val$appId;
            public final /* synthetic */ boolean val$initConnect;
            public final /* synthetic */ boolean val$isRetry;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z2), str, Boolean.valueOf(z3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$initConnect = z2;
                this.val$appId = str;
                this.val$isRetry = z3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    LoggerManager.getDefaultLogger();
                    this.this$0.initConnect(this.val$initConnect, this.val$appId);
                    this.this$0.retryTask(this.val$isRetry);
                }
            }
        }, "initYaLog", 0);
    }
}
