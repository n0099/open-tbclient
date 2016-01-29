package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
/* loaded from: classes.dex */
class c extends k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        if (socketMessage != null && socketMessage.getExtra() != null && (socketMessage.getExtra() instanceof NetMessage) && !com.baidu.tbadk.coreExtra.websocketBase.d.BF().el(socketMessage.getCmd())) {
            ((NetMessage) socketMessage.getExtra()).setSocketErrNo(com.baidu.tbadk.coreExtra.websocketBase.d.BF().BG());
            return null;
        }
        return socketMessage;
    }
}
