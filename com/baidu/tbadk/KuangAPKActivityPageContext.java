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
import d.b.c.c.g.a;
import d.b.i0.r.c;
/* loaded from: classes3.dex */
public class KuangAPKActivityPageContext<T> implements TbPageContext<T> {
    public BaseActivity<T> orginal;

    public KuangAPKActivityPageContext(BaseActivity<T> baseActivity) {
        this.orginal = baseActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public Context getContext() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.orginal.getLayoutMode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.baidu.tbadk.BaseActivity<T>] */
    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public T getOrignalPage() {
        return this.orginal;
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public Activity getPageActivity() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public Resources getResources() {
        return getPageActivity().getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public BdUniqueId getUniqueId() {
        return this.orginal.getUniqueId();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(a aVar) {
        this.orginal.registerListener(aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public void sendMessage(Message<?> message) {
        this.orginal.sendMessage(message);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        this.orginal.showToast(i);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        this.orginal.startAnimatable(animatable);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        this.orginal.startAnimation(view, animation, animationListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, a aVar) {
        this.orginal.registerListener(i, aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        this.orginal.sendMessage(netMessage);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.orginal.showToast(str, z);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.b.c.a.f
    public void registerListener(MessageListener<?> messageListener) {
        this.orginal.registerListener(messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        this.orginal.showToast(i, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        this.orginal.registerListener(i, messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        this.orginal.showToast(str);
    }
}
