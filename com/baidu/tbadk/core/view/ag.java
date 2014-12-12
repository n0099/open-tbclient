package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ ae Nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.Nv = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        Activity activity2;
        if (view.getId() == com.baidu.tieba.w.search_bg_layout) {
            activity = this.Nv.mCurrentActivity;
            str = this.Nv.Nq;
            TiebaStatic.eventStat(activity, str, "click", 1, new Object[0]);
            MessageManager messageManager = MessageManager.getInstance();
            activity2 = this.Nv.mCurrentActivity;
            messageManager.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(activity2)));
        }
    }
}
