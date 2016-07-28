package com.baidu.tbadk.core.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
/* loaded from: classes.dex */
class a {

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tbadk.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0034a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static void sendMessage(Message<?> message) {
            MessageManager.getInstance().sendMessage(message);
        }
    }
}
