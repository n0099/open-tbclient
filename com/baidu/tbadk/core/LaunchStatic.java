package com.baidu.tbadk.core;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.ShareWebActivity;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
import com.baidu.tbadk.core.atomData.LcUpdateDialogActivityConfig;
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.FlutterLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.ImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalPicDrawableLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalVideoThumbLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.MemeLoaderProc2;
import com.baidu.tbadk.core.util.resourceLoaderProc.NinePatchLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.PortraitLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleBlurLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleForeverMemoryLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.SimpleLoaderProc;
import com.baidu.tbadk.coreExtra.InitUserNameDialogActivity;
import com.baidu.tbadk.switchs.SyncSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
import com.baidu.tieba.lc.LcUpdateDialogActivity;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.service.UpdateInfoService;
import com.baidu.tieba.wallet.WalletStaticInit;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.l.d;
import d.a.q0.i1.h.i;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LaunchStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<HashMap<String, String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                } else if (IntentConfig.STOP.equals(data)) {
                    TbadkCoreApplication.getInst().getContext().stopService(intent);
                    return null;
                } else {
                    return null;
                }
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        a();
        d();
        b();
        c();
        SyncSwitch.initSyncSwitch();
        d.a.q0.h3.m0.a.a();
        d.a.q0.i1.y.b.a();
        d.a.q0.i1.b.a();
        ImMemoryCacheRegister.j();
        i.i();
        d.a.p0.m.c.e();
        d.a.p0.s.i.a();
        WalletStaticInit.init();
        d.a.p0.s.t.a.d();
        d.a.p0.s.x.c.a();
        d.a.p0.p0.a.c();
        d.a.p0.p.a.d();
    }

    public LaunchStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
            TbadkCoreApplication.getInst().RegisterIntent(LcUpdateDialogActivityConfig.class, LcUpdateDialogActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
            TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
            TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(ShareWebActivityConfig.class, ShareWebActivity.class);
            TbadkCoreApplication.getInst().RegisterIntent(InitUserNameDialogActivityConfig.class, InitUserNameDialogActivity.class);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager.getInstance().registerListener(new b(2016301));
            MessageManager.getInstance().registerListener(new c(2010001));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            d.h().o(10, new SimpleLoaderProc(true, true, false, 10));
            d.h().o(11, new SimpleLoaderProc(false, true, false, 10));
            d.h().o(42, new SimpleLoaderProc(true, false, false, 10));
            d.h().o(13, new SimpleLoaderProc(true, true, false, 13));
            d.h().o(14, new SimpleLoaderProc(false, true, false, 13));
            d.h().o(17, new SimpleLoaderProc(true, true, false, 17));
            d.h().o(18, new SimpleLoaderProc(false, true, false, 17));
            d.h().o(39, new SimpleBlurLoaderProc(true, 39));
            d.h().o(12, new PortraitLoaderProc(false, false, 12));
            d.h().o(26, new PortraitLoaderProc(true, false, 26));
            d.h().o(28, new PortraitLoaderProc(false, false, 26));
            d.h().o(40, new PortraitBlurLoaderProc(false, false, 40));
            d.h().o(19, new NinePatchLoaderProc(19));
            d.h().o(24, new LocalPicDrawableLoaderProc(24));
            d.h().o(25, new PortraitLoaderProc(false, true, 26));
            d.h().o(27, new BigImageLoaderProc(27));
            d.h().o(29, new SimpleForeverLoaderProc(true, 29));
            d.h().o(32, new LocalFileDrawableLoaderProc(32));
            d.h().o(23, new d.a.p0.s.g0.b.c());
            d.h().o(33, new MemeLoaderProc2());
            d.h().o(34, new EmotionShareLoaderProc());
            d.h().o(35, new LocalFileImageLoaderProc(160, 160));
            d.h().o(36, new LocalFileImageLoaderProc());
            d.h().o(43, new LocalFileImageLoaderProc2());
            d.h().o(37, new LocalVideoThumbLoaderProc());
            d.h().o(38, new ImageLoaderProc());
            d.h().o(41, new BigdayImageLoaderProc());
            d.h().o(44, new FlutterLoaderProc(true, 44, false));
            d.h().o(15, new SimpleLoaderProc(false, true, true, 15));
            d.h().o(16, new SimpleLoaderProc(false, true, true, 16));
            d.h().o(21, new SimpleLoaderProc(false, true, true, 21));
            d.h().o(30, new SimpleLoaderProc(true, true, false, 30));
            d.h().o(31, new SimpleLoaderProc(false, true, false, 30));
            d.h().o(45, new SimpleForeverMemoryLoaderProc(true, true, true, 45));
            d.h().o(46, new SimpleLoaderProc(true, true, false, 46));
            d.h().o(47, new SimpleLoaderProc(false, true, false, 46));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new a());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
            d.a.p0.a0.b.a().c();
            d.a.q0.h3.d0.a.f(303039, ClientConfigSocketResponse.class, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, d.a.q0.h3.d0.a.a(TbConfig.GET_PAY_CONFIG, 303039));
            tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
