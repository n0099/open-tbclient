package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PushTestActivity pushTestActivity) {
        this.f657a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_UNBIND);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f657a, 0, new Intent(), 0));
        intent.putExtra(PushConstants.EXTRA_ACCESS_TOKEN, PushConstants.rsaEncrypt(this.f657a.f586a));
        this.f657a.sendBroadcast(intent);
    }
}
