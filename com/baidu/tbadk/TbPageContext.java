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
import com.baidu.tieba.a9;
import com.baidu.tieba.hv4;
import com.baidu.tieba.za;
/* loaded from: classes3.dex */
public interface TbPageContext<T> extends a9<T> {
    @Override // com.baidu.tieba.a9
    /* synthetic */ Context getContext();

    hv4 getLayoutMode();

    @Override // com.baidu.tieba.a9
    /* synthetic */ T getOrignalPage();

    @Override // com.baidu.tieba.a9
    /* synthetic */ Activity getPageActivity();

    @Override // com.baidu.tieba.a9
    /* synthetic */ Resources getResources();

    @Override // com.baidu.tieba.a9
    /* synthetic */ String getString(int i);

    @Override // com.baidu.tieba.a9
    /* synthetic */ BdUniqueId getUniqueId();

    /* synthetic */ void registerListener(int i, MessageListener<?> messageListener);

    /* synthetic */ void registerListener(int i, za zaVar);

    @Override // com.baidu.tieba.a9
    /* synthetic */ void registerListener(MessageListener<?> messageListener);

    /* synthetic */ void registerListener(za zaVar);

    @Override // com.baidu.tieba.a9
    /* synthetic */ void sendMessage(Message<?> message);

    /* synthetic */ void sendMessage(NetMessage netMessage);

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener);
}
