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
/* loaded from: classes2.dex */
public class KuangAPKActivityPageContext<T> implements TbPageContext<T> {
    BaseActivity<T> orginal;

    public KuangAPKActivityPageContext(BaseActivity<T> baseActivity) {
        this.orginal = baseActivity;
    }

    @Override // com.baidu.adp.base.e
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.adp.base.e
    public void sendMessage(Message<?> message) {
        this.orginal.sendMessage(message);
    }

    @Override // com.baidu.adp.base.e
    public void sendMessage(NetMessage netMessage) {
        this.orginal.sendMessage(netMessage);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(a aVar) {
        this.orginal.registerListener(aVar);
    }

    public void registerListener(int i, a aVar) {
        this.orginal.registerListener(i, aVar);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        this.orginal.registerListener(messageListener);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(int i, MessageListener<?> messageListener) {
        this.orginal.registerListener(i, messageListener);
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.orginal.getUniqueId();
    }

    @Override // com.baidu.adp.base.e
    public Context getContext() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.adp.base.e
    public Activity getPageActivity() {
        return this.orginal.getActivity();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.baidu.tbadk.BaseActivity<T>] */
    @Override // com.baidu.adp.base.e
    public T getOrignalPage() {
        return this.orginal;
    }

    @Override // com.baidu.adp.base.e
    public Resources getResources() {
        return getPageActivity().getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
        this.orginal.showToast(i);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.orginal.showToast(str, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        this.orginal.showToast(i, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.orginal.getLayoutMode();
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
    public void showToast(String str) {
        this.orginal.showToast(str);
    }
}
