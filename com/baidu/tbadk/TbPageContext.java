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
import com.repackage.b9;
import com.repackage.tm4;
import com.repackage.wa;
/* loaded from: classes2.dex */
public interface TbPageContext<T> extends b9<T> {
    @Override // com.repackage.b9
    /* synthetic */ Context getContext();

    tm4 getLayoutMode();

    @Override // com.repackage.b9
    /* synthetic */ T getOrignalPage();

    @Override // com.repackage.b9
    /* synthetic */ Activity getPageActivity();

    @Override // com.repackage.b9
    /* synthetic */ Resources getResources();

    @Override // com.repackage.b9
    /* synthetic */ String getString(int i);

    @Override // com.repackage.b9
    /* synthetic */ BdUniqueId getUniqueId();

    /* synthetic */ void registerListener(int i, MessageListener<?> messageListener);

    /* synthetic */ void registerListener(int i, wa waVar);

    @Override // com.repackage.b9
    /* synthetic */ void registerListener(MessageListener<?> messageListener);

    /* synthetic */ void registerListener(wa waVar);

    @Override // com.repackage.b9
    /* synthetic */ void sendMessage(Message<?> message);

    /* synthetic */ void sendMessage(NetMessage netMessage);

    void showToast(int i);

    void showToast(int i, boolean z);

    void showToast(String str);

    void showToast(String str, boolean z);

    void startAnimatable(Animatable animatable);

    void startAnimation(View view2, Animation animation, Animation.AnimationListener animationListener);
}
