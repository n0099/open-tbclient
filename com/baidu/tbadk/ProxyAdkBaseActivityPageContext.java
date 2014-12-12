package com.baidu.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.c;
/* loaded from: classes.dex */
public class ProxyAdkBaseActivityPageContext<T> implements TbPageContext<T> {
    ProxyAdkBaseActivity<T> activity;

    public ProxyAdkBaseActivityPageContext(ProxyAdkBaseActivity<T> proxyAdkBaseActivity) {
        this.activity = proxyAdkBaseActivity;
    }

    @Override // com.baidu.adp.base.j
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.adp.base.j
    public void sendMessage(Message<?> message) {
        this.activity.sendMessage(message);
    }

    public void sendMessage(NetMessage netMessage) {
        this.activity.sendMessage(netMessage);
    }

    public void registerListener(a aVar) {
        this.activity.registerListener(aVar);
    }

    public void registerListener(int i, a aVar) {
        this.activity.registerListener(i, aVar);
    }

    @Override // com.baidu.adp.base.j
    public void registerListener(MessageListener<?> messageListener) {
        this.activity.registerListener(messageListener);
    }

    public void registerListener(int i, MessageListener<?> messageListener) {
        this.activity.registerListener(i, messageListener);
    }

    @Override // com.baidu.adp.base.j
    public BdUniqueId getUniqueId() {
        return this.activity.getUniqueId();
    }

    @Override // com.baidu.adp.base.j
    public Context getContext() {
        return this.activity.getActivity();
    }

    @Override // com.baidu.adp.base.j
    public Activity getPageActivity() {
        return this.activity.getActivity();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tbadk.ProxyAdkBaseActivity<T>, T] */
    @Override // com.baidu.adp.base.j
    public T getOrignalPage() {
        return this.activity;
    }

    @Override // com.baidu.adp.base.j
    public Resources getResources() {
        return this.activity.getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        this.activity.showToast(i);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.activity.showToast(str, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        this.activity.showToast(i, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.activity.getLayoutMode();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        this.activity.startAnimatable(animatable);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        this.activity.startAnimation(view, animation, animationListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        this.activity.showToast(str);
    }
}
