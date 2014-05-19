package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.framework.c.e {
    @Override // com.baidu.adp.framework.c.e
    public void a(String str, String str2, int i, Message<?> message) {
        int i2;
        int i3 = 0;
        if (message == null || !(message instanceof SocketMessage)) {
            i2 = 0;
        } else {
            i2 = message.getCmd();
            i3 = ((SocketMessage) message).getSquencedId();
        }
        TiebaStatic.imError(str, i2, i3, str2, i);
    }

    @Override // com.baidu.adp.framework.c.e
    public void a(String str, String str2, int i, ResponsedMessage<?> responsedMessage) {
        int i2;
        int i3 = 0;
        if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage() instanceof SocketMessage)) {
            i2 = 0;
        } else {
            i2 = responsedMessage.getCmd();
            i3 = ((SocketMessage) responsedMessage.getOrginalMessage()).getSquencedId();
        }
        TiebaStatic.imError(str, i2, i3, str2, i);
    }
}
