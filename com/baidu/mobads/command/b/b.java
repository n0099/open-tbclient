package com.baidu.mobads.command.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public a f8197a;

    public b(a aVar) {
        this.f8197a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a aVar;
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || !"lp_close".equals(action) || (aVar = this.f8197a) == null) {
            return;
        }
        aVar.a();
    }
}
