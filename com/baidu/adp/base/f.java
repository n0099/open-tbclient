package com.baidu.adp.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
/* loaded from: classes.dex */
public interface f<T> {
    Context getContext();

    T getOrignalPage();

    Activity getPageActivity();

    Resources getResources();

    String getString(int i);

    BdUniqueId getUniqueId();

    void registerListener(int i, MessageListener<?> messageListener);

    void registerListener(MessageListener<?> messageListener);

    void registerListener(com.baidu.adp.framework.listener.a aVar);

    void sendMessage(Message<?> message);

    void sendMessage(NetMessage netMessage);
}
