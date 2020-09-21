package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes4.dex */
public abstract class HttpRule extends MessageRule<HttpMessage, HttpMessageTask> {
    public HttpRule(int i) {
        super(i);
        if (i != 0 && FrameHelper.getMessageType(i) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
