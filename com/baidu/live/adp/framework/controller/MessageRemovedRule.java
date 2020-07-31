package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.BdUniqueId;
/* loaded from: classes4.dex */
public abstract class MessageRemovedRule extends Rule<byte[]> {
    public abstract void process(int i, BdUniqueId bdUniqueId);

    public abstract void process(BdUniqueId bdUniqueId);

    public MessageRemovedRule(int i) {
        super(i);
    }
}
