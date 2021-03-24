package com.baidu.mobads.openad.interfaces.event;

import java.util.Map;
/* loaded from: classes2.dex */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
