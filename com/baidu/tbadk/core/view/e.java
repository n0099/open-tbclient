package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ d Hq;
    private final /* synthetic */ Activity Hr;
    private final /* synthetic */ int Hs;
    private final /* synthetic */ String Ht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Activity activity, int i, String str) {
        this.Hq = dVar;
        this.Hr = activity;
        this.Hs = i;
        this.Ht = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(this.Hr, this.Hs, this.Ht, 11003)));
    }
}
