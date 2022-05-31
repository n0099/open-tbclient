package com.baidu.searchbox.task.async.appcreate;

import com.baidu.adp.base.BdBaseService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ColdStartStatsUtil;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ICDNProblemUploader;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ci8;
import com.repackage.cm4;
import com.repackage.d85;
import com.repackage.di8;
import com.repackage.fv4;
import com.repackage.iz4;
import com.repackage.jb5;
import com.repackage.ka;
import com.repackage.lf;
import com.repackage.mg;
import com.repackage.o68;
import com.repackage.pb5;
import com.repackage.t68;
import com.repackage.x8;
/* loaded from: classes2.dex */
public class InitLaunchAsyncTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    private void initICDN() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            lf.e = UseHttpdnsSdkSwitch.isOn();
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
                    mg.a().postDelayed(new Runnable(this, h) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.3
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
            d85.b().n(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    private void initQuickWebViewManager() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true)) {
            o68.q().u();
        }
    }

    private void setServiceOnCreateCallBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            BdBaseService.setServiceOnCreateCallBack(new ka(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2
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

                @Override // com.repackage.ka
                public void onServiceCreate() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        pb5.e().c(new pb5.b(this) { // from class: com.baidu.searchbox.task.async.appcreate.InitLaunchAsyncTask.2.1
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

                            @Override // com.repackage.pb5.b
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

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setServiceOnCreateCallBack();
            t68.g().j();
            iz4.j().m(TbadkCoreApplication.getInst().isMainProcess(false));
            intReadThreadHistory();
            fv4.c();
            cm4.t().C();
            jb5.m().s(TbadkCoreApplication.getInst());
            initICDN();
            initQuickWebViewManager();
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                TbadkApplication.getInst().updateSignAlarm();
                TbadkApplication.getInst().initLikeForum();
                TbadkApplication.getInst().initSignedForum();
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
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).addParam("obj_param1", 1));
                            UrlManager.getInstance().dealOneLink(null, new String[]{str2});
                        }
                    }
                });
                d85.b().q(System.currentTimeMillis() - currentTimeMillis);
            }
            EmotionUtil.statisticsEmotionGroupNums();
            ColdStartStatsUtil.startUBCStats(TbadkCoreApplication.getInst().isMainProcess(false));
            if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                d85.b().g(System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime);
            }
        }
    }

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

    public void intReadThreadHistory() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkApplication.getInst().mReadThreadHistory = new di8(300);
            TbadkApplication.getInst().mPhotoLiveReadHistory = new ci8(300);
            x8.g().s(TbadkApplication.getInst());
        }
    }
}
