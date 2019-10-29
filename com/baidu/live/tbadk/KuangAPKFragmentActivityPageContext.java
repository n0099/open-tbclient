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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class KuangAPKFragmentActivityPageContext implements TbPageContext<BaseFragmentActivity> {
    BaseFragmentActivity orginal;

    public KuangAPKFragmentActivityPageContext(BaseFragmentActivity baseFragmentActivity) {
        this.orginal = baseFragmentActivity;
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(Message<?> message) {
        this.orginal.sendMessage(message);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void sendMessage(NetMessage netMessage) {
        this.orginal.sendMessage(netMessage);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(NetMessageListener netMessageListener) {
        this.orginal.registerListener(netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, NetMessageListener netMessageListener) {
        this.orginal.registerListener(i, netMessageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(MessageListener<?> messageListener) {
        this.orginal.registerListener(messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public void registerListener(int i, MessageListener<?> messageListener) {
        this.orginal.registerListener(i, messageListener);
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public BdUniqueId getUniqueId() {
        return this.orginal.getUniqueId();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Context getContext() {
        return this.orginal.getActivity();
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Activity getPageActivity() {
        return this.orginal.getActivity();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.base.BdPageContext
    public BaseFragmentActivity getOrignalPage() {
        return this.orginal;
    }

    @Override // com.baidu.live.adp.base.BdPageContext
    public Resources getResources() {
        return TbadkCoreApplication.getInst().getResources();
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i) {
        this.orginal.showToast(i);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
        this.orginal.showToast(str, z);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
        this.orginal.showToast(i, z);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public BDLayoutMode getLayoutMode() {
        return this.orginal.getLayoutMode();
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
        this.orginal.startAnimatable(animatable);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
        this.orginal.startAnimation(view, animation, animationListener);
    }

    @Override // com.baidu.live.tbadk.TbPageContext
    public void showToast(String str) {
        this.orginal.showToast(str);
    }
}
