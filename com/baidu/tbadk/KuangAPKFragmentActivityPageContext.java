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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.c.g.a;
import d.a.n0.r.c;
/* loaded from: classes3.dex */
public class KuangAPKFragmentActivityPageContext implements TbPageContext<BaseFragmentActivity> {
    public BaseFragmentActivity orginal;

    public KuangAPKFragmentActivityPageContext(BaseFragmentActivity baseFragmentActivity) {
        this.orginal = baseFragmentActivity;
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Context getContext() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.orginal.getLayoutMode();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Activity getPageActivity() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public Resources getResources() {
        return TbadkCoreApplication.getInst().getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public String getString(int i2) {
        return getResources().getString(i2);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public BdUniqueId getUniqueId() {
        return this.orginal.getUniqueId();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(a aVar) {
        this.orginal.registerListener(aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public void sendMessage(Message<?> message) {
        this.orginal.sendMessage(message);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2) {
        this.orginal.showToast(i2);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        this.orginal.startAnimatable(animatable);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        this.orginal.startAnimation(view, animation, animationListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public BaseFragmentActivity getOrignalPage() {
        return this.orginal;
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i2, a aVar) {
        this.orginal.registerListener(i2, aVar);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void sendMessage(NetMessage netMessage) {
        this.orginal.sendMessage(netMessage);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.orginal.showToast(str, z);
    }

    @Override // com.baidu.tbadk.TbPageContext, d.a.c.a.f
    public void registerListener(MessageListener<?> messageListener) {
        this.orginal.registerListener(messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i2, boolean z) {
        this.orginal.showToast(i2, z);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void registerListener(int i2, MessageListener<?> messageListener) {
        this.orginal.registerListener(i2, messageListener);
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
        this.orginal.showToast(str);
    }
}
