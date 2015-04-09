package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.k;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.coreExtra.websocketBase.h;
/* loaded from: classes.dex */
class b extends k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.f
    /* renamed from: d */
    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        if (socketMessage != null && socketMessage.getExtra() != null && (socketMessage.getExtra() instanceof NetMessage) && !h.xC().de(socketMessage.getCmd())) {
            return null;
        }
        return socketMessage;
    }
}
