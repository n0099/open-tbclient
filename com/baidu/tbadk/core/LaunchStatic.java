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
import com.baidu.tbadk.core.util.d.l;
import com.baidu.tbadk.core.util.d.m;
import com.baidu.tbadk.core.util.d.n;
import com.baidu.tbadk.core.util.d.o;
import com.baidu.tbadk.core.util.d.p;
import com.baidu.tbadk.core.util.d.q;
import com.baidu.tbadk.core.util.d.r;
import com.baidu.tbadk.core.util.d.s;
import com.baidu.tbadk.core.util.d.t;
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
        bkS();
        SyncSwitch.initSyncSwitch();
        com.baidu.tieba.tbadkCore.location.a.init();
        com.baidu.tieba.im.widget.b.cYd();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.cWR();
        com.baidu.tieba.im.db.i.cVC();
        com.baidu.tbadk.browser.c.init();
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
        com.baidu.tbadk.getUserInfo.b.bCI().registerTask();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.bV("c/s/getClientConfig", 303039));
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

    private static void bkS() {
        com.baidu.adp.lib.e.d.mw().a(10, new t(true, true, false, 10));
        com.baidu.adp.lib.e.d.mw().a(11, new t(false, true, false, 10));
        com.baidu.adp.lib.e.d.mw().a(42, new t(true, false, false, 10));
        com.baidu.adp.lib.e.d.mw().a(13, new t(true, true, false, 13));
        com.baidu.adp.lib.e.d.mw().a(14, new t(false, true, false, 13));
        com.baidu.adp.lib.e.d.mw().a(17, new t(true, true, false, 17));
        com.baidu.adp.lib.e.d.mw().a(18, new t(false, true, false, 17));
        com.baidu.adp.lib.e.d.mw().a(39, new r(true, 39));
        com.baidu.adp.lib.e.d.mw().a(12, new q(false, false, 12));
        com.baidu.adp.lib.e.d.mw().a(26, new q(true, false, 26));
        com.baidu.adp.lib.e.d.mw().a(28, new q(false, false, 26));
        com.baidu.adp.lib.e.d.mw().a(40, new p(false, false, 40));
        com.baidu.adp.lib.e.d.mw().a(19, new o(19));
        com.baidu.adp.lib.e.d.mw().a(24, new l(24));
        com.baidu.adp.lib.e.d.mw().a(25, new q(false, true, 26));
        com.baidu.adp.lib.e.d.mw().a(27, new com.baidu.tbadk.core.util.d.b(27));
        com.baidu.adp.lib.e.d.mw().a(29, new s(true, 29));
        com.baidu.adp.lib.e.d.mw().a(32, new com.baidu.tbadk.core.util.d.i(32));
        com.baidu.adp.lib.e.d.mw().a(23, new com.baidu.tbadk.core.voice.a.c());
        com.baidu.adp.lib.e.d.mw().a(33, new n());
        com.baidu.adp.lib.e.d.mw().a(34, new com.baidu.tbadk.core.util.d.e());
        com.baidu.adp.lib.e.d.mw().a(35, new com.baidu.tbadk.core.util.d.j(160, 160));
        com.baidu.adp.lib.e.d.mw().a(36, new com.baidu.tbadk.core.util.d.j());
        com.baidu.adp.lib.e.d.mw().a(43, new com.baidu.tbadk.core.util.d.k());
        com.baidu.adp.lib.e.d.mw().a(37, new m());
        com.baidu.adp.lib.e.d.mw().a(38, new com.baidu.tbadk.core.util.d.h());
        com.baidu.adp.lib.e.d.mw().a(41, new com.baidu.tbadk.core.util.d.c());
        com.baidu.adp.lib.e.d.mw().a(44, new com.baidu.tbadk.core.util.d.f(true, 44, false));
        com.baidu.adp.lib.e.d.mw().a(15, new t(false, true, true, 15));
        com.baidu.adp.lib.e.d.mw().a(16, new t(false, true, true, 16));
        com.baidu.adp.lib.e.d.mw().a(21, new t(false, true, true, 21));
        com.baidu.adp.lib.e.d.mw().a(30, new t(true, true, false, 30));
        com.baidu.adp.lib.e.d.mw().a(31, new t(false, true, false, 30));
    }
}
