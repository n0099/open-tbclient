package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PushTestActivity pushTestActivity) {
        this.f644a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_DELETE);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f644a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.f644a.f586a));
        intent.putExtra(PushConstants.EXTRA_MSG_IDS, new String[]{"1", "2"});
        this.f644a.sendBroadcast(intent);
    }
}
