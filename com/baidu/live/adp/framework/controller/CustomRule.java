package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public abstract class CustomRule extends MessageRule<CustomMessage<?>, CustomMessageTask> {
    public CustomRule(int i) {
        super(i);
        if (i != 0 && FrameHelper.getMessageType(i) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
