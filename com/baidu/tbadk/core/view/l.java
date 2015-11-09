package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ NavigationBar adN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(NavigationBar navigationBar) {
        this.adN = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.adN.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == i.f.navigationBarGoBack) {
                activity2 = this.adN.mCurrentActivity;
                activity2.finish();
            } else if (id == i.f.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.adN.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
