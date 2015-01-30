package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.websocketBase.h;
/* loaded from: classes.dex */
class c extends j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            h.ul().de(socketResponsedMessage.getCmd());
        }
        return socketResponsedMessage;
    }
}
