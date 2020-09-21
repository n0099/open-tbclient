package com.baidu.live.adp.framework.listener;

import com.baidu.live.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes4.dex */
public abstract class SocketMessageListener extends MessageListener<SocketResponsedMessage> {
    public SocketMessageListener(int i) {
        super(i);
    }

    public SocketMessageListener(int i, boolean z) {
        super(i, z);
    }
}
