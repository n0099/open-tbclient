package com.baidu.tbadk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.NovelWebViewActivity;
import com.baidu.tbadk.browser.ShareWebActivity;
import com.baidu.tbadk.browser.TBWebContainerActivity;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.atomData.NovelWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebContainerActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.InitUserNameDialogActivity;
import com.baidu.tbadk.mutiprocess.sync.SyncDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.a98;
import com.baidu.tieba.b85;
import com.baidu.tieba.bd7;
import com.baidu.tieba.gc8;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
import com.baidu.tieba.jz9;
import com.baidu.tieba.lc.LcUpdateDialogActivity;
import com.baidu.tieba.lq5;
import com.baidu.tieba.m75;
import com.baidu.tieba.np5;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.service.UpdateInfoService;
import com.baidu.tieba.v68;
import com.baidu.tieba.wallet.WalletStaticInit;
import com.baidu.tieba.wk5;
import com.baidu.tieba.xx4;
import com.baidu.tieba.y0a;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class LaunchStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<HashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                HashMap<String, String> data = customMessage.getData();
                Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), FatalErrorService.class);
                if (data != null && "start".equals(data.get("type"))) {
                    intent.putExtra("uname", data.get("uname"));
                    intent.putExtra("uid", data.get("uid"));
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    return null;
                } else if ("stop".equals(data)) {
                    TbadkCoreApplication.getInst().getContext().stopService(intent);
                    return null;
                } else {
                    return null;
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("java.lang.SecurityException: No permission to modify given thread")) {
                TbadkCoreApplication.getInst().setWebviewCrashCount(TbadkCoreApplication.getInst().getWebviewCrashCount() + 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2010001 && (customResponsedMessage.getData() instanceof String)) {
                BdStatisticsManager.getInstance().resetSwitch((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbadkCoreApplication val$application;

        public d(TbadkCoreApplication tbadkCoreApplication) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbadkCoreApplication};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.val$application = tbadkCoreApplication;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && this.val$application.isMainProcess(false)) {
                this.val$application.notifyPageCountDelta(intent.getIntExtra("countDelta", 0), intent.getStringExtra("activityClassName"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1680072589, "Lcom/baidu/tbadk/core/LaunchStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1680072589, "Lcom/baidu/tbadk/core/LaunchStatic;");
                return;
            }
        }
        b();
        d();
        c();
        y0a.a();
        gc8.a();
        v68.a();
        ImMemoryCacheRegister.i();
        a98.i();
        xx4.h();
        ServiceStaticInit.init();
        WalletStaticInit.init();
        m75.d();
        b85.a();
        zz4.d();
        a();
        e();
        f();
        testTitans();
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            wk5.d().f();
            jz9.f(303039, ClientConfigSocketResponse.class, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, jz9.a(TbConfig.GET_PAY_CONFIG, 303039));
            tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public LaunchStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !Fresco.hasBeenInitialized()) {
            Fresco.initialize(TbadkCoreApplication.getInst(), bd7.a());
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            try {
                np5.f().l(SyncDataEvent.class, new lq5());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            d dVar = new d(inst);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tieba.baidu.pagecount");
            inst.registerReceiver(dVar, intentFilter);
        }
    }

    @Keep
    public static void testTitans() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            BdLog.d("testTitans");
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
            TbadkCoreApplication.getInst().RegisterIntent(LcUpdateDialogActivityConfig.class, LcUpdateDialogActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
            TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
            TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TBWebViewActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(TbWebContainerActivityConfig.class, TBWebContainerActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(ShareWebActivityConfig.class, ShareWebActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(NovelWebViewActivityConfig.class, NovelWebViewActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(InitUserNameDialogActivityConfig.class, InitUserNameDialogActivity.class);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            MessageManager.getInstance().registerListener(new b(2016301));
            MessageManager.getInstance().registerListener(new c(2010001));
            MessageManager.getInstance().registerStickyMode(2004602);
        }
    }
}
