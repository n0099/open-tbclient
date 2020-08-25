package com.baidu.tbadk.core.hybrid;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
/* loaded from: classes2.dex */
class a {

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.baidu.tbadk.core.hybrid.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0539a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static void sendMessage(Message<?> message) {
            MessageManager.getInstance().sendMessage(message);
        }
    }
}
