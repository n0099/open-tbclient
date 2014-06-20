package com.baidu.adp.framework.a;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class k extends f<SocketMessage, SocketMessageTask> {
    public k(int i) {
        super(i);
        if (i != 0 && FrameHelper.a(i) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
