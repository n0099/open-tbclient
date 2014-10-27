package com.baidu.adp.framework.listener;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class CustomMessageListener extends MessageListener<CustomResponsedMessage<?>> {
    public CustomMessageListener(int i) {
        super(i);
    }

    public CustomMessageListener(int i, boolean z) {
        super(i, z);
    }
}
