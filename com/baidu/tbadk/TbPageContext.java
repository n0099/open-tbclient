package com.baidu.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import c.a.e.a.f;
import c.a.e.c.g.a;
import c.a.o0.s.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
/* loaded from: classes6.dex */
public interface TbPageContext<T> extends f<T> {
    @Override // c.a.e.a.f
    /* synthetic */ Context getContext();

    c getLayoutMode();

    @Override // c.a.e.a.f
    /* synthetic */ T getOrignalPage();

    @Override // c.a.e.a.f
    /* synthetic */ Activity getPageActivity();

    @Override // c.a.e.a.f
    /* synthetic */ Resources getResources();

    @Override // c.a.e.a.f
    /* synthetic */ String getString(int i2);

    @Override // c.a.e.a.f
    /* synthetic */ BdUniqueId getUniqueId();

    /* synthetic */ void registerListener(int i2, a aVar);

    /* synthetic */ void registerListener(int i2, MessageListener<?> messageListener);

    /* synthetic */ void registerListener(a aVar);

    @Override // c.a.e.a.f
    /* synthetic */ void registerListener(MessageListener<?> messageListener);

    @Override // c.a.e.a.f
    /* synthetic */ void sendMessage(Message<?> message);

    /* synthetic */ void sendMessage(NetMessage netMessage);

    void showToast(int i2);

    void showToast(int i2, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener);
}
