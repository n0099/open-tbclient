package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PushTestActivity pushTestActivity) {
        this.f749a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_COUNT);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f749a, 0, new Intent(), 0));
        intent.putExtra("access_token", PushConstants.rsaEncrypt(this.f749a.f686a));
        this.f749a.sendBroadcast(intent);
    }
}
