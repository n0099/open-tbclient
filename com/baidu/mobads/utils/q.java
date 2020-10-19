package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
/* loaded from: classes7.dex */
class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SharedPreferences f2445a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, SharedPreferences sharedPreferences, String str) {
        this.c = pVar;
        this.f2445a = sharedPreferences;
        this.b = str;
    }

    @Override // java.lang.Runnable
    @TargetApi(9)
    public void run() {
        if (Build.VERSION.SDK_INT >= 9) {
            this.f2445a.edit().putString("deviceid", this.b).apply();
        } else {
            this.f2445a.edit().putString("deviceid", this.b).commit();
        }
    }
}
