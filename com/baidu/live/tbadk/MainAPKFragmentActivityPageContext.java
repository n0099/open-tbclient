package com.baidu.live.tbadk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.listener.MessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.BDLayoutMode;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
/* loaded from: classes7.dex */
public class MainAPKFragmentActivityPageContext implements TbPageContext<BaseFragmentActivity> {
    BaseFragmentActivity activity;

    public MainAPKFragmentActivityPageContext(BaseFragmentActivity baseFragmentActivity) {
        this.activity = baseFragmentActivity;
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(Message<?> message) {
        this.activity.sendMessage(message);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(NetMessage netMessage) {
        this.activity.sendMessage(netMessage);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(NetMessageListener netMessageListener) {
        this.activity.registerListener(netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, NetMessageListener netMessageListener) {
        this.activity.registerListener(i, netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(MessageListener<?> messageListener) {
        this.activity.registerListener(messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        this.activity.registerListener(i, messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public BdUniqueId getUniqueId() {
        return this.activity.getUniqueId();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Context getContext() {
        return this.activity.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Activity getPageActivity() {
        return this.activity.getActivity();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.base.BdPageContext
    public BaseFragmentActivity getOrignalPage() {
        return this.activity;
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Resources getResources() {
        return this.activity.getResources();
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i) {
        this.activity.showToast(i);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.activity.showToast(str, z);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        this.activity.showToast(i, z);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public BDLayoutMode getLayoutMode() {
        return this.activity.getLayoutMode();
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        this.activity.startAnimatable(animatable);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        this.activity.startAnimation(view, animation, animationListener);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str) {
        this.activity.showToast(str);
    }
}
