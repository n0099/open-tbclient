package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class b {
    private a ZU;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_TOKEN, 309608) { // from class: com.baidu.tbadk.BdToken.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                b.this.b(false, null);
            } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                b.this.b(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                b.this.b(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, f fVar);
    }

    public b() {
        registerTask();
        registerListener();
    }

    public void load(String str) {
        if (!this.isLoading) {
            this.isLoading = true;
            GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
            getTokenRequestMessage.setToken(str);
            MessageManager.getInstance().sendMessage(getTokenRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, f fVar) {
        if (this.ZU != null) {
            this.ZU.a(z, fVar);
        }
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309608, GetTokenSocketResponsedMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309608, CmdConfigHttp.CMD_GET_TOKEN, TbConfig.URL_GET_TOKEN, GetTokenHttpResponsedMessage.class, false, false, false, false);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.mNetMessageListener);
    }

    public void a(a aVar) {
        this.ZU = aVar;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mNetMessageListener);
    }
}
