package com.baidu.mobads.command.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private a f2367a;

    public b(a aVar) {
        this.f2367a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && "lp_close".equals(action) && this.f2367a != null) {
            this.f2367a.a();
        }
    }
}
