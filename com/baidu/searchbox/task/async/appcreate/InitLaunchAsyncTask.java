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
import com.baidu.tieba.bh;
import com.baidu.tieba.fb;
import com.baidu.tieba.iy8;
import com.baidu.tieba.jg5;
import com.baidu.tieba.jy8;
import com.baidu.tieba.o9;
import com.baidu.tieba.p65;
import com.baidu.tieba.pj5;
import com.baidu.tieba.pm8;
import com.baidu.tieba.pr4;
import com.baidu.tieba.s15;
import com.baidu.tieba.um8;
import com.baidu.tieba.wj5;
import com.baidu.tieba.zf;
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
            pm8.q().u();
        }
    }

    private void setServiceOnCreateCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            BdBaseService.setServiceOnCreateCallBack(new fb(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
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

                @Override // com.baidu.tieba.fb
                public void onServiceCreate() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        wj5.e().c(new wj5.b(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
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

                            @Override // com.baidu.tieba.wj5.b
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
            zf.e = UseHttpdnsSdkSwitch.isOn();
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
                    bh.a().postDelayed(new Runnable(this, h) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.3
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
            jg5.b().n(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setServiceOnCreateCallBack();
            um8.g().j();
            p65.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
            intReadThreadHistory();
            s15.c();
            pr4.s().A();
            pj5.m().s(TbadkCoreApplication.getInst());
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
                    jg5.b().q(System.currentTimeMillis() - currentTimeMillis);
                }
            }
            EmotionUtil.statisticsEmotionGroupNums();
            ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
            if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                jg5.b().g(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
            }
        }
    }

    public void intReadThreadHistory() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkApplication.getInst().mReadThreadHistory = new jy8(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new iy8(300);
            o9.f().s(TbadkApplication.getInst());
        }
    }
}
