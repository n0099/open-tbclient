package com.baidu.tbadk;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import d.a.c.e.p.j;
import d.a.i0.c0.a;
import org.apache.http.conn.params.ConnRoutePNames;
/* loaded from: classes3.dex */
public class SocketStatic {
    public static String Tag = "tag";

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.SocketStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof NetWorkChangedMessage) && Build.VERSION.SDK_INT >= 24 && TbadkCoreApplication.getInst().isMainProcess(true) && j.z()) {
                    if (BdSocketLinkService.isClose()) {
                        a.b(0, 0, 0, 1, 6);
                        BdSocketLinkService.setAvailable(true);
                        BdSocketLinkService.startService(false, "net succ");
                    }
                    synchronized (ImgHttpClient.class) {
                        ImgHttpClient.mHttpParams.removeParameter(ConnRoutePNames.DEFAULT_PROXY);
                        ImgHttpClient.proxyHost = null;
                    }
                }
            }
        });
    }
}
