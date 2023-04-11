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
import com.baidu.tieba.bb5;
import com.baidu.tieba.da;
import com.baidu.tieba.db5;
import com.baidu.tieba.eb5;
import com.baidu.tieba.fb5;
import com.baidu.tieba.fn5;
import com.baidu.tieba.hg5;
import com.baidu.tieba.ia;
import com.baidu.tieba.jb;
import com.baidu.tieba.ka;
import com.baidu.tieba.la;
import com.baidu.tieba.lm5;
import com.baidu.tieba.qb;
import com.baidu.tieba.xa5;
import com.baidu.tieba.yp5;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
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
        qb.b().a("socket", new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
            @Override // java.lang.Runnable
            public void run() {
                InitWebsocketBaseTask.this.initWebsocketBase();
            }
        });
    }

    public static void initSocket() {
        fn5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.e(false);
        registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            da.h(TiebaIMConfig.url);
        } else {
            String h = xa5.f().h();
            if (TextUtils.isEmpty(h)) {
                da.h(TiebaIMConfig.url);
            } else {
                da.h(h);
            }
        }
        da.e(TiebaIMConfig.wsExtensions);
        da.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new la() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3
            @Override // com.baidu.tieba.la
            public void onLinkServiceDisconnect() {
                yp5.e().c(new yp5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.yp5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            hg5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        hg5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new ka() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.ka
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            jb.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            da.g(socketReconnStratgy);
        }
        bb5.j().k();
        MessageManager.getInstance().getSocketClient().G(bb5.j());
        MessageManager.getInstance().addResponsedMessageRule(new fb5());
        try {
            ia.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        eb5.j().k();
        db5.y().z();
        initSocket();
        lm5.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    public static fn5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        fn5 fn5Var = new fn5(i);
        fn5Var.setResponsedClass(cls);
        fn5Var.h(z);
        fn5Var.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(fn5Var);
        return fn5Var;
    }
}
