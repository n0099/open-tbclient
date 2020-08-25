package com.baidu.live.tbadk.core.frameworkdata;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.controller.SocketResponsedRule;
import com.baidu.live.adp.framework.controller.SocketRule;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import com.baidu.live.tbadk.coreextra.websocketbase.LongConnectionAPIManager;
@Deprecated
/* loaded from: classes7.dex */
public class NetAutoPolicyStaticInit {
    public static void init() {
        SocketRule socketRule = new SocketRule(0) { // from class: com.baidu.live.tbadk.core.frameworkdata.NetAutoPolicyStaticInit.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.controller.MessageRule
            public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                if (socketMessage != null && socketMessage.getExtra() != null && (socketMessage.getExtra() instanceof NetMessage) && !LongConnectionAPIManager.getInstance().isAPIAvailableNow(socketMessage.getCmd())) {
                    ((NetMessage) socketMessage.getExtra()).setSocketErrNo(LongConnectionAPIManager.getInstance().getLongConnectionFailedErrno());
                    return null;
                }
                return socketMessage;
            }
        };
        socketRule.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().addMessageRule(socketRule);
        MessageManager.getInstance().addResponsedMessageRule(new SocketResponsedRule(0) { // from class: com.baidu.live.tbadk.core.frameworkdata.NetAutoPolicyStaticInit.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.controller.ResponsedMessageRule
            public SocketResponsedMessage process(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    LongConnectionAPIManager.getInstance().onAPISuccessed(socketResponsedMessage.getCmd());
                }
                return socketResponsedMessage;
            }
        });
        CustomMessageListener customMessageListener = new CustomMessageListener(MessageConfig.NET_AUTO_SOCKET_FAIL) { // from class: com.baidu.live.tbadk.core.frameworkdata.NetAutoPolicyStaticInit.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                    LongConnectionAPIManager.getInstance().onAPIFailed(((Integer) customResponsedMessage.getData()).intValue());
                }
            }
        };
        customMessageListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}
