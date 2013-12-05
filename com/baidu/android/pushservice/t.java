package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PushTestActivity pushTestActivity) {
        this.f755a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_COUNT);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f755a, 0, new Intent(), 0));
        intent.putExtra("access_token", PushConstants.rsaEncrypt(this.f755a.f692a));
        this.f755a.sendBroadcast(intent);
    }
}
