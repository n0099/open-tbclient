package com.baidu.tbadk.core;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
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
import d.a.c.e.l.d;
import d.a.n0.f1.h.i;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LaunchStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<HashMap<String, String>> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
            HashMap<String, String> data = customMessage.getData();
            Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), FatalErrorService.class);
            if (data != null && IntentConfig.START.equals(data.get("type"))) {
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
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || !((ExceptionData) customResponsedMessage.getData()).info.contains("java.lang.SecurityException: No permission to modify given thread")) {
                return;
            }
            TbadkCoreApplication.getInst().setWebviewCrashCount(TbadkCoreApplication.getInst().getWebviewCrashCount() + 1);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2010001 && (customResponsedMessage.getData() instanceof String)) {
                BdStatisticsManager.getInstance().resetSwitch((String) customResponsedMessage.getData());
            }
        }
    }

    static {
        a();
        d();
        b();
        c();
        SyncSwitch.initSyncSwitch();
        d.a.n0.e3.m0.a.a();
        d.a.n0.f1.y.b.a();
        d.a.n0.f1.b.a();
        ImMemoryCacheRegister.j();
        i.i();
        d.a.m0.l.c.e();
        d.a.m0.r.i.a();
        WalletStaticInit.init();
        d.a.m0.r.t.a.d();
        d.a.m0.r.x.c.a();
        d.a.m0.n0.a.c();
        d.a.m0.o.a.d();
    }

    public static void a() {
        TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
        TbadkCoreApplication.getInst().RegisterIntent(LcUpdateDialogActivityConfig.class, LcUpdateDialogActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
        TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ShareWebActivityConfig.class, ShareWebActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(InitUserNameDialogActivityConfig.class, InitUserNameDialogActivity.class);
    }

    public static void b() {
        MessageManager.getInstance().registerListener(new b(2016301));
        MessageManager.getInstance().registerListener(new c(2010001));
    }

    public static void c() {
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
        d.h().o(23, new d.a.m0.r.g0.b.c());
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

    public static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        d.a.m0.z.b.a().c();
        d.a.n0.e3.d0.a.f(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, d.a.n0.e3.d0.a.a(TbConfig.GET_PAY_CONFIG, 303039));
        tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
