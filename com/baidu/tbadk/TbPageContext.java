package com.baidu.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import d.a.c.a.f;
import d.a.c.c.g.a;
import d.a.r0.r.c;
/* loaded from: classes4.dex */
public interface TbPageContext<T> extends f<T> {
    @Override // d.a.c.a.f
    /* synthetic */ Context getContext();

    c getLayoutMode();

    @Override // d.a.c.a.f
    /* synthetic */ T getOrignalPage();

    @Override // d.a.c.a.f
    /* synthetic */ Activity getPageActivity();

    @Override // d.a.c.a.f
    /* synthetic */ Resources getResources();

    @Override // d.a.c.a.f
    /* synthetic */ String getString(int i2);

    @Override // d.a.c.a.f
    /* synthetic */ BdUniqueId getUniqueId();

    /* synthetic */ void registerListener(int i2, MessageListener<?> messageListener);

    /* synthetic */ void registerListener(int i2, a aVar);

    @Override // d.a.c.a.f
    /* synthetic */ void registerListener(MessageListener<?> messageListener);

    /* synthetic */ void registerListener(a aVar);

    @Override // d.a.c.a.f
    /* synthetic */ void sendMessage(Message<?> message);

    /* synthetic */ void sendMessage(NetMessage netMessage);

    void showToast(int i2);

    void showToast(int i2, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener);
}
