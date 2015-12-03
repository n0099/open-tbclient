package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class aa {
    public static <T> T a(ResponsedMessage<?> responsedMessage, Class<T> cls) {
        Object resultData;
        if (cls != null && (responsedMessage instanceof t) && (resultData = ((t) responsedMessage).getResultData()) != null && cls.isInstance(resultData)) {
            return cls.cast(resultData);
        }
        return null;
    }
}
