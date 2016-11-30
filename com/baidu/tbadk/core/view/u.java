package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ NavigationBar agc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NavigationBar navigationBar) {
        this.agc = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.agc.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == r.g.navigationBarGoBack) {
                activity2 = this.agc.mCurrentActivity;
                activity2.finish();
            } else if (id == r.g.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.agc.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
