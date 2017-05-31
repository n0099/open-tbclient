package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
class f extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            com.baidu.tbadk.coreExtra.websocketBase.d.Bl().em(socketResponsedMessage.getCmd());
        }
        return socketResponsedMessage;
    }
}
