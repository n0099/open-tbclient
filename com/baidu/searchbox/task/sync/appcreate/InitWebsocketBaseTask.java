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
import com.baidu.tieba.ab;
import com.baidu.tieba.cn5;
import com.baidu.tieba.fb;
import com.baidu.tieba.gc;
import com.baidu.tieba.hb;
import com.baidu.tieba.hb5;
import com.baidu.tieba.ib;
import com.baidu.tieba.im5;
import com.baidu.tieba.lb5;
import com.baidu.tieba.nb5;
import com.baidu.tieba.ob5;
import com.baidu.tieba.pb5;
import com.baidu.tieba.qg5;
import com.baidu.tieba.vp5;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
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
        initWebsocketBase();
    }

    public static void initSocket() {
        cn5 registerImScoketTask = registerImScoketTask(1001, ResponseOnlineMessage.class, false);
        registerImScoketTask.setPriority(-3);
        registerImScoketTask.e(false);
        registerImScoketTask.f(SocketMessageTask.DupLicateMode.REMOVE_ME);
        registerImScoketTask.setNeedEncrypt(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("Content-Type", "application/octet-stream"));
        arrayList.add(new BasicNameValuePair("cuid", TbadkCoreApplication.getUniqueIdentifier()));
        new UseHttpdnsSdkSwitch();
        if (UseHttpdnsSdkSwitch.isOn()) {
            ab.h(TiebaIMConfig.url);
        } else {
            String h = hb5.f().h();
            if (TextUtils.isEmpty(h)) {
                ab.h(TiebaIMConfig.url);
            } else {
                ab.h(h);
            }
        }
        ab.e(TiebaIMConfig.wsExtensions);
        ab.f(arrayList);
        BdSocketDaemonService.setLinkServiceDisconnectCallBack(new ib() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2
            @Override // com.baidu.tieba.ib
            public void onLinkServiceDisconnect() {
                vp5.e().c(new vp5.b() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.2.1
                    @Override // com.baidu.tieba.vp5.b
                    public void onResult(boolean z) {
                        if (!z) {
                            qg5.b(0, 0, 0, 1, 8);
                            BdSocketLinkService.startService(false, "restart");
                        }
                    }
                });
            }
        });
        BdSocketLinkService.init();
        qg5.b(0, 0, 0, 1, 9);
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            BdSocketLinkService.startService(false, "TiebaImApplication init");
        }
    }

    private void initWebsocketBase() {
        long currentTimeMillis = System.currentTimeMillis();
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.setCanOpenWebSocket(new hb() { // from class: com.baidu.searchbox.task.sync.appcreate.InitWebsocketBaseTask.1
            @Override // com.baidu.tieba.hb
            public boolean canOpenWebSocket() {
                return !TbadkCoreApplication.getInst().isExitAppCloseWebSocket();
            }
        });
        int[] imTimeOut = TbadkCoreApplication.getInst().getImTimeOut();
        if (imTimeOut != null && imTimeOut.length == 3) {
            gc.c().d(imTimeOut[0], imTimeOut[1], imTimeOut[2]);
        }
        int[] socketReconnStratgy = TbadkCoreApplication.getInst().getSocketReconnStratgy();
        if (socketReconnStratgy != null && socketReconnStratgy.length > 0) {
            ab.g(socketReconnStratgy);
        }
        lb5.j().k();
        MessageManager.getInstance().getSocketClient().G(lb5.j());
        MessageManager.getInstance().addResponsedMessageRule(new pb5());
        try {
            fb.a().d(TiebaIMConfig.getRSAPublicKey());
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        ob5.j().k();
        nb5.y().z();
        initSocket();
        im5.b().s(System.currentTimeMillis() - currentTimeMillis);
    }

    public static cn5 registerImScoketTask(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        cn5 cn5Var = new cn5(i);
        cn5Var.setResponsedClass(cls);
        cn5Var.h(z);
        cn5Var.setParallel(TiebaIMConfig.getParallel());
        MessageManager.getInstance().registerTask(cn5Var);
        return cn5Var;
    }
}
