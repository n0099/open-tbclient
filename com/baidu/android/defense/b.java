package com.baidu.android.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f498a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f498a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f498a.a(intent);
    }
}
