package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PushTestActivity pushTestActivity) {
        this.f642a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_FETCH);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f642a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_FETCH_TYPE, 1);
        intent.putExtra(PushConstants.EXTRA_FETCH_NUM, 2);
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.f642a.f586a));
        this.f642a.sendBroadcast(intent);
    }
}
