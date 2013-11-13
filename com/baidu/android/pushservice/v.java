package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f762a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PushTestActivity pushTestActivity) {
        this.f762a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_UNBIND);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f762a, 0, new Intent(), 0));
        intent.putExtra("access_token", PushConstants.rsaEncrypt(this.f762a.f686a));
        this.f762a.sendBroadcast(intent);
    }
}
