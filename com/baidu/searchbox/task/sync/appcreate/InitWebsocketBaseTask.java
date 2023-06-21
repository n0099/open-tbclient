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
import com.baidu.tieba.ac;
import com.baidu.tieba.hg5;
import com.baidu.tieba.kw5;
import com.baidu.tieba.lg5;
import com.baidu.tieba.na;
import com.baidu.tieba.ng5;
import com.baidu.tieba.og5;
import com.baidu.tieba.pg5;
import com.baidu.tieba.rt5;
import com.baidu.tieba.sa;
import com.baidu.tieba.sm5;
import com.baidu.tieba.tb;
import com.baidu.tieba.ua;
import com.baidu.tieba.va;
import com.baidu.tieba.xs5;
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
        ac.b().a("socket", new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
            @Override // java.lang.Runnable
            public void run() {
                InitWebsocketBaseTask.this.initWebsocketBase();
            }
        });
    }

    public static void initSocket() {
        rt5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.e(false);
        registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            na.h(TiebaIMConfig.url);
        } else {
            String h = hg5.f().h();
            if (TextUtils.isEmpty(h)) {
                na.h(TiebaIMConfig.url);
            } else {
                na.h(h);
            }
        }
        na.e(TiebaIMConfig.wsExtensions);
        na.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new va() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3
            @Override // com.baidu.tieba.va
            public void onLinkServiceDisconnect() {
                kw5.e().c(new kw5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.kw5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            sm5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        sm5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new ua() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.ua
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            tb.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            na.g(socketReconnStratgy);
        }
        lg5.j().k();
        MessageManager.getInstance().getSocketClient().G(lg5.j());
        MessageManager.getInstance().addResponsedMessageRule(new pg5());
        try {
            sa.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        og5.j().k();
        ng5.y().z();
        initSocket();
        xs5.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    public static rt5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        rt5 rt5Var = new rt5(i);
        rt5Var.setResponsedClass(cls);
        rt5Var.h(z);
        rt5Var.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(rt5Var);
        return rt5Var;
    }
}
