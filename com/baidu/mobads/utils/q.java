package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes3.dex */
class q implements Runnable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SharedPreferences sharedPreferences, String str) {
        this.c = pVar;
        this.a = sharedPreferences;
        this.b = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(9)
    public void run() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.a.edit().putString("deviceid", this.b).apply();
        } else {
            this.a.edit().putString("deviceid", this.b).commit();
        }
    }
}
