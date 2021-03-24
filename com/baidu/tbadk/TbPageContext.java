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
import d.b.b.a.f;
import d.b.b.c.g.a;
import d.b.h0.r.c;
/* loaded from: classes.dex */
public interface TbPageContext<T> extends f<T> {
    @Override // d.b.b.a.f
    /* synthetic */ Context getContext();

    c getLayoutMode();

    @Override // d.b.b.a.f
    /* synthetic */ T getOrignalPage();

    @Override // d.b.b.a.f
    /* synthetic */ Activity getPageActivity();

    @Override // d.b.b.a.f
    /* synthetic */ Resources getResources();

    @Override // d.b.b.a.f
    /* synthetic */ String getString(int i);

    @Override // d.b.b.a.f
    /* synthetic */ BdUniqueId getUniqueId();

    /* synthetic */ void registerListener(int i, MessageListener<?> messageListener);

    /* synthetic */ void registerListener(int i, a aVar);

    @Override // d.b.b.a.f
    /* synthetic */ void registerListener(MessageListener<?> messageListener);

    /* synthetic */ void registerListener(a aVar);

    @Override // d.b.b.a.f
    /* synthetic */ void sendMessage(Message<?> message);

    /* synthetic */ void sendMessage(NetMessage netMessage);

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener);
}
