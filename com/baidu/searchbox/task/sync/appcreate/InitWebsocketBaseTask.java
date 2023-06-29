package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.bc;
import com.baidu.tieba.ct5;
import com.baidu.tieba.lg5;
import com.baidu.tieba.oa;
import com.baidu.tieba.pg5;
import com.baidu.tieba.pw5;
import com.baidu.tieba.rg5;
import com.baidu.tieba.sg5;
import com.baidu.tieba.ta;
import com.baidu.tieba.tg5;
import com.baidu.tieba.ub;
import com.baidu.tieba.va;
import com.baidu.tieba.wa;
import com.baidu.tieba.wm5;
import com.baidu.tieba.wt5;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class InitWebsocketBaseTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitWebsocketBase";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        bc.b().a("socket", new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
            @Override // java.lang.Runnable
            public void run() {
                InitWebsocketBaseTask.this.initWebsocketBase();
            }
        });
    }

    public static void initSocket() {
        wt5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.e(false);
        registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            oa.h(TiebaIMConfig.url);
        } else {
            String h = lg5.f().h();
            if (TextUtils.isEmpty(h)) {
                oa.h(TiebaIMConfig.url);
            } else {
                oa.h(h);
            }
        }
        oa.e(TiebaIMConfig.wsExtensions);
        oa.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new wa() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3
            @Override // com.baidu.tieba.wa
            public void onLinkServiceDisconnect() {
                pw5.e().c(new pw5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.pw5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            wm5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        wm5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new va() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.va
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            ub.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            oa.g(socketReconnStratgy);
        }
        pg5.j().k();
        MessageManager.getInstance().getSocketClient().G(pg5.j());
        MessageManager.getInstance().addResponsedMessageRule(new tg5());
        try {
            ta.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        sg5.j().k();
        rg5.y().z();
        initSocket();
        ct5.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    public static wt5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        wt5 wt5Var = new wt5(i);
        wt5Var.setResponsedClass(cls);
        wt5Var.h(z);
        wt5Var.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(wt5Var);
        return wt5Var;
    }
}
