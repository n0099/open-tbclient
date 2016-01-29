package com.baidu.tbadk.core.util;

import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
public class z {
    public static <T> T a(ResponsedMessage<?> responsedMessage, Class<T> cls) {
        Object resultData;
        if (cls != null && (responsedMessage instanceof s) && (resultData = ((s) responsedMessage).getResultData()) != null && cls.isInstance(resultData)) {
            return cls.cast(resultData);
        }
        return null;
    }
}
