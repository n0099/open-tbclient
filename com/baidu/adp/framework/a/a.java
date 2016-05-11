package com.baidu.adp.framework.a;

import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class a extends g<CustomResponsedMessage<?>> {
    public a(int i) {
        super(i);
        if (i != 0 && FrameHelper.s(i) != FrameHelper.TYPE.CUSTOM) {
            throw new InvalidParameterException("cmd invalid");
        }
    }
}
