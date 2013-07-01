package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f489a;

    private z(w wVar) {
        this.f489a = wVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Handler handler;
        Handler handler2;
        String str;
        if (context != null) {
            handler = this.f489a.f;
            if (handler == null) {
                return;
            }
            this.f489a.k();
            handler2 = this.f489a.f;
            handler2.obtainMessage(41).sendToTarget();
            str = w.f487a;
            ap.a(str, "wifi manager receive new wifi...");
        }
    }
}
