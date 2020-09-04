package com.baidu.tbadk;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.a.f;
import com.baidu.tbadk.lcs.a;
import org.apache.http.conn.params.ConnRoutePNames;
/* loaded from: classes.dex */
public class SocketStatic {
    public static String Tag = "tag";

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.SocketStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof NetWorkChangedMessage) && Build.VERSION.SDK_INT >= 24 && TbadkCoreApplication.getInst().isMainProcess(true) && j.isNetWorkAvailable()) {
                    if (BdSocketLinkService.isClose()) {
                        a.d(0, 0, 0, 1, 6);
                        BdSocketLinkService.setAvailable(true);
                        BdSocketLinkService.startService(false, "net succ");
                    }
                    synchronized (f.class) {
                        f.elN.removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                        f.proxyHost = null;
                    }
                }
            }
        });
    }
}
