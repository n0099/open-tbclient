package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PushTestActivity pushTestActivity) {
        this.f643a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_COUNT);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f643a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.f643a.f586a));
        this.f643a.sendBroadcast(intent);
    }
}
