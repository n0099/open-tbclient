package com.baidu.live.adp.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
/* loaded from: classes7.dex */
public interface BdPageContext<T> {
    Context getContext();

    T getOrignalPage();

    Activity getPageActivity();

    Resources getResources();

    String getString(int i);

    BdUniqueId getUniqueId();

    void registerListener(int i, MessageListener<?> messageListener);

    void registerListener(int i, NetMessageListener netMessageListener);

    void registerListener(MessageListener<?> messageListener);

    void registerListener(NetMessageListener netMessageListener);

    void sendMessage(Message<?> message);

    void sendMessage(NetMessage netMessage);
}
