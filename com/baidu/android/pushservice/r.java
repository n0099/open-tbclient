package com.baidu.android.pushservice;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PushTestActivity pushTestActivity) {
        this.f634a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        new Intent(PushConstants.ACTION_METHOD).putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", this.f634a.getPackageName());
        intent.putExtra(PushConstants.EXTRA_APP_ID, "101962");
        intent.setClass(this.f634a, PushService.class);
        this.f634a.startService(intent);
    }
}
