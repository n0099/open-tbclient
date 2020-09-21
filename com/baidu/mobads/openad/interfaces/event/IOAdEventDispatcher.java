package com.baidu.mobads.openad.interfaces.event;
/* loaded from: classes3.dex */
public interface IOAdEventDispatcher {
    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void dispatchEvent(IOAdEvent iOAdEvent);

    boolean hasEventListener(String str);

    void removeAllListeners();

    void removeEventListener(String str, IOAdEventListener iOAdEventListener);

    void removeEventListeners(String str);
}
