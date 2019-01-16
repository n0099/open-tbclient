package com.baidu.browser.sailor.b.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.baidu.browser.sailor.a.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        SparseArray sparseArray;
        sparseArray = a.b;
        n nVar = (n) sparseArray.get(10);
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        int intExtra3 = intent.getIntExtra("plugged", 0);
        nVar.addField("level", String.valueOf(intExtra2 != 0 ? intExtra / intExtra2 : 0.0f));
        nVar.addField("plugged", String.valueOf(intExtra3 != 0));
        nVar.qR();
    }
}
