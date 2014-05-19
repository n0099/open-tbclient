package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.framework.a.m;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.d.g;
/* loaded from: classes.dex */
class c extends m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.i
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null) {
            g.a().c(socketResponsedMessage.getCmd());
        }
        return socketResponsedMessage;
    }
}
