package com.baidu.live.adp.framework.controller;

import com.baidu.live.adp.framework.FrameHelper;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes2.dex */
public abstract class HttpResponsedRule extends ResponsedMessageRule<HttpResponsedMessage> {
    public HttpResponsedRule(int i) {
        super(i);
        if (i != 0 && FrameHelper.getMessageType(i) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
