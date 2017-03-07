package com.baidu.tbadk.browser;

import android.content.Intent;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ XiubaTbJsBridge Rq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(XiubaTbJsBridge xiubaTbJsBridge, int i) {
        super(i);
        this.Rq = xiubaTbJsBridge;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String packageName;
        Object data = customResponsedMessage.getData();
        if (data == null || !(data instanceof Intent)) {
            return;
        }
        packageName = XiubaTbJsBridge.getPackageName((Intent) data);
        if ("com.xiu8.baidu.activity".equals(packageName)) {
            this.Rq.callInstallListener();
        }
    }
}
