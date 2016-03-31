package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ NavigationBar afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NavigationBar navigationBar) {
        this.afJ = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.afJ.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == t.g.navigationBarGoBack) {
                activity2 = this.afJ.mCurrentActivity;
                activity2.finish();
            } else if (id == t.g.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.afJ.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
