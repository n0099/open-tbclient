package com.baidu.adp.framework.a;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class n extends h<SocketMessage, SocketMessageTask> {
    public n(int i) {
        super(i);
        if (i != 0 && FrameHelper.a(i) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
