package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.SocketMessage;
import com.baidu.live.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes7.dex */
public abstract class SocketRule extends MessageRule<SocketMessage, SocketMessageTask> {
    public SocketRule(int i) {
        super(i);
        if (i != 0 && FrameHelper.getMessageType(i) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
