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
import com.baidu.tieba.c6;
import com.baidu.tieba.cc5;
import com.baidu.tieba.e6;
import com.baidu.tieba.ec5;
import com.baidu.tieba.f6;
import com.baidu.tieba.fc5;
import com.baidu.tieba.gc5;
import com.baidu.tieba.jp5;
import com.baidu.tieba.pj5;
import com.baidu.tieba.x5;
import com.baidu.tieba.yb5;
import com.baidu.tieba.z6;
import com.baidu.tieba.zs5;
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
            x5.h(TiebaIMConfig.url);
        } else {
            String h = yb5.f().h();
            if (TextUtils.isEmpty(h)) {
                x5.h(TiebaIMConfig.url);
            } else {
                x5.h(h);
            }
        }
        x5.e(TiebaIMConfig.wsExtensions);
        x5.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new f6() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3
            @Override // com.baidu.tieba.f6
            public void onLinkServiceDisconnect() {
                zs5.e().c(new zs5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.3.1
                    @Override // com.baidu.tieba.zs5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            pj5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        pj5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new e6() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.e6
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            z6.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            x5.g(socketReconnStratgy);
        }
        cc5.j().k();
        MessageManager.getInstance().getSocketClient().G(cc5.j());
        MessageManager.getInstance().addResponsedMessageRule(new gc5());
        try {
            c6.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        fc5.j().k();
        ec5.y().z();
        initSocket();
        jp5.a().r(System.currentTimeMillis() - currentTimeMillis);
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
