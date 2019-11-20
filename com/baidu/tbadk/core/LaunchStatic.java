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
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.e.k;
import com.baidu.tbadk.core.util.e.l;
import com.baidu.tbadk.core.util.e.m;
import com.baidu.tbadk.core.util.e.n;
import com.baidu.tbadk.core.util.e.o;
import com.baidu.tbadk.core.util.e.p;
import com.baidu.tbadk.core.util.e.q;
import com.baidu.tbadk.core.util.e.r;
import com.baidu.tbadk.core.util.e.s;
import com.baidu.tbadk.core.util.e.t;
import com.baidu.tbadk.core.util.e.u;
import com.baidu.tbadk.core.util.e.v;
import com.baidu.tbadk.core.util.e.w;
import com.baidu.tbadk.core.util.e.x;
import com.baidu.tbadk.core.util.e.y;
import com.baidu.tbadk.coreExtra.InitUserNameDialogActivity;
import com.baidu.tbadk.t.bj;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
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
        agn();
        bj.axj();
        com.baidu.tieba.tbadkCore.location.b.init();
        com.baidu.tieba.im.widget.b.bEx();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.bCX();
        com.baidu.tieba.im.db.i.bAt();
        com.baidu.tbadk.browser.d.init();
        h.init();
        WalletStaticInit.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.d.init();
        com.baidu.tbadk.plugin.a.init();
        com.baidu.tbadk.j.a.init();
    }

    private static void initRegisterIntent() {
        TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
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
        com.baidu.tbadk.getUserInfo.b.avk().registerTask();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.bl("c/s/getClientConfig", 303039));
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

    private static void agn() {
        com.baidu.adp.lib.f.c.fT().a(10, new x(true, 10));
        com.baidu.adp.lib.f.c.fT().a(11, new x(false, 10));
        com.baidu.adp.lib.f.c.fT().a(39, new v(true, 39));
        com.baidu.adp.lib.f.c.fT().a(12, new u(false, false, 12));
        com.baidu.adp.lib.f.c.fT().a(26, new u(true, false, 26));
        com.baidu.adp.lib.f.c.fT().a(28, new u(false, false, 26));
        com.baidu.adp.lib.f.c.fT().a(40, new t(false, false, 40));
        com.baidu.adp.lib.f.c.fT().a(13, new com.baidu.tbadk.core.util.e.g(true, false, false, 13));
        com.baidu.adp.lib.f.c.fT().a(14, new com.baidu.tbadk.core.util.e.g(false, false, false, 13));
        com.baidu.adp.lib.f.c.fT().a(15, new com.baidu.tbadk.core.util.e.h(false, 15));
        com.baidu.adp.lib.f.c.fT().a(16, new com.baidu.tbadk.core.util.e.h(true, 16));
        com.baidu.adp.lib.f.c.fT().a(17, new s(true, false, false, 17));
        com.baidu.adp.lib.f.c.fT().a(18, new s(false, false, false, 17));
        com.baidu.adp.lib.f.c.fT().a(19, new r(19));
        com.baidu.adp.lib.f.c.fT().a(21, new com.baidu.tbadk.core.util.e.i(21));
        com.baidu.adp.lib.f.c.fT().a(22, new y(22));
        com.baidu.adp.lib.f.c.fT().a(24, new o(24));
        com.baidu.adp.lib.f.c.fT().a(25, new u(false, true, 26));
        com.baidu.adp.lib.f.c.fT().a(27, new com.baidu.tbadk.core.util.e.c(27));
        com.baidu.adp.lib.f.c.fT().a(29, new w(true, 29));
        com.baidu.adp.lib.f.c.fT().a(30, new com.baidu.tbadk.core.util.e.b(true, false, false, 30));
        com.baidu.adp.lib.f.c.fT().a(31, new com.baidu.tbadk.core.util.e.b(false, false, false, 31));
        com.baidu.adp.lib.f.c.fT().a(32, new l(32));
        com.baidu.adp.lib.f.c.fT().a(23, new com.baidu.tbadk.core.voice.a.c());
        com.baidu.adp.lib.f.c.fT().a(33, new q());
        com.baidu.adp.lib.f.c.fT().a(34, new com.baidu.tbadk.core.util.e.f());
        com.baidu.adp.lib.f.c.fT().a(35, new m(160, 160));
        com.baidu.adp.lib.f.c.fT().a(36, new m());
        com.baidu.adp.lib.f.c.fT().a(43, new n());
        com.baidu.adp.lib.f.c.fT().a(37, new p());
        com.baidu.adp.lib.f.c.fT().a(38, new k());
        com.baidu.adp.lib.f.c.fT().a(41, new com.baidu.tbadk.core.util.e.d());
        com.baidu.adp.lib.f.c.fT().a(42, new x(true, 10, false));
    }
}
