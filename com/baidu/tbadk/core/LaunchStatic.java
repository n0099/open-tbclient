package com.baidu.tbadk.core;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
import com.baidu.tbadk.core.util.c.l;
import com.baidu.tbadk.core.util.c.m;
import com.baidu.tbadk.core.util.c.n;
import com.baidu.tbadk.core.util.c.o;
import com.baidu.tbadk.core.util.c.p;
import com.baidu.tbadk.core.util.c.q;
import com.baidu.tbadk.core.util.c.r;
import com.baidu.tbadk.core.util.c.s;
import com.baidu.tbadk.core.util.c.t;
import com.baidu.tbadk.core.util.c.u;
import com.baidu.tbadk.core.util.c.v;
import com.baidu.tbadk.core.util.c.w;
import com.baidu.tbadk.core.util.c.x;
import com.baidu.tbadk.core.util.c.y;
import com.baidu.tbadk.core.util.c.z;
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
import java.util.HashMap;
/* loaded from: classes.dex */
public class LaunchStatic {
    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
        bfn();
        SyncSwitch.initSyncSwitch();
        com.baidu.tieba.tbadkCore.location.a.init();
        com.baidu.tieba.im.widget.b.cPS();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.cOp();
        com.baidu.tieba.im.db.i.cLw();
        com.baidu.tbadk.browser.d.init();
        i.init();
        WalletStaticInit.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.c.init();
        com.baidu.tbadk.plugin.a.init();
        com.baidu.tbadk.j.a.init();
    }

    private static void initRegisterIntent() {
        TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
        TbadkCoreApplication.getInst().RegisterIntent(LcUpdateDialogActivityConfig.class, LcUpdateDialogActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
        TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ShareWebActivityConfig.class, ShareWebActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(InitUserNameDialogActivityConfig.class, InitUserNameDialogActivity.class);
    }

    private static void initRegisterTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.TIEBA_FATAL_ERROR, new CustomMessageTask.CustomRunnable<HashMap<String, String>>() { // from class: com.baidu.tbadk.core.LaunchStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
                HashMap<String, String> data = customMessage.getData();
                Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), FatalErrorService.class);
                if (data != null && "start".equals(data.get("type"))) {
                    intent.putExtra(BdStatsConstant.StatsKey.UNAME, data.get(BdStatsConstant.StatsKey.UNAME));
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
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tbadk.getUserInfo.b.bwE().registerTask();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.bI("c/s/getClientConfig", 303039));
        tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.UEXCEPTION_MESSAGE) { // from class: com.baidu.tbadk.core.LaunchStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("java.lang.SecurityException: No permission to modify given thread")) {
                    TbadkCoreApplication.getInst().setWebviewCrashCount(TbadkCoreApplication.getInst().getWebviewCrashCount() + 1);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED) { // from class: com.baidu.tbadk.core.LaunchStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2010001 && (customResponsedMessage.getData() instanceof String)) {
                    BdStatisticsManager.getInstance().resetSwitch((String) customResponsedMessage.getData());
                }
            }
        });
    }

    private static void bfn() {
        com.baidu.adp.lib.e.c.mS().a(10, new y(true, 10));
        com.baidu.adp.lib.e.c.mS().a(11, new y(false, 10));
        com.baidu.adp.lib.e.c.mS().a(39, new w(true, 39));
        com.baidu.adp.lib.e.c.mS().a(12, new v(false, false, 12));
        com.baidu.adp.lib.e.c.mS().a(26, new v(true, false, 26));
        com.baidu.adp.lib.e.c.mS().a(28, new v(false, false, 26));
        com.baidu.adp.lib.e.c.mS().a(40, new u(false, false, 40));
        com.baidu.adp.lib.e.c.mS().a(13, new com.baidu.tbadk.core.util.c.h(true, false, false, 13));
        com.baidu.adp.lib.e.c.mS().a(14, new com.baidu.tbadk.core.util.c.h(false, false, false, 13));
        com.baidu.adp.lib.e.c.mS().a(15, new com.baidu.tbadk.core.util.c.i(false, 15));
        com.baidu.adp.lib.e.c.mS().a(16, new com.baidu.tbadk.core.util.c.i(true, 16));
        com.baidu.adp.lib.e.c.mS().a(17, new t(true, false, false, 17));
        com.baidu.adp.lib.e.c.mS().a(18, new t(false, false, false, 17));
        com.baidu.adp.lib.e.c.mS().a(19, new s(19));
        com.baidu.adp.lib.e.c.mS().a(21, new com.baidu.tbadk.core.util.c.j(21));
        com.baidu.adp.lib.e.c.mS().a(22, new z(22));
        com.baidu.adp.lib.e.c.mS().a(24, new p(24));
        com.baidu.adp.lib.e.c.mS().a(25, new v(false, true, 26));
        com.baidu.adp.lib.e.c.mS().a(27, new com.baidu.tbadk.core.util.c.c(27));
        com.baidu.adp.lib.e.c.mS().a(29, new x(true, 29));
        com.baidu.adp.lib.e.c.mS().a(30, new com.baidu.tbadk.core.util.c.b(true, false, false, 30));
        com.baidu.adp.lib.e.c.mS().a(31, new com.baidu.tbadk.core.util.c.b(false, false, false, 31));
        com.baidu.adp.lib.e.c.mS().a(32, new m(32));
        com.baidu.adp.lib.e.c.mS().a(23, new com.baidu.tbadk.core.voice.a.c());
        com.baidu.adp.lib.e.c.mS().a(33, new r());
        com.baidu.adp.lib.e.c.mS().a(34, new com.baidu.tbadk.core.util.c.f());
        com.baidu.adp.lib.e.c.mS().a(35, new n(160, 160));
        com.baidu.adp.lib.e.c.mS().a(36, new n());
        com.baidu.adp.lib.e.c.mS().a(43, new o());
        com.baidu.adp.lib.e.c.mS().a(37, new q());
        com.baidu.adp.lib.e.c.mS().a(38, new l());
        com.baidu.adp.lib.e.c.mS().a(41, new com.baidu.tbadk.core.util.c.d());
        com.baidu.adp.lib.e.c.mS().a(42, new y(true, 10, false));
        com.baidu.adp.lib.e.c.mS().a(44, new com.baidu.tbadk.core.util.c.g(true, 44, false));
    }
}
