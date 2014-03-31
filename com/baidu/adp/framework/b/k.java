package com.baidu.adp.framework.b;

import com.baidu.adp.framework.FrameHelper;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class k extends f<com.baidu.adp.framework.message.g, com.baidu.adp.framework.task.c> {
    public k(int i) {
        super(202003);
        if (FrameHelper.a(202003) != FrameHelper.TYPE.SOCKET) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
