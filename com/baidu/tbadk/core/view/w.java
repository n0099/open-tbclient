package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ NavigationBar ajC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NavigationBar navigationBar) {
        this.ajC = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.ajC.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == w.h.navigationBarGoBack) {
                activity2 = this.ajC.mCurrentActivity;
                activity2.finish();
            } else if (id == w.h.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.ajC.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.START_GO_HOME, activity));
            }
        }
    }
}
