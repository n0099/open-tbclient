package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ao extends BroadcastReceiver {
    final /* synthetic */ am a;

    public ao(am amVar) {
        this.a = amVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        e eVar;
        str = this.a.a;
        ap.a(str, "timer expire,request location...");
        arrayList = this.a.b;
        if (arrayList != null) {
            arrayList2 = this.a.b;
            if (arrayList2.isEmpty()) {
                return;
            }
            eVar = this.a.f;
            eVar.a();
        }
    }
}
