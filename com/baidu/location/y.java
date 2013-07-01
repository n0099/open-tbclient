package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f488a;

    private y(w wVar) {
        this.f488a = wVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || w.b(this.f488a) == null) {
            return;
        }
        w.c(this.f488a);
    }
}
