package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ao extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ am f463a;

    public ao(am amVar) {
        this.f463a = amVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        e eVar;
        str = this.f463a.f461a;
        ap.a(str, "timer expire,request location...");
        arrayList = this.f463a.b;
        if (arrayList != null) {
            arrayList2 = this.f463a.b;
            if (arrayList2.isEmpty()) {
                return;
            }
            eVar = this.f463a.f;
            eVar.a();
        }
    }
}
