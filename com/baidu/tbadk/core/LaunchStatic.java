package com.baidu.tbadk.core;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.clientConfig.ClientConfigHttpProtoResponse;
import com.baidu.tbadk.clientConfig.ClientConfigSocketResponse;
import com.baidu.tbadk.core.atomData.SyncServiceConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.atomData.UpdateInfoServiceConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.im.memorycache.ImMemoryCacheRegister;
import com.baidu.tieba.service.TiebaSyncService;
import com.baidu.tieba.service.UpdateInfoService;
/* loaded from: classes.dex */
public class LaunchStatic {
    static {
        initRegisterIntent();
        initRegisterTask();
        initRegisterListeners();
        pn();
        com.baidu.tbadk.n.af.Ha();
        com.baidu.tieba.tbadkCore.location.b.init();
        com.baidu.tieba.im.widget.c.atU();
        com.baidu.tieba.im.c.init();
        ImMemoryCacheRegister.aso();
        com.baidu.tieba.im.db.h.apA();
        com.baidu.tbadk.browser.i.init();
        o.init();
        com.baidu.tieba.wallet.i.init();
        com.baidu.tbadk.core.diskCache.a.init();
        com.baidu.tbadk.core.frameworkData.c.init();
        com.baidu.tbadk.plugin.d.init();
        com.baidu.tbadk.f.a.init();
    }

    private static void initRegisterIntent() {
        TbadkCoreApplication.m9getInst().RegisterIntent(UpdateDialogConfig.class, UpdateDialog.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(UpdateInfoServiceConfig.class, UpdateInfoService.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(SyncServiceConfig.class, TiebaSyncService.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
    }

    private static void initRegisterTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.TIEBA_FATAL_ERROR, new j());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tbadk.getUserInfo.b.EB().EC();
        com.baidu.tieba.tbadkCore.a.a.c(303039, ClientConfigSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CLIENT_CONFIG, com.baidu.tieba.tbadkCore.a.a.av(TbConfig.GET_PAY_CONFIG, 303039));
        tbHttpMessageTask.setResponsedClass(ClientConfigHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initRegisterListeners() {
        MessageManager.getInstance().registerListener(new k(CmdConfigCustom.UEXCEPTION_MESSAGE));
        MessageManager.getInstance().registerListener(new l(CmdConfigCustom.CMD_DEBUGLOG_SPECIFIED));
        if ("kuang".equals(TbConfig.getSubappType())) {
            MessageManager.getInstance().registerListener(new m(CmdConfigCustom.CMD_LOGIN_STATUS_KUANG));
        }
    }

    private static void pn() {
        com.baidu.adp.lib.f.c.fL().a(10, new com.baidu.tbadk.core.util.c.o(true, 10));
        com.baidu.adp.lib.f.c.fL().a(11, new com.baidu.tbadk.core.util.c.o(false, 10));
        com.baidu.adp.lib.f.c.fL().a(12, new com.baidu.tbadk.core.util.c.m(false, false, false, 12));
        com.baidu.adp.lib.f.c.fL().a(26, new com.baidu.tbadk.core.util.c.m(true, false, false, 26));
        com.baidu.adp.lib.f.c.fL().a(28, new com.baidu.tbadk.core.util.c.m(false, false, true, 26));
        com.baidu.adp.lib.f.c.fL().a(13, new com.baidu.tbadk.core.util.c.e(true, false, false, 13));
        com.baidu.adp.lib.f.c.fL().a(14, new com.baidu.tbadk.core.util.c.e(false, false, false, 13));
        com.baidu.adp.lib.f.c.fL().a(15, new com.baidu.tbadk.core.util.c.f(false, 15));
        com.baidu.adp.lib.f.c.fL().a(16, new com.baidu.tbadk.core.util.c.f(true, 16));
        com.baidu.adp.lib.f.c.fL().a(17, new com.baidu.tbadk.core.util.c.l(true, false, false, 17));
        com.baidu.adp.lib.f.c.fL().a(18, new com.baidu.tbadk.core.util.c.l(false, false, false, 17));
        com.baidu.adp.lib.f.c.fL().a(19, new com.baidu.tbadk.core.util.c.k(19));
        com.baidu.adp.lib.f.c.fL().a(21, new com.baidu.tbadk.core.util.c.g(21));
        com.baidu.adp.lib.f.c.fL().a(22, new com.baidu.tbadk.core.util.c.p(22));
        com.baidu.adp.lib.f.c.fL().a(24, new com.baidu.tbadk.core.util.c.j(24));
        com.baidu.adp.lib.f.c.fL().a(25, new com.baidu.tbadk.core.util.c.m(false, true, false, 26));
        com.baidu.adp.lib.f.c.fL().a(27, new com.baidu.tbadk.core.util.c.c(27));
        com.baidu.adp.lib.f.c.fL().a(29, new com.baidu.tbadk.core.util.c.n(true, 29));
        com.baidu.adp.lib.f.c.fL().a(30, new com.baidu.tbadk.core.util.c.b(true, false, false, 30));
        com.baidu.adp.lib.f.c.fL().a(31, new com.baidu.tbadk.core.util.c.b(false, false, false, 31));
        com.baidu.adp.lib.f.c.fL().a(32, new com.baidu.tbadk.core.util.c.i(32));
        com.baidu.adp.lib.f.c.fL().a(23, new com.baidu.tbadk.core.voice.a.c());
    }
}
