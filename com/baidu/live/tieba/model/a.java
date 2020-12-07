package com.baidu.live.tieba.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private NetMessageListener bFF;

    /* renamed from: com.baidu.live.tieba.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0223a {
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Vg() {
        MessageManager.getInstance().removeMessage(1003325, getUniqueId());
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_CHECK_REAL_NAME, getUniqueId());
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.bFF);
    }
}
