package com.baidu.android.pushservice;

import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ PushTestActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PushTestActivity pushTestActivity) {
        this.a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        new Intent(PushConstants.ACTION_METHOD).putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.EXTRA_APP_ID, "101962");
        intent.setClass(this.a, PushService.class);
        this.a.startService(intent);
    }
}
