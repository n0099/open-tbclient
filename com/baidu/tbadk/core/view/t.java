package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ NavigationBar afC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NavigationBar navigationBar) {
        this.afC = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.afC.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == r.g.navigationBarGoBack) {
                activity2 = this.afC.mCurrentActivity;
                activity2.finish();
            } else if (id == r.g.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.afC.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
