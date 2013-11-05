package com.baidu.android.pushservice.message;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f705a;
    final /* synthetic */ PublicMsg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PublicMsg publicMsg, Context context) {
        this.b = publicMsg;
        this.f705a = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.b.e));
        intent.addFlags(268435456);
        this.f705a.startActivity(intent);
    }
}
