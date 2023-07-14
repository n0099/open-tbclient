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
import com.baidu.tieba.av5;
import com.baidu.tieba.bc;
import com.baidu.tieba.gu5;
import com.baidu.tieba.ih5;
import com.baidu.tieba.mh5;
import com.baidu.tieba.oa;
import com.baidu.tieba.oh5;
import com.baidu.tieba.ph5;
import com.baidu.tieba.qh5;
import com.baidu.tieba.ta;
import com.baidu.tieba.tx5;
import com.baidu.tieba.ub;
import com.baidu.tieba.va;
import com.baidu.tieba.vn5;
import com.baidu.tieba.wa;
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
        av5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
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
            String h = ih5.f().h();
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
                tx5.e().c(new tx5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.tx5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            vn5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        vn5.b(0, 0, 0, 1, 9);
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
        mh5.j().k();
        MessageManager.getInstance().getSocketClient().G(mh5.j());
        MessageManager.getInstance().addResponsedMessageRule(new qh5());
        try {
            ta.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        ph5.j().k();
        oh5.y().z();
        initSocket();
        gu5.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    public static av5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        av5 av5Var = new av5(i);
        av5Var.setResponsedClass(cls);
        av5Var.h(z);
        av5Var.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(av5Var);
        return av5Var;
    }
}
