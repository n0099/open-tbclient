package com.baidu.android.pushservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushTestActivity f756a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PushTestActivity pushTestActivity) {
        this.f756a = pushTestActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, PushConstants.METHOD_DELETE);
        intent.putExtra(PushConstants.EXTRA_APP, PendingIntent.getBroadcast(this.f756a, 0, new Intent(), 0));
        intent.putExtra("access_token", PushConstants.rsaEncrypt(this.f756a.f692a));
        intent.putExtra(PushConstants.EXTRA_MSG_IDS, new String[]{SocialConstants.TRUE, "2"});
        this.f756a.sendBroadcast(intent);
    }
}
