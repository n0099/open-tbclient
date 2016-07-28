package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NavigationBar acn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NavigationBar navigationBar) {
        this.acn = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.acn.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == u.g.navigationBarGoBack) {
                activity2 = this.acn.mCurrentActivity;
                activity2.finish();
            } else if (id == u.g.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.acn.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
