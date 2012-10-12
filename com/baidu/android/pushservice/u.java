package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import com.baidu.tieba.util.NetWorkCore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ PushTestActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PushTestActivity pushTestActivity) {
        this.a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_DELETE);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.a.a));
        intent.putExtra(PushConstants.EXTRA_MSG_IDS, new String[]{NetWorkCore.NET_TYPE_NET, NetWorkCore.NET_TYPE_WAP});
        this.a.sendBroadcast(intent);
    }
}
