package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class d extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            com.baidu.tbadk.coreExtra.websocketBase.d.BB().el(socketResponsedMessage.getCmd());
        }
        return socketResponsedMessage;
    }
}
