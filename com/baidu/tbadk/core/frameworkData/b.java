package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.n;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.coreExtra.d.g;
/* loaded from: classes.dex */
class b extends n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.h
    public SocketMessage a(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        if (socketMessage != null && socketMessage.getExtra() != null && (socketMessage.getExtra() instanceof NetMessage) && !g.a().a(socketMessage.getCmd())) {
            return null;
        }
        return socketMessage;
    }
}
