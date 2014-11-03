package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ d Hr;
    private final /* synthetic */ Activity Hs;
    private final /* synthetic */ int Ht;
    private final /* synthetic */ String Hu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Activity activity, int i, String str) {
        this.Hr = dVar;
        this.Hs = activity;
        this.Ht = i;
        this.Hu = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Hs, this.Ht, this.Hu, 11003)));
    }
}
