package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ NavigationBar Zk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NavigationBar navigationBar) {
        this.Zk = navigationBar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Activity activity;
        Activity activity2;
        z = this.Zk.mClickIsVaild;
        if (z) {
            int id = view.getId();
            if (id == com.baidu.tieba.q.navigationBarGoBack) {
                activity2 = this.Zk.mCurrentActivity;
                activity2.finish();
            } else if (id == com.baidu.tieba.q.navigationBarHome) {
                MessageManager messageManager = MessageManager.getInstance();
                activity = this.Zk.mCurrentActivity;
                messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2002004, activity));
            }
        }
    }
}
