package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class m extends i<SocketResponsedMessage> {
    public m(int i) {
        super(i);
        if (i != 0 && FrameHelper.a(i) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
