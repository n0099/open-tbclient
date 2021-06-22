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
import d.a.c.c.g.a;
import d.a.n0.r.c;
/* loaded from: classes3.dex */
public class ProxyAdkBaseActivityPageContext<T> implements TbPageContext<T> {
    public ProxyAdkBaseActivity<T> activity;

    public ProxyAdkBaseActivityPageContext(ProxyAdkBaseActivity<T> proxyAdkBaseActivity) {
        this.activity = proxyAdkBaseActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Context getContext() {
        return this.activity.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.activity.getLayoutMode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tbadk.ProxyAdkBaseActivity<T>, T] */
    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public T getOrignalPage() {
        return this.activity;
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Activity getPageActivity() {
        return this.activity.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Resources getResources() {
        return this.activity.getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public String getString(int i2) {
        return getResources().getString(i2);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public BdUniqueId getUniqueId() {
        return this.activity.getUniqueId();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(a aVar) {
        this.activity.registerListener(aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public void sendMessage(Message<?> message) {
        this.activity.sendMessage(message);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2) {
        this.activity.showToast(i2);
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
    public void registerListener(int i2, a aVar) {
        this.activity.registerListener(i2, aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        this.activity.sendMessage(netMessage);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.activity.showToast(str, z);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public void registerListener(MessageListener<?> messageListener) {
        this.activity.registerListener(messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2, boolean z) {
        this.activity.showToast(i2, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i2, MessageListener<?> messageListener) {
        this.activity.registerListener(i2, messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        this.activity.showToast(str);
    }
}
