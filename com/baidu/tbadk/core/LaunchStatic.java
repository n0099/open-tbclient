package com.baidu.tbadk.core;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.c.i;
import com.baidu.tbadk.core.util.c.j;
import com.baidu.tbadk.core.util.c.k;
import com.baidu.tbadk.core.util.c.l;
import com.baidu.tbadk.core.util.c.m;
import com.baidu.tbadk.core.util.c.n;
import com.baidu.tbadk.core.util.c.o;
import com.baidu.tbadk.core.util.c.p;
import com.baidu.tbadk.kuang.ReLoginFromKuangMessage;
import com.baidu.tbadk.p.ai;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.service.UpdateInfoService;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LaunchStatic {
    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
        oM();
        ai.GL();
        com.baidu.tieba.tbadkCore.location.b.init();
        com.baidu.tieba.im.widget.c.ayc();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.awz();
        com.baidu.tieba.im.db.h.atL();
        com.baidu.tbadk.browser.d.init();
        g.init();
        com.baidu.tieba.wallet.d.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.c.init();
        com.baidu.tbadk.plugin.a.init();
        com.baidu.tbadk.g.a.init();
    }

    private static void initRegisterIntent() {
        TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
        TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
        TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
    }

    private static void initRegisterTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.TIEBA_FATAL_ERROR, new CustomMessageTask.CustomRunnable<HashMap<String, String>>() { // from class: com.baidu.tbadk.core.LaunchStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<HashMap<String, String>> customMessage) {
                HashMap<String, String> data = customMessage.getData();
                Intent intent = new Intent(TbadkCoreApplication.getInst().getContext(), FatalErrorService.class);
                if (data != null && IntentConfig.START.equals(data.get("type"))) {
                    intent.putExtra("uname", data.get("uname"));
                    intent.putExtra(SapiAccountManager.SESSION_UID, data.get(SapiAccountManager.SESSION_UID));
                    TbadkCoreApplication.getInst().getContext().startService(intent);
                    return null;
                } else if (IntentConfig.STOP.equals(data)) {
                    TbadkCoreApplication.getInst().getContext().stopService(intent);
                    return null;
                } else {
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tbadk.getUserInfo.b.Ef().Eg();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.az(TbConfig.GET_PAY_CONFIG, 303039));
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
        if ("kuang".equals(TbConfig.getSubappType())) {
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LOGIN_STATUS_KUANG) { // from class: com.baidu.tbadk.core.LaunchStatic.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001325 && customResponsedMessage.getData() != null) {
                        if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                            TbadkCoreApplication.getInst().setIsKuangLogin(true);
                            com.baidu.tbadk.kuang.a.bR(true);
                            return;
                        }
                        TbadkCoreApplication.getInst().setIsKuangLogin(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new ReLoginFromKuangMessage(false));
                    }
                }
            });
        }
    }

    private static void oM() {
        com.baidu.adp.lib.f.c.fJ().a(10, new o(true, 10));
        com.baidu.adp.lib.f.c.fJ().a(11, new o(false, 10));
        com.baidu.adp.lib.f.c.fJ().a(12, new m(false, false, false, 12));
        com.baidu.adp.lib.f.c.fJ().a(26, new m(true, false, false, 26));
        com.baidu.adp.lib.f.c.fJ().a(28, new m(false, false, true, 26));
        com.baidu.adp.lib.f.c.fJ().a(13, new com.baidu.tbadk.core.util.c.e(true, false, false, 13));
        com.baidu.adp.lib.f.c.fJ().a(14, new com.baidu.tbadk.core.util.c.e(false, false, false, 13));
        com.baidu.adp.lib.f.c.fJ().a(15, new com.baidu.tbadk.core.util.c.f(false, 15));
        com.baidu.adp.lib.f.c.fJ().a(16, new com.baidu.tbadk.core.util.c.f(true, 16));
        com.baidu.adp.lib.f.c.fJ().a(17, new l(true, false, false, 17));
        com.baidu.adp.lib.f.c.fJ().a(18, new l(false, false, false, 17));
        com.baidu.adp.lib.f.c.fJ().a(19, new k(19));
        com.baidu.adp.lib.f.c.fJ().a(21, new com.baidu.tbadk.core.util.c.g(21));
        com.baidu.adp.lib.f.c.fJ().a(22, new p(22));
        com.baidu.adp.lib.f.c.fJ().a(24, new j(24));
        com.baidu.adp.lib.f.c.fJ().a(25, new m(false, true, false, 26));
        com.baidu.adp.lib.f.c.fJ().a(27, new com.baidu.tbadk.core.util.c.c(27));
        com.baidu.adp.lib.f.c.fJ().a(29, new n(true, 29));
        com.baidu.adp.lib.f.c.fJ().a(30, new com.baidu.tbadk.core.util.c.b(true, false, false, 30));
        com.baidu.adp.lib.f.c.fJ().a(31, new com.baidu.tbadk.core.util.c.b(false, false, false, 31));
        com.baidu.adp.lib.f.c.fJ().a(32, new i(32));
        com.baidu.adp.lib.f.c.fJ().a(23, new com.baidu.tbadk.core.voice.a.c());
    }
}
