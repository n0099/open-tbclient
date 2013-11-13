package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PushTestActivity pushTestActivity) {
        this.f727a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_BIND);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f727a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_BIND_NAME, "com.baidu.appsearch");
        intent.putExtra(PushConstants.EXTRA_BIND_STATUS, 1);
        intent.putExtra("access_token", PushConstants.rsaEncrypt(this.f727a.f686a));
        this.f727a.sendBroadcast(intent);
    }
}
