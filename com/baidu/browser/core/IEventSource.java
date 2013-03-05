package com.baidu.browser.core;

import android.os.Message;
/* loaded from: classes.dex */
public interface IEventSource {
    void fireEvent(String str, Message message);

    void fireUIEvent(String str, Message message);

    void onReceiveEvent(String str, Message message);

    void registEvent(String str);

    void setEventListener(IEventListener iEventListener);
}
