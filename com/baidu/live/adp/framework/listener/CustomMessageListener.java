package com.baidu.live.adp.framework.listener;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes10.dex */
public abstract class CustomMessageListener extends MessageListener<CustomResponsedMessage<?>> {
    public CustomMessageListener(int i) {
        super(i);
    }

    public CustomMessageListener(int i, boolean z) {
        super(i, z);
    }
}
