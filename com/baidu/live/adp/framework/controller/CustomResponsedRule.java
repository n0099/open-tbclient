package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes4.dex */
public abstract class CustomResponsedRule extends ResponsedMessageRule<CustomResponsedMessage<?>> {
    public CustomResponsedRule(int i) {
        super(i);
        if (i != 0 && FrameHelper.getMessageType(i) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
