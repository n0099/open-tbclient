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
import com.baidu.tbadk.core.atomData.ShareWebActivityConfig;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tbadk.core.util.d.v;
import com.baidu.tbadk.core.util.d.w;
import com.baidu.tbadk.core.util.d.x;
import com.baidu.tbadk.coreExtra.InitUserNameDialogActivity;
import com.baidu.tbadk.p.ba;
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
        xD();
        ba.PD();
        com.baidu.tieba.tbadkCore.location.b.init();
        com.baidu.tieba.im.widget.b.aUD();
        com.baidu.tieba.im.b.init();
        ImMemoryCacheRegister.aSZ();
        com.baidu.tieba.im.db.i.aQx();
        com.baidu.tbadk.browser.d.init();
        h.init();
        com.baidu.tieba.wallet.d.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.d.init();
        com.baidu.tbadk.plugin.a.init();
        com.baidu.tbadk.h.a.init();
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
        com.baidu.tbadk.getUserInfo.b.Nl().registerTask();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.aU(TbConfig.GET_PAY_CONFIG, 303039));
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

    private static void xD() {
        com.baidu.adp.lib.f.c.jA().a(10, new w(true, 10));
        com.baidu.adp.lib.f.c.jA().a(11, new w(false, 10));
        com.baidu.adp.lib.f.c.jA().a(39, new u(true, 39));
        com.baidu.adp.lib.f.c.jA().a(12, new t(false, false, 12));
        com.baidu.adp.lib.f.c.jA().a(26, new t(true, false, 26));
        com.baidu.adp.lib.f.c.jA().a(28, new t(false, false, 26));
        com.baidu.adp.lib.f.c.jA().a(40, new s(false, false, 40));
        com.baidu.adp.lib.f.c.jA().a(13, new com.baidu.tbadk.core.util.d.g(true, false, false, 13));
        com.baidu.adp.lib.f.c.jA().a(14, new com.baidu.tbadk.core.util.d.g(false, false, false, 13));
        com.baidu.adp.lib.f.c.jA().a(15, new com.baidu.tbadk.core.util.d.h(false, 15));
        com.baidu.adp.lib.f.c.jA().a(16, new com.baidu.tbadk.core.util.d.h(true, 16));
        com.baidu.adp.lib.f.c.jA().a(17, new r(true, false, false, 17));
        com.baidu.adp.lib.f.c.jA().a(18, new r(false, false, false, 17));
        com.baidu.adp.lib.f.c.jA().a(19, new q(19));
        com.baidu.adp.lib.f.c.jA().a(21, new com.baidu.tbadk.core.util.d.i(21));
        com.baidu.adp.lib.f.c.jA().a(22, new x(22));
        com.baidu.adp.lib.f.c.jA().a(24, new n(24));
        com.baidu.adp.lib.f.c.jA().a(25, new t(false, true, 26));
        com.baidu.adp.lib.f.c.jA().a(27, new com.baidu.tbadk.core.util.d.c(27));
        com.baidu.adp.lib.f.c.jA().a(29, new v(true, 29));
        com.baidu.adp.lib.f.c.jA().a(30, new com.baidu.tbadk.core.util.d.b(true, false, false, 30));
        com.baidu.adp.lib.f.c.jA().a(31, new com.baidu.tbadk.core.util.d.b(false, false, false, 31));
        com.baidu.adp.lib.f.c.jA().a(32, new l(32));
        com.baidu.adp.lib.f.c.jA().a(23, new com.baidu.tbadk.core.voice.a.c());
        com.baidu.adp.lib.f.c.jA().a(33, new p());
        com.baidu.adp.lib.f.c.jA().a(34, new com.baidu.tbadk.core.util.d.f());
        com.baidu.adp.lib.f.c.jA().a(35, new m(160, 160));
        com.baidu.adp.lib.f.c.jA().a(36, new m());
        com.baidu.adp.lib.f.c.jA().a(37, new o());
        com.baidu.adp.lib.f.c.jA().a(38, new k());
        com.baidu.adp.lib.f.c.jA().a(41, new com.baidu.tbadk.core.util.d.d());
        com.baidu.adp.lib.f.c.jA().a(42, new w(true, 10, false));
    }
}
