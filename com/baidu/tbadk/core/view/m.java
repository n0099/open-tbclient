package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ NavigationBar aeK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NavigationBar navigationBar) {
        this.aeK = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.aeK.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == n.f.navigationBarGoBack) {
                activity2 = this.aeK.mCurrentActivity;
                activity2.finish();
            } else if (id == n.f.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.aeK.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
