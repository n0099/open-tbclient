package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ NavigationBar Ng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NavigationBar navigationBar) {
        this.Ng = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.Ng.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == com.baidu.tieba.w.navigationBarGoBack) {
                activity2 = this.Ng.mCurrentActivity;
                activity2.finish();
            } else if (id == com.baidu.tieba.w.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.Ng.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2002004, activity));
            }
        }
    }
}
