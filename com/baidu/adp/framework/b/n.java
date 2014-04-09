package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class n extends h<com.baidu.adp.framework.message.g, SocketMessageTask> {
    public n(int i) {
        super(202003);
        if (FrameHelper.a(202003) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
