package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class c extends g<HttpResponsedMessage> {
    public c(int i) {
        super(i);
        if (i != 0 && FrameHelper.O(i) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
