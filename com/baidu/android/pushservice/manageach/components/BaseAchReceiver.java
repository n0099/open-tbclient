package com.baidu.android.pushservice.manageach.components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public abstract class BaseAchReceiver extends BroadcastReceiver {
    public abstract void a(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable unused) {
        }
    }
}
