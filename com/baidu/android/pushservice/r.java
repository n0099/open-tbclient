package com.baidu.android.pushservice;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f599a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PushTestActivity pushTestActivity) {
        this.f599a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        new Intent(PushConstants.ACTION_METHOD).putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", this.f599a.getPackageName());
        intent.putExtra(PushConstants.EXTRA_APP_ID, "101962");
        intent.setClass(this.f599a, PushService.class);
        this.f599a.startService(intent);
    }
}
