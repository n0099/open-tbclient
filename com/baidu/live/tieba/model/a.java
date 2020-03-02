package com.baidu.live.tieba.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private NetMessageListener aAG;

    /* renamed from: com.baidu.live.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0099a {
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void zX() {
        MessageManager.getInstance().removeMessage(1003325, getUniqueId());
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_CHECK_REAL_NAME, getUniqueId());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aAG);
    }
}
