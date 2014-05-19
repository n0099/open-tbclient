package com.baidu.adp.framework.a;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class f extends h<HttpMessage, HttpMessageTask> {
    public f(int i) {
        super(i);
        if (i != 0 && FrameHelper.a(i) != FrameHelper.TYPE.HTTP) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
