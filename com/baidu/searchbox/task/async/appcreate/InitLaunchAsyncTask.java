package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ColdStartStatsUtil;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.ah;
import com.baidu.tieba.aj5;
import com.baidu.tieba.c65;
import com.baidu.tieba.ci8;
import com.baidu.tieba.eb;
import com.baidu.tieba.fr4;
import com.baidu.tieba.gj5;
import com.baidu.tieba.h15;
import com.baidu.tieba.lt8;
import com.baidu.tieba.mt8;
import com.baidu.tieba.n9;
import com.baidu.tieba.uf5;
import com.baidu.tieba.xh8;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class InitLaunchAsyncTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "InitLaunchAsync" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public InitLaunchAsyncTask() {
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

    private void initQuickWebViewManager() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true)) {
            xh8.q().u();
        }
    }

    private void setServiceOnCreateCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            BdBaseService.setServiceOnCreateCallBack(new eb(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLaunchAsyncTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.tieba.eb
                public void onServiceCreate() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        gj5.e().c(new gj5.b(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.tieba.gj5.b
                            public void onResult(boolean z) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z) == null) {
                                    if (z) {
                                        BdBaseService.serviceStartFlag = 2;
                                    } else {
                                        BdBaseService.serviceStartFlag = 1;
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void initICDN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            yf.e = UseHttpdnsSdkSwitch.isOn();
            if (UseHttpdnsSdkSwitch.isOn()) {
                BDHttpDns h = BDHttpDns.h(TbadkCoreApplication.getInst().getApplicationContext());
                h.m(false);
                try {
                    h.j("119799");
                    h.p("87JNTZjGacgUzuMBYvid");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                h.l(true);
                h.n(true, true);
                h.k(BDHttpDns.CachePolicy.POLICY_TOLERANT);
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    ah.a().postDelayed(new Runnable(this, h) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InitLaunchAsyncTask this$0;
                        public final /* synthetic */ BDHttpDns val$httpDns;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, h};
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
                            this.val$httpDns = h;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$httpDns.o(PrefetchEvent.MODULE);
                            }
                        }
                    }, 1000L);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ICDNProblemUploader.getInstance();
            ICDNIPDirectConnect.getInstance();
            if (TbadkCoreApplication.getInst().isMainProcess(true) && ICDNIPDirectConnect.getInstance() != null) {
                ICDNIPDirectConnect.getInstance().init();
            }
            uf5.b().n(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setServiceOnCreateCallBack();
            ci8.g().j();
            c65.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
            intReadThreadHistory();
            h15.c();
            fr4.s().A();
            aj5.m().s(TbadkCoreApplication.getInst());
            initICDN();
            initQuickWebViewManager();
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                TbadkApplication.getInst().updateSignAlarm();
                TbadkApplication.getInst().initLikeForum();
                TbadkApplication.getInst().initSignedForum();
                if (TbSingleton.getInstance().isAuditPackageSwitchOn()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    NASLib.setCallBack(new NASLib.NASCallBack(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InitLaunchAsyncTask this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        @Override // com.baidu.appsearchlib.NASLib.NASCallBack
                        public void callback(String str, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, str2) == null) {
                                UrlManager.getInstance().dealOneLink(null, new String[]{str2});
                            }
                        }
                    });
                    uf5.b().q(System.currentTimeMillis() - currentTimeMillis);
                }
            }
            EmotionUtil.statisticsEmotionGroupNums();
            ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
            if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                uf5.b().g(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
            }
        }
    }

    public void intReadThreadHistory() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkApplication.getInst().mReadThreadHistory = new mt8(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new lt8(300);
            n9.g().t(TbadkApplication.getInst());
        }
    }
}
