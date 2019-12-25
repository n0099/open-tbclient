package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.live.adp.framework.MessageConfig;
/* loaded from: classes.dex */
public class d {
    public static void init() {
        k kVar = new k(0) { // from class: com.baidu.tbadk.core.frameworkData.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            /* renamed from: d */
            public SocketMessage b(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                if (socketMessage != null && socketMessage.getExtra() != null && (socketMessage.getExtra() instanceof NetMessage) && !com.baidu.tbadk.coreExtra.d.c.aKB().isAPIAvailableNow(socketMessage.getCmd())) {
                    ((NetMessage) socketMessage.getExtra()).setSocketErrNo(com.baidu.tbadk.coreExtra.d.c.aKB().getLongConnectionFailedErrno());
                    return null;
                }
                return socketMessage;
            }
        };
        kVar.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().addMessageRule(kVar);
        MessageManager.getInstance().addResponsedMessageRule(new j(0) { // from class: com.baidu.tbadk.core.frameworkData.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.g
            /* renamed from: d */
            public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    com.baidu.tbadk.coreExtra.d.c.aKB().onAPISuccessed(socketResponsedMessage.getCmd());
                }
                return socketResponsedMessage;
            }
        });
        CustomMessageListener customMessageListener = new CustomMessageListener(MessageConfig.NET_AUTO_SOCKET_FAIL) { // from class: com.baidu.tbadk.core.frameworkData.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    com.baidu.tbadk.coreExtra.d.c.aKB().onAPIFailed(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        customMessageListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}
