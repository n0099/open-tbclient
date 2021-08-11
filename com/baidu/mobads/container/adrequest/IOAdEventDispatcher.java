package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
/* loaded from: classes5.dex */
public interface IOAdEventDispatcher {
    void addEventListener(String str, IOAdEventListener iOAdEventListener);

    void dispatchEvent(IOAdEvent iOAdEvent);

    boolean hasEventListener(String str);

    void removeAllListeners();

    void removeEventListener(String str, IOAdEventListener iOAdEventListener);

    void removeEventListeners(String str);
}
