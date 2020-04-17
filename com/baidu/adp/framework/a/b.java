package com.baidu.adp.framework.a;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b extends f<CustomMessage<?>, CustomMessageTask> {
    public b(int i) {
        super(i);
        if (i != 0 && FrameHelper.O(i) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
