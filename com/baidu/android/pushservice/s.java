package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PushTestActivity pushTestActivity) {
        this.f351a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_FETCH);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f351a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_FETCH_TYPE, 1);
        intent.putExtra(PushConstants.EXTRA_FETCH_NUM, 2);
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.f351a.f295a));
        this.f351a.sendBroadcast(intent);
    }
}
