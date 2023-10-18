package com.baidu.searchbox.task.sync.appcreate;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketDaemonService;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.tieba.db5;
import com.baidu.tieba.er5;
import com.baidu.tieba.h5;
import com.baidu.tieba.hb5;
import com.baidu.tieba.j6;
import com.baidu.tieba.jb5;
import com.baidu.tieba.kb5;
import com.baidu.tieba.lb5;
import com.baidu.tieba.m5;
import com.baidu.tieba.o5;
import com.baidu.tieba.on5;
import com.baidu.tieba.p5;
import com.baidu.tieba.zh5;
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
        IdleHandlerManager.getInstance().addOrRunTask(Logger.SOCKET_TYPE, new Runnable() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
            @Override // java.lang.Runnable
            public void run() {
                InitWebsocketBaseTask.this.initWebsocketBase();
            }
        });
    }

    public static void initSocket() {
        TbSocketMessageTask registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.setCanRetry(false);
        registerImScoketTask.setDupLicateMode(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            h5.h(TiebaIMConfig.url);
        } else {
            String h = db5.f().h();
            if (TextUtils.isEmpty(h)) {
                h5.h(TiebaIMConfig.url);
            } else {
                h5.h(h);
            }
        }
        h5.e(TiebaIMConfig.wsExtensions);
        h5.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new p5() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3
            @Override // com.baidu.tieba.p5
            public void onLinkServiceDisconnect() {
                er5.e().c(new er5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.er5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            zh5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        zh5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new o5() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.o5
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            j6.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            h5.g(socketReconnStratgy);
        }
        hb5.j().k();
        MessageManager.getInstance().getSocketClient().G(hb5.j());
        MessageManager.getInstance().addResponsedMessageRule(new lb5());
        try {
            m5.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        kb5.j().k();
        jb5.y().z();
        initSocket();
        on5.a().r(System.currentTimeMillis() - currentTimeMillis);
    }

    public static TbSocketMessageTask registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(i);
        tbSocketMessageTask.setResponsedClass(cls);
        tbSocketMessageTask.setNeedCompress(z);
        tbSocketMessageTask.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(tbSocketMessageTask);
        return tbSocketMessageTask;
    }
}
