package com.baidu.adp.framework.listener;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public abstract class CustomMessageListener extends MessageListener<CustomResponsedMessage<?>> {
    public CustomMessageListener(int i2) {
        super(i2);
    }

    public CustomMessageListener(int i2, boolean z) {
        super(i2, z);
    }
}
