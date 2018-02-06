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
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.d.j;
import com.baidu.tbadk.core.util.d.k;
import com.baidu.tbadk.core.util.d.l;
import com.baidu.tbadk.core.util.d.m;
import com.baidu.tbadk.core.util.d.n;
import com.baidu.tbadk.core.util.d.o;
import com.baidu.tbadk.core.util.d.p;
import com.baidu.tbadk.core.util.d.q;
import com.baidu.tbadk.core.util.d.r;
import com.baidu.tbadk.core.util.d.s;
import com.baidu.tbadk.core.util.d.t;
import com.baidu.tbadk.core.util.d.u;
import com.baidu.tbadk.o.at;
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
        xn();
        at.OQ();
        com.baidu.tieba.tbadkCore.location.b.init();
        com.baidu.tieba.im.widget.c.aMq();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.aKO();
        com.baidu.tieba.im.db.i.aIi();
        com.baidu.tbadk.browser.e.init();
        h.init();
        com.baidu.tieba.wallet.d.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.d.init();
        com.baidu.tbadk.plugin.a.init();
        com.baidu.tbadk.f.a.init();
    }

    private static void initRegisterIntent() {
        TbadkCoreApplication.getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
        TbadkCoreApplication.getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
        TbadkCoreApplication.getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
        TbadkCoreApplication.getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ShareWebActivityConfig.class, ShareWebActivity.class);
    }

    private static void initRegisterTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006002, new CustomMessageTask.CustomRunnable<HashMap<String, String>>() { // from class: com.baidu.tbadk.core.LaunchStatic.1
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
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tbadk.getUserInfo.b.Mp().HQ();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.aJ(TbConfig.GET_PAY_CONFIG, 303039));
        tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tbadk.core.LaunchStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && ((ExceptionData) customResponsedMessage.getData()).info.contains("java.lang.SecurityException: No permission to modify given thread")) {
                    TbadkCoreApplication.getInst().setWebviewCrashCount(TbadkCoreApplication.getInst().getWebviewCrashCount() + 1);
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2010001) { // from class: com.baidu.tbadk.core.LaunchStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2010001 && (customResponsedMessage.getData() instanceof String)) {
                    BdStatisticsManager.getInstance().resetSwitch((String) customResponsedMessage.getData());
                }
            }
        });
    }

    private static void xn() {
        com.baidu.adp.lib.f.c.nm().a(10, new t(true, 10));
        com.baidu.adp.lib.f.c.nm().a(11, new t(false, 10));
        com.baidu.adp.lib.f.c.nm().a(12, new r(false, false, false, 12));
        com.baidu.adp.lib.f.c.nm().a(26, new r(true, false, false, 26));
        com.baidu.adp.lib.f.c.nm().a(28, new r(false, false, true, 26));
        com.baidu.adp.lib.f.c.nm().a(13, new com.baidu.tbadk.core.util.d.f(true, false, false, 13));
        com.baidu.adp.lib.f.c.nm().a(14, new com.baidu.tbadk.core.util.d.f(false, false, false, 13));
        com.baidu.adp.lib.f.c.nm().a(15, new com.baidu.tbadk.core.util.d.g(false, 15));
        com.baidu.adp.lib.f.c.nm().a(16, new com.baidu.tbadk.core.util.d.g(true, 16));
        com.baidu.adp.lib.f.c.nm().a(17, new q(true, false, false, 17));
        com.baidu.adp.lib.f.c.nm().a(18, new q(false, false, false, 17));
        com.baidu.adp.lib.f.c.nm().a(19, new p(19));
        com.baidu.adp.lib.f.c.nm().a(21, new com.baidu.tbadk.core.util.d.h(21));
        com.baidu.adp.lib.f.c.nm().a(22, new u(22));
        com.baidu.adp.lib.f.c.nm().a(24, new m(24));
        com.baidu.adp.lib.f.c.nm().a(25, new r(false, true, false, 26));
        com.baidu.adp.lib.f.c.nm().a(27, new com.baidu.tbadk.core.util.d.c(27));
        com.baidu.adp.lib.f.c.nm().a(29, new s(true, 29));
        com.baidu.adp.lib.f.c.nm().a(30, new com.baidu.tbadk.core.util.d.b(true, false, false, 30));
        com.baidu.adp.lib.f.c.nm().a(31, new com.baidu.tbadk.core.util.d.b(false, false, false, 31));
        com.baidu.adp.lib.f.c.nm().a(32, new k(32));
        com.baidu.adp.lib.f.c.nm().a(23, new com.baidu.tbadk.core.voice.a.c());
        com.baidu.adp.lib.f.c.nm().a(33, new o());
        com.baidu.adp.lib.f.c.nm().a(34, new com.baidu.tbadk.core.util.d.e());
        com.baidu.adp.lib.f.c.nm().a(35, new l(160, 160));
        com.baidu.adp.lib.f.c.nm().a(36, new l());
        com.baidu.adp.lib.f.c.nm().a(37, new n());
        com.baidu.adp.lib.f.c.nm().a(38, new j());
    }
}
