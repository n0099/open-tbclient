package com.baidu.tbadk.BdToken;

import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class e {
    private a akI;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a mNetMessageListener = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_TOKEN, 309608) { // from class: com.baidu.tbadk.BdToken.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e.this.isLoading = false;
            if (responsedMessage == null || responsedMessage.getError() != 0) {
                e.this.b(false, null);
            } else if (responsedMessage instanceof GetTokenSocketResponsedMessage) {
                e.this.b(true, ((GetTokenSocketResponsedMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof GetTokenHttpResponsedMessage) {
                e.this.b(true, ((GetTokenHttpResponsedMessage) responsedMessage).getData());
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, p pVar);
    }

    public e() {
        registerTask();
        registerListener();
    }

    public void load(String str) {
        if (!this.isLoading) {
            this.isLoading = true;
            GetTokenRequestMessage getTokenRequestMessage = new GetTokenRequestMessage();
            getTokenRequestMessage.setToken(Base64.encodeToString(str.getBytes(), 2));
            getTokenRequestMessage.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
            MessageManager.getInstance().sendMessage(getTokenRequestMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, p pVar) {
        if (this.akI != null) {
            this.akI.a(z, pVar);
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
        this.akI = aVar;
    }
}
