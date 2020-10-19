package com.baidu.mobads.openad.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes7.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private c f2369a;

    public b(c cVar) {
        this.f2369a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.f2369a.b();
        }
    }
}
